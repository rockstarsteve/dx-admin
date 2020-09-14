package com.dx.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dx.common.security.MyUserDetails;
import com.dx.sys.entity.SysUser;
import com.dx.sys.mapper.SysUserMapper;
import com.dx.sys.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author rockstarsteve
 * @since 2020-06-11
 */
@Slf4j
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Override
    public List<UserDetails> loadUsersByUsername(String username) {

        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SysUser::getUsername,username);
        List<SysUser> list = list(wrapper);

        //转换为security的用户
        List myUserDetails = new ArrayList<MyUserDetails>();
        list.stream().forEach(sysUser -> {
            myUserDetails.add(new MyUserDetails(sysUser.getUsername(),sysUser.getPassword()));
        });

        return myUserDetails;
    }
}
