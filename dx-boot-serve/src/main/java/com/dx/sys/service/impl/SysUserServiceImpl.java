package com.dx.sys.service.impl;

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
        log.info("根据用户名获取到了用户");
        List myUserDetails = new ArrayList<MyUserDetails>();
        myUserDetails.add(new MyUserDetails("user","$2a$10$JYtKHS090yIqfEcNczeJyO10/L6x5I0qAXUc8lXr5cvWlqhGssZuG"));
//        myUserDetails.add(new MyUserDetails("user","123"));
        return myUserDetails;
    }
}
