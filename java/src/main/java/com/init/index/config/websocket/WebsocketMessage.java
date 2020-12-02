package com.init.index.config.websocket;

import com.init.index.config.plugin.SpringContextUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping ( "public" )
public class WebsocketMessage {


    @RequestMapping ( "/push/{userId}" )
    public ResponseEntity < String > pushToWeb ( String message , @PathVariable String userId ) throws IOException {
        System.out.println( message );
        WebSocket.sendInfo( message , userId );
        return ResponseEntity.ok( "MSG SEND SUCCESS" );
    }

    @RequestMapping ( "/getOnlineCount" )
    public int getOnlineCount ( ) {
        return WebSocket.getOnlineCount( );
    }
}
