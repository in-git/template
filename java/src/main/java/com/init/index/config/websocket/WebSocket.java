package com.init.index.config.websocket;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.init.index.config.plugin.SpringContextUtil;
import com.init.index.config.redis.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.socket.server.standard.SpringConfigurator;

import javax.swing.*;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.security.Principal;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
@CrossOrigin
@ServerEndpoint ( value = "/websocket/{userId}" )
public class WebSocket {
    //      记录当前在线连接数
    private static int onlineCount = 0;
    //      存放每个客户端的MyWebSocket对象
    private static ConcurrentHashMap < String, WebSocket > webSocketMap = new ConcurrentHashMap <>( );
    //      通过它发送数据给客户端
    private Session session;
    //      接收userId
    private String userId = "";


    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext( RedisUtil.class );

    /**
     * 功能:
     * 1.连接建立成功调用的方法
     * 2.在线人数统计
     * 3.发送响应消息
     */
    @OnOpen
    public void onOpen ( Session session , @PathParam ( "userId" ) String userId ) {
        this.session = session;
        this.userId  = userId;
        if ( webSocketMap.containsKey( userId ) ) {
            webSocketMap.remove( userId );
            webSocketMap.put( userId , this );
        } else {
            webSocketMap.put( userId , this );
            addOnlineCount( );    //在线数加1
        }
        try {

            sendMessage( "连接成功" );
        }
        catch ( IOException e ) {
            log.error( "用户:" + userId + ",网络异常!!!!!!" );
        }
    }

    /**
     * 功能：
     * 1.连接关闭调用的方法
     * 2.在线人数-1
     */
    @OnClose
    public void onClose ( ) {
        if ( webSocketMap.containsKey( userId ) ) {
            webSocketMap.remove( userId );
            subOnlineCount( );                                                       //  在线人数 -1
        }
    }

    /**
     * 功能:
     * 收到消息后调用
     * 向一个ID发送消息
     * 参数:
     * (String)message: 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage ( String message , Session session ) {
        if ( !StringUtils.isEmpty( message ) ) {
            try {
                //解析发送的报文
                JSONObject jsonObject = JSON.parseObject( message );
                //追加发送人(防止串改)
                jsonObject.put( "fromUserId" , this.userId );
                String toUserId = jsonObject.getString( "toUserId" );
                if ( !StringUtils.isEmpty( toUserId ) && webSocketMap.containsKey( toUserId ) ) {
                    webSocketMap.get( toUserId ).sendMessage( jsonObject.toJSONString( ) );
                } else {
                    log.error( "请求的userId:" + toUserId + "不在该服务器上" );
                    //否则不在这个服务器上，发送到mysql或者redis
                }
            }
            catch ( Exception e ) {
                e.printStackTrace( );
            }
        }
    }

    //      功能:出现错误调用的方法
    @OnError
    public void onError ( Session session , Throwable error ) {
        error.printStackTrace( );
    }

    //      功能:实现服务器主动推送
    public void sendMessage ( String message ) throws IOException {
        this.session.getBasicRemote( ).sendText( message );
    }


    //      功能:发送自定义消息
    public static void sendInfo ( String message , @PathParam ( "userId" ) String userId ) throws IOException {
        if ( StringUtils.isEmpty( userId ) && webSocketMap.containsKey( userId ) ) {
            webSocketMap.get( userId ).sendMessage( message );
        } else {
        }
    }

    //      功能:获取在线总人数
    public static synchronized int getOnlineCount ( ) {
        return onlineCount;
    }

    public static synchronized void addOnlineCount ( ) {
        WebSocket.onlineCount++;
    }

    public static synchronized void subOnlineCount ( ) {
        WebSocket.onlineCount--;
    }
}

