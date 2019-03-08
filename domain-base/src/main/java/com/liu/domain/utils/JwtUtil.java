package com.liu.domain.utils;


import com.google.common.collect.Maps;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author : liqi
 * Date: 2018-09-04
 * Time: 15:19
 */
public class JwtUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtUtil.class);

    static final long EXPIRATION_TIME = 1000*60*60*24;
    static final String SECRET = "mydao@safe#auth$";
    static final String TOKEN_PREFIX = "Bearer";

    public static String generateToken(String uid) {
        HashMap<String, Object> map = new HashMap<>();
        //you can put any data in the map
        map.put("uid", uid);
        String jwt = Jwts.builder()
                .setClaims(map)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        return jwt;
    }

    public static Map<String,Object> validateToken(String token) {
        Map<String,Object> result = Maps.newHashMap();
        result.put("code",401);
        try {
            if (token != null) {
                // parse the token.
                Jws<Claims> claims = Jwts.parser()
                        .setSigningKey(SECRET)
                        .parseClaimsJws(token.replace(TOKEN_PREFIX, ""));
                Map<String,Object> body =  claims.getBody();
                String uid = (String) (body.get("uid"));
                if(uid == null || uid.isEmpty()) {
                    result.put("msg","用户"+uid+"对应的token无效");
                }else {
                    result.put("code",200);
                    result.put("msg","ok");
                    result.put("uid",uid);
                }
            }else{
                result.put("msg","token无效");
            }
        } catch (ExpiredJwtException e) {
            LOGGER.error("登陆已过期",e);
            result.put("msg","登陆已过期，请重新登陆");
        } catch (UnsupportedJwtException e) {
            LOGGER.error("token非法",e);
            result.put("msg","登陆已过期，请重新登陆");
        } catch (MalformedJwtException e) {
            LOGGER.error("jwt未能正常被构造",e);
            result.put("msg","非法登陆");
        } catch (SignatureException e) {
            LOGGER.error("签名计算失败",e);
            result.put("msg","非法登陆");
        } catch (IllegalArgumentException e) {
            LOGGER.error("token参数非法",e);
            result.put("msg","非法登陆");
        }
        return result;
    }
}
