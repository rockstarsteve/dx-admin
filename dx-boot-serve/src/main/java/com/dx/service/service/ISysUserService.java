package com.dx.service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dx.service.entity.SysUser;

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
    List<SysUser> loadUsersByUsername(String username);
}
