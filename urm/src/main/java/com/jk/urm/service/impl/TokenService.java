package com.jk.urm.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.jk.urm.entity.User;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenService {
    /**
     * APP登录Token的生成和解析
     *
     */

    /**
     * token秘钥，请勿泄露，请勿随便修改 backups:JKKLJOoasdlfj
     */
    public static final String SECRET = "JK-Authorize-Certificate";
    /**
     * token 过期时间: 1天
     */
    public static final int calendarField = Calendar.MINUTE;//时间单位
    public static final int calendarInterval = 10;//时间长度

    static String iss = "jk";

    public String getToken(User user) {
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 60 * 60 * 1000;//一小时有效时间
        Date end = new Date(currentTime);
        String token = "";
//生成token
        token = JWT.create().withAudience(String.valueOf(user.getId())).withIssuedAt(start).withExpiresAt(end).withIssuer(iss)
                .sign(Algorithm.HMAC256(user.getUserPassword()));
        /*----------------------------------------------------------------------------------------------------------------------------------*/
        Date iatDate = new Date();
        // expire time
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(calendarField, calendarInterval);
        Date expiresDate = nowTime.getTime();

        // header Map
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");

        // build token
        // param backups {iss:Service, aud:APP}
        token = JWT.create().withHeader(map) // header
                .withClaim("iss", "Service") // payload
                .withClaim("aud", "APP")
                .withClaim("user_id", null == user.getId() ? null : user.getId().toString())
                .withIssuer(user.getId().toString())
                .withIssuedAt(iatDate) // sign time
                .withExpiresAt(expiresDate) // 过期时间
                .sign(Algorithm.HMAC256(SECRET)); // signature
        /*----------------------------------------------------------------------------------------------------------------------------------*/


        return token;
    }

    public Map validateToken(String token) {
        Map<String, Object> resp = new HashMap<String, Object>();
        resp.put("RESULT", false);
        resp.put("userId",null);
        if (token != null) {
            try {

                DecodedJWT jwt = JWT.decode(token);

                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(SECRET))
                        .withIssuer(jwt.getClaim("user_id").asString())
                        .build();

                jwtVerifier.verify(token);

                resp.put("RESULT", true);
                resp.put("userId",jwt.getClaim("user_id").asString());

            }catch (TokenExpiredException e){
//                e.printStackTrace();
                resp.put("ERR_MSG", "token已过期");
            }catch (SignatureVerificationException | JWTDecodeException e){
//                e.printStackTrace();
                resp.put("ERR_MSG", "token被篡改");
            }
        } else {
//            resp.put("ERR_MSG",Constants.ERR_MSG_TOKEN_EMPTY);
            resp.put("ERR_MSG", "需要登录凭证");
        }
        return resp;
    }

}
