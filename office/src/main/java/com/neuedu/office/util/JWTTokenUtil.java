package com.neuedu.office.util;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import com.neuedu.office.config.Audience;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


public abstract class JWTTokenUtil {
	public static final String AUTH_HEAD_KEY = "Authorization";
	
	public static String createJWT(String userid,String username,Audience audience) {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		long begin_millis = System.currentTimeMillis();
		Date begin_date = new Date(begin_millis);
		byte[] api = DatatypeConverter.parseBase64Binary(audience.getBase64Secret());
		Key key = new SecretKeySpec(api, signatureAlgorithm.getJcaName());
		Map<String, Object> header = new HashMap<String, Object>();
		header.put("alg", SignatureAlgorithm.HS256.getValue());
		header.put("type", "JWT");
		JwtBuilder builder = Jwts.builder().setHeader(header)
				.claim("userid", userid)
				.setSubject(username)
				.setIssuer(audience.getClientid())
				.setIssuedAt(new Date())
				.setAudience(audience.getName())
				.signWith(signatureAlgorithm, key);
		int time = audience.getExpiresSecond();
		if (time > 0) {
			long exp = begin_millis + time*1000;
			Date exp_date = new Date(exp);
			builder.setExpiration(exp_date)
				.setNotBefore(begin_date);
		}
		return builder.compact();
	}
	
	public static Claims parseJWT(String token,String base64Security) {
		//parseClaimsJwt方法有异常
		Claims claims = Jwts.parser()
				.setSigningKey(DatatypeConverter.parseBase64Binary(base64Security))
				.parseClaimsJws(token)
				.getBody();
		return claims;
	}
	
	public static String getUserName(String token,String base64Security) {
		return parseJWT(token, base64Security).getSubject();
	}
	
	public static String getUserId(String token,String base64Security) {
		return parseJWT(token, base64Security).get("userid",String.class);
	}
	
	public static boolean isExpiration(String token,String base64Security) {
		return parseJWT(token, base64Security).getExpiration().before(new Date());
	}
}
