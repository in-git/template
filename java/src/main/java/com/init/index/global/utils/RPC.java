package com.init.index.global.utils.common;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class RPC {
    /*
     * 功能:发送普通请求
     * 参数:
     *      (String)url：将要调用的连接
     * 返回值:
     *      (String)result:url的响应结果
     * */
    public String doGet(String url) {
        RestTemplate template = new RestTemplate();
        String result = template.postForObject(url , null , String.class);
        return result;
    }

    /*
     * 功能:发送普通请求
     * 参数:
     *      (String)url：将要调用的连接
     * 返回值:
     *      (String)result:url的响应结果
     * */
    public String doGet(String url , MultiValueMap params) {
        RestTemplate template = new RestTemplate();
        // 封装参数为LinkedMultiValueMap类型，否则参数无法传递
        // MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
        String result = template.postForObject(url , params , String.class);
        return result;
    }
}
