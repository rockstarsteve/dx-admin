package com.dx.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dx.test.bean.TestBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TestMapper extends BaseMapper<TestBean> {

    @Select("select * from t_test where name = #{name}")
    List<TestBean> testSql(@Param("name")String name);
}
