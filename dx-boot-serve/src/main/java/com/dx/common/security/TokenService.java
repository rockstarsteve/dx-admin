package com.dx.common.security;

import com.dx.common.constants.CommonEnum;
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

    @Value("${token.header:Authorization}")
    private String header;
    @Value("${token.secret}")
    private String secret;
    @Value("${token.expireTime:1}")
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
     * 从reques中获取token
     *
     * @param request
     * @return token
     */
    private String getToken(HttpServletRequest request) {
        String token = request.getHeader(header);
        if (token == null) {
            token = request.getParameter("token");
        }

        if (StringUtils.hasText(token) && token.startsWith(CommonEnum.TOKEN_PREFIX.value())) {
            token = token.replace(CommonEnum.TOKEN_PREFIX.value(), "");
        }
        return token;
    }

    /**
     * 从request请求中获取用户身份信息
     *
     * @param request
     * @return
     */
    public MyUserDetails getUserDetails(HttpServletRequest request) {
        // 获取请求携带的令牌
        String token = getToken(request);
        if (StringUtils.hasText(token)) {
            Claims claims = parseToken(token);
            // 解析对应的权限以及用户信息
            String uuid = (String) claims.get(CommonEnum.LOGIN_USER_KEY.value());
            String userKey = CommonEnum.LOGIN_TOKEN_KEY.value() + uuid;
            MyUserDetails userDetails = redisCache.getCacheObject(userKey);
            return userDetails;
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
     * 从request中获取用户名
     *
     * @param request 令牌
     * @return 用户名
     */
    public String getUserNameFromRequest(HttpServletRequest request) {
        String token = getToken(request);
        // 获取请求携带的令牌
        if (StringUtils.hasText(token)) {
            Claims claims = parseToken(token);
            // 解析对应的权限以及用户信息
            String userName = (String) claims.get(CommonEnum.LOGIN_USER_NAME.value());
            return userName;
        }
        return null;
    }

    /**
     * 创建令牌
     *
     * @param myUserDetails 用户信息
     * @return 令牌
     */
    public String createToken(MyUserDetails myUserDetails) {
        String userKey = UUID.randomUUID().toString().replace("-", "");
        myUserDetails.setUserKey(userKey);
        refreshToken(myUserDetails);

        Map<String, Object> claims = new HashMap<>();
        claims.put(CommonEnum.LOGIN_USER_KEY.value(), userKey);
        claims.put(CommonEnum.LOGIN_USER_NAME.value(), myUserDetails.getUsername());
        String token2 = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
        return token2;
    }

    /**
     * 从缓存中删除用户身份信息
     *
     * @param userId
     */
    public void delUserDetails(String userId) {
        if (StringUtils.hasText(userId)) {
            String userKey = CommonEnum.LOGIN_TOKEN_KEY.value() + userId;
            redisCache.deleteObject(userKey);
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
        String userKey = CommonEnum.LOGIN_TOKEN_KEY.value() + userDetails.getUserKey();
        redisCache.setCacheObject(userKey, userDetails, expireTime, TimeUnit.MINUTES);
    }

    /**
     * 从令牌中获取数据声明
     *
     * @param token 令牌
     * @return 数据声明
     */
    public Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

}

