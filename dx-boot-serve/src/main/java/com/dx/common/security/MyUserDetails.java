package com.dx.common.security;

import com.dx.service.entity.SysUser;
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
public class MyUserDetails implements UserDetails {
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
    private String token;

    public MyUserDetails(SysUser sysUser) {
        this.user = sysUser;
    }

    public MyUserDetails(SysUser user, Set<String> permissions) {
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

    /**
     * 账号是否过期
     *
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 账户是否未被锁
     *
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 是否能用
     *
     * @return
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    public Long getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Long loginTime) {
        this.loginTime = loginTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Set<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }

    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }
}
