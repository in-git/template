package com.init.global.token;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {
    private static final long EXPIRE = 60 * 1000; //过期时间

    public static final SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);//密钥，动态生成的密钥


    /*
     功能:
         根据传入的参数,生成token,通过解析后获取信息
     参数
          claims：要传送的消息
     */
    public static String generate(final Map<String, Object> claims) {
        final Date nowDate = new Date();
        //过期时间,设定为一分钟
        final Date expireDate = new Date(System.currentTimeMillis() + EXPIRE);
        //头部信息
        final Map<String, Object> header = new HashMap<>(2);
        header.put("typ", "jwt");

        //更强的密钥,JDK11起才能用
        //  KeyPair keyPair = Keys.keyPairFor(SignatureAlgorithm.RS256);
        //  PrivateKey key1 =  keyPair.getPrivate();  // 私钥
        //PublicKey key2 =  keyPair.getPublic();  //公钥

        return Jwts.builder().setHeader(header)
                // .setSubject("weimi")//主题
                // .setIssuer("weimi") //发送方
                .setClaims(claims)  //自定义claims
                .setIssuedAt(nowDate)//当前时间
                .setExpiration(expireDate) //过期时间
                .signWith(key)//签名算法和key
                .compact();
    }

    /*
     功能:
         根据传入的参数,生成token,通过解析后获取信息
     参数
          claims：要传送的消息
          header:将信息写入请求头
     */
    public static String generate(final Map<String, Object> header, final Map<String, Object> claims) {
        final Date nowDate = new Date();
        //过期时间,设定为一分钟
        final Date expireDate = new Date(System.currentTimeMillis() + EXPIRE);

        return Jwts.builder().setHeader(header)
                // .setSubject("weimi")//主题
                //    .setIssuer("weimi") //发送方
                .setClaims(claims)  //自定义claims
                .setIssuedAt(nowDate)//当前时间
                .setExpiration(expireDate) //过期时间
                .signWith(key)//签名算法和key
                .compact();
    }


    /*
    功能:1.校验签名是否正确
    * */
    public static boolean isSigned(final String token) {
        return Jwts.parser()
                .setSigningKey(key)
                .isSigned(token);
    }

    /**
     * 校验签名是否正确，不会报错
     */
    public static boolean verify(final String token) {
        try {
            Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(token);
            return true;
        } catch (final JwtException e) {
            return false;
        }
    }


    /**
        功能:校验成功后，获取信息
        ex：如获取userId：getClaim(token).get("userId");
     */
    public static Claims getClaim(final String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return claims;
    }


    /**
     功能:校验成功后，获取信息
     ex：getHeader(token).get("alg");
     */
    public static JwsHeader getHeader(final String token) {
        JwsHeader header = null;
        try {
            header = Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(token)
                    .getHeader();
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return header;
    }

    /**
        功能:获取jwt发布时间
     */
    public static Date getIssuedAt(final String token) {
        return getClaim(token).getIssuedAt();
    }

    /**
        功能:获取jwt失效时间
     */
    public static Date getExpiration(final String token) {
        return getClaim(token).getExpiration();
    }


    /**
         功能:验证token是否失效
     */
    public static boolean isExpired(final String token) {
        try {
            final Date expiration = getExpiration(token);
            return expiration.before(new Date());
        } catch (final ExpiredJwtException expiredJwtException) {
            return true;
        }
    }

    /**
     * 直接Base64解密获取header内容
     *
     * @param token
     * @return
     */
    public static String getHeaderByBase64(final String token) {
        String header = null;
        if (isSigned(token)) {
            try {
                final byte[] header_byte = Base64.getDecoder().decode(token.split("\\.")[0]);
                header = new String(header_byte);
            } catch (final Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return header;
    }

    /**
     * 直接Base64解密获取payload内容
     *
     * @param token
     * @return
     */
    public static String getPayloadByBase64(final String token) {
        String payload = null;
        if (isSigned(token)) {
            try {
                final byte[] payload_byte = Base64.getDecoder().decode(token.split("\\.")[1]);
                payload = new String(payload_byte);
            } catch (final Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return payload;
    }

    public static void main(final String[] args) {
        //用户自定义信息claims
        final Map<String, Object> map = new HashMap<>();
        map.put("userId", "test122");
        final String token = generate(map);
        System.out.println(token);

        System.out.println("claim:" + getClaim(token).get("userId"));
        System.out.println("header:" + getHeader(token));
        //    System.out.println(getIssuedAt(token));
        final Claims claims = getClaim(token);

        //  System.out.println(getHeaderByBase64(token));
        System.out.println(getPayloadByBase64(token));

        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy‐MM‐dd hh:mm:ss");
        System.out.println("签发时间:" + sdf.format(claims.getIssuedAt()));
        System.out.println("过期时间:" + sdf.format(claims.getExpiration()));
        System.out.println("当前时间:" + sdf.format(new Date()));

    }
}
