package com.init.global.utils;

import java.util.HashMap;

/*
方法预览
    msg()：返回一段信息,状态为SUCCESS
*/
public class Res extends HashMap{
    private final static Integer STATUS_SUCCESS = 1;
    private HashMap<String, Object> map;


    //返回成功消息
    public static Res msg(Object msg) {
        return new Res().addData(msg);

    }

    public static HashMap<String, Object> msg() {
        HashMap<String, Object> info = new HashMap<String, Object>();
        info.put("status", STATUS_SUCCESS);
        return info;
    }

    //返回错误提示
    public static HashMap<String, Object> err() {
        HashMap<String, Object> info = new HashMap<String, Object>();
        Integer STATUS_ERROR = -1;
        info.put("status", STATUS_ERROR);
        return info;
    }

    //    返回数据
    public static HashMap<String, Object> data(Object data) {
        HashMap<String, Object> info = new HashMap<String, Object>();
        info.put("status", STATUS_SUCCESS);
        info.put("msg", data);
        return info;
    }

    private Res addData(Object data) {
        Res res = new Res();
        res.map.put("status", STATUS_SUCCESS);
        res.map.put("data", data);
        return res;
    }
}
