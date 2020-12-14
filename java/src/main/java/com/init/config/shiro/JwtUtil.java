package com.init.config.shiro;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JwtUtil {
	/**
	 * 过期时间一天， 1000 * 24 * 60 * 60 一天 1000 * 60 * 60 一小时 15 * 60 * 1000 15分钟
	 */
	private static final long EXPIRE_TIME = 15 * 60 * 1000;
	/**
	 * token私钥
	 */
	private static final String TOKEN_SECRET = "f26e587c28064d0e8c5e7220a6a0e631";

	/**
	 * 校验token是否正确
	 *
	 * @param token 密钥
	 * @return 是否正确
	 */
	public static boolean verify(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
			JWTVerifier verifier = JWT.require(algorithm).build();
			DecodedJWT jwt = verifier.verify(token);
			return true;
		} catch (Exception exception) {
			return false;
		}
	}

	/**
	 * 获得token中的信息无需secret解密也能获得
	 * 
	 * @return token中包含的用户名
	 */
	public static String parseByTag(String token, String tag) {
		try {
			DecodedJWT jwt = JWT.decode(token);
			return jwt.getClaim(tag).asString();
		} catch (JWTDecodeException e) {
			return null;
		}
	}

	/**
	 * 获取登陆用户ID
	 * 
	 * @param token
	 * @return
	 */
	public static String getUserId(String token) {
		try {
			DecodedJWT jwt = JWT.decode(token);
			return jwt.getClaim("id").asString();
		} catch (JWTDecodeException e) {
			return null;
		}
	}

	/**
	 * 生成签名,15min后过期
	 * 
	 * @return 加密的token
	 */
	public static String generator(HashMap<String,String> map) {
		try {
//            过期时间
			Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
//            私钥及加密算法
			Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
//            设置头部信息
			Map<String, Object> header = new HashMap<>(2);
			header.put("typ", "JWT");
			header.put("alg", "HS256");
			// 附带用户信息，生成签名
			return JWT.create().withHeader(header)
					// 要往token中存储的东西
					.withClaim("username", map.get("username"))
					.withExpiresAt(date).sign(algorithm);
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}

}