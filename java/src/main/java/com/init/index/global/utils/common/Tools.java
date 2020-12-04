package com.init.index.global.utils.common;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class Tools {
    /**
     * 功能:获得用户远程地址
     */
    public static String getRemoteAddr(HttpServletRequest request) {
        String ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {

                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                }
                catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress = inet.getHostAddress();
            }
        }
        if (ipAddress != null && ipAddress.length() > 15) { //"***.***.***.***".length() = 15
            if (ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0 , ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }

    /*
     * 功能:生成(min,max)之间的随机数
     * */

    public static long getRandom(int max , int min) {
        return Math.abs((long) (Math.random() * (max - min) + min));
    }

    /*
        功能:返回一个不会重复的数
    * */

    public static int getRandomNumber() {
        Random random = new Random(System.currentTimeMillis());
        return Math.abs(random.nextInt());
    }

    /*
        功能:生成UUID
    * */

    public static String getId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-" , "");
    }


    /*
       功能:生成数字UUID
   * */
    public static long getNumberId() {
        long ltime = 0;
        long tmpID = 0;
        boolean tmpIDlocked = false;
        while (true) {
            if (tmpIDlocked == false) {
                tmpIDlocked = true;
                //当前：（年、月、日、时、分、秒、毫秒）*10000
                ltime = Long.valueOf(new SimpleDateFormat("yyMMddhhmmssSSS").format(new Date()).toString()) * 10000;
                if (tmpID < ltime) {
                    tmpID = ltime;
                } else {
                    tmpID = tmpID + 1;
                    ltime = tmpID;
                }
                tmpIDlocked = false;
                return ltime;
            }
        }
    }

}
