package com.test.mybatis.mapper;

import com.test.mybatis.bean.User;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author rockstarsteve
 * @since 2020-06-11
 */
@CacheNamespace
public interface UserMapper {


    @Select("select * from sys_user where user_id = #{id}")
    List<User> getUser(String id);


    @Select("select * from sys_user where user_id = #{id}")
    List<User> getUser2(String id);

}