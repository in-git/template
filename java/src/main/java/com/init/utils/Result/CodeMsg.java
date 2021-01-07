package com.zzsoft.utils.Result;

public class CodeMsg {  
    private int retCode;  
    private String message;  
    // 按照模块定义CodeMsg  
    // 通用异常  
    public static CodeMsg SUCCESS = new CodeMsg(10000,"success");  
    public static CodeMsg ERROR = new CodeMsg(-10000,"err");  
    public static CodeMsg SERVER_EXCEPTION = new CodeMsg(500100,"服务端异常");  
    public static CodeMsg PARAMETER_EXCEPTION = new CodeMsg(500101,"输入参数异常");  

      
    private CodeMsg(int retCode, String message) {  
        this.retCode = retCode;  
        this.message = message;  
    }  
    public int getRetCode() {  
        return retCode;  
    }  
    public String getMessage() {  
        return message;  
    }  
    public void setMessage(String message) {  
        this.message = message;  
    }  
} 