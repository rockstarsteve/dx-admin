package com.dx.sys.service;

import com.dx.sys.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author rockstarsteve
 * @since 2020-06-11
 */
public interface ISysUserService extends IService<SysUser> {


    /**
     * 根据登录用户名获取用户
     * @param username
     * @return
     */
    List<UserDetails> loadUsersByUsername(String username);
}
