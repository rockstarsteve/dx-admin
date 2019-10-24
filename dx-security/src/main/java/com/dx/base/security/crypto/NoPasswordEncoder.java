package com.dx.base.security.crypto;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Description: com.dx.base.security
 * 没有进行加密的加密算法
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/12
 */
@Slf4j
public class NoPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        log.info("charSequence:   " + charSequence.toString());
        log.info("s:   " + s.toString());
        if (charSequence.equals(s)){
            return true;
        }
        return false;
    }
}

