package com.dx.common.security;

import com.dx.sys.entity.SysUser;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

/**
 * Description: com.dx.sys.entity
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2020/9/11
 */
@Slf4j
@Data
public class LoginUserDetails implements UserDetails {
    /**
     * 权限列表
     */
    private Set<String> permissions;
    /**
     * 用户信息
     */
    private SysUser user;
    /**
     * 过期时间
     */
    private Long expireTime;
    /**
     * 登陆时间
     */
    private Long loginTime;
    /**
     * 用户唯一标识
     */
    private String userKey;

    public LoginUserDetails(SysUser sysUser) {
        this.user = sysUser;
    }

    public LoginUserDetails(SysUser user, Set<String> permissions) {
        this.user = user;
        this.permissions = permissions;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        log.info("返回权限中的内容....");
        return null;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
