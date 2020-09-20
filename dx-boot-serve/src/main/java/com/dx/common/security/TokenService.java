package com.dx.common.security;

import com.dx.common.constants.Constants;
import com.dx.common.redis.RedisCache;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Description: com.dx.common.security
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2020/9/13
 */
@Component
public class TokenService {


    @Value("${token.header}")
    private String header;
    @Value("${token.secret}")
    private String secret;
    /**
     * 令牌有效期（默认30分钟）
     */
    @Value("${token.expireTime}")
    private int expireTime;

    //1秒
    protected static final long MILLIS_SECOND = 1000;

    //1分钟
    protected static final long MILLIS_MINUTE = 60 * MILLIS_SECOND;

    //20分钟
    private static final Long MILLIS_MINUTE_TEN = 20 * 60 * 1000L;

    @Autowired
    private RedisCache redisCache;

    /**
     * 获取用户身份信息
     *
     * @return 用户信息
     */
    public MyUserDetails getMyUserDetails(HttpServletRequest request) {
        // 获取请求携带的令牌
        String token = getToken(request);
        if (!StringUtils.isEmpty(token)) {
            Claims claims = parseToken(token);
            // 解析对应的权限以及用户信息
            String uuid = (String) claims.get(Constants.LOGIN_USER_KEY);
            String userKey = getTokenKey(uuid);
            MyUserDetails user = redisCache.getCacheObject(userKey);
            return user;
        }
        return null;
    }


    /**
     * 验证令牌有效期，相差不足20分钟，自动刷新缓存
     *
     * @param userDetails 令牌
     * @return 令牌
     */
    public void verifyToken(MyUserDetails userDetails) {
        long expireTime = userDetails.getExpireTime();
        long currentTime = System.currentTimeMillis();
        if (expireTime - currentTime <= MILLIS_MINUTE_TEN) {
            refreshToken(userDetails);
        }
    }

    /**
     * 刷新令牌有效期
     *
     * @param userDetails 登录信息
     */
    public void refreshToken(MyUserDetails userDetails) {
        userDetails.setLoginTime(System.currentTimeMillis());
        userDetails.setExpireTime(userDetails.getLoginTime() + expireTime * MILLIS_MINUTE);
        // 根据uuid将loginUser缓存
        String userKey = getTokenKey(userDetails.getToken());
        redisCache.setCacheObject(userKey, userDetails, expireTime, TimeUnit.MINUTES);
    }


    /**
     * 从令牌中获取数据声明
     *
     * @param token 令牌
     * @return 数据声明
     */
    private Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * 从令牌中获取用户名
     *
     * @param token 令牌
     * @return 用户名
     */
    public String getUsernameFromToken(String token) {
        Claims claims = parseToken(token);
        return claims.getSubject();
    }

    /**
     * 获取请求token
     *
     * @param request
     * @return token
     */
    private String getToken(HttpServletRequest request) {
        String token = request.getHeader(header);
        if (!StringUtils.isEmpty(token) && token.startsWith(Constants.TOKEN_PREFIX)) {
            token = token.replace(Constants.TOKEN_PREFIX, "");
        }
        return token;
    }

    private String getTokenKey(String uuid) {
        return Constants.LOGIN_TOKEN_KEY + uuid;
    }

    /**
     * 创建令牌
     *
     * @param myUserDetails 用户信息
     * @return 令牌
     */
    public String createToken(MyUserDetails myUserDetails) {
        String token = UUID.randomUUID().toString().replace("-", "");
        myUserDetails.setToken(token);
        refreshToken(myUserDetails);

        Map<String, Object> claims = new HashMap<>();
        claims.put(Constants.LOGIN_USER_KEY, token);
        claims.put(Constants.LOGIN_USER_NAME, myUserDetails.getUsername());
        return createToken(claims);
    }

    /**
     * 从数据声明生成令牌
     *
     * @param claims 数据声明
     * @return 令牌
     */
    private String createToken(Map<String, Object> claims) {
        String token = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret).compact();
        return token;
    }

    /**
     * 删除用户身份信息
     *
     * @param token
     */
    public void delMyUserDetails(String token) {
        if (!StringUtils.isEmpty(token)) {
            String userKey = getTokenKey(token);
            redisCache.deleteObject(userKey);
        }
    }

    /**
     * 获取用户身份信息
     *
     * @param request
     * @return
     */
    public MyUserDetails getDetailUser(HttpServletRequest request) {
        // 获取请求携带的令牌
        String token = getToken(request);
        if (!StringUtils.isEmpty(token)) {
            Claims claims = parseToken(token);
            // 解析对应的权限以及用户信息
            String uuid = (String) claims.get(Constants.LOGIN_USER_KEY);
            String userKey = getTokenKey(uuid);
            MyUserDetails userDetails = redisCache.getCacheObject(userKey);
            return userDetails;
        }
        return null;
    }
}

