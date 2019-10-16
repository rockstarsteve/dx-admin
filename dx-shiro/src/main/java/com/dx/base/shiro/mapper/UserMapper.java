package com.dx.base.shiro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dx.base.shiro.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

/**
 * Description: com.dx.base.shiro
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/9/30
 */
@Mapper
public interface UserMapper  extends BaseMapper<User> {

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    Optional<User> findByUsername(String username);


    /**
     * 用户菜单列表
     * @param username
     * @return
     */
    List<String> queryUserMenuId(String username);


    /**
     * 查询用户的所有权限
     * @param username
     * @return
     */
    List<String> queryAllPerms(String username);
}
