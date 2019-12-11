package com.jk.gatway.auth;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author jk
 * @Date: 2019/12/9
 */
public class JwtAuthUtil {

    /**
     * token秘钥，请勿泄露，请勿随便修改 backups:JKKLJOoasdlfj
     */
    public static final String SECRET = "JK-Authorize-Certificate";

    //10分钟后刷新token
    private static final int tokenRefreshInterval = 60 * 10;

    String createToken(String userName , String userPassword){

        return null;
    }

    /**
     * 判断是否需要刷新TOKEN
     * @param issueAt token签发日期
     * @return 是否需要刷新TOKEN
     */
    private boolean shouldTokenRefresh(Date issueAt) {
        LocalDateTime issueTime = LocalDateTime.ofInstant(issueAt.toInstant(), ZoneId.systemDefault());
        return LocalDateTime.now().minusSeconds(tokenRefreshInterval).isAfter(issueTime);
    }
}
