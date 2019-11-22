package com.dx.base.security.service;

/**
 * Description: com.dx.base.security.service
 * 验证码缓存对象
 *
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/24
 */
public interface CaptchaCacheService {

    /**
     * 获取验证码code
     * @param verifyKey
     * @param verifyCode
     * @return
     */
    String getVerifyCode(String verifyKey, String verifyCode);

    /**
     * 删除验证码
     * @param verifyKey
     */
    public void delete(String verifyKey);
}
