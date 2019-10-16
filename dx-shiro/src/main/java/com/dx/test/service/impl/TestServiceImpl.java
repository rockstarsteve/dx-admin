package com.dx.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dx.test.bean.TestBean;
import com.dx.test.mapper.TestMapper;
import com.dx.test.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description: com.dx.service.impl
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/9/30
 */
@Slf4j
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, TestBean> implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public List<TestBean> testSql(String name) {
        log.info("ok");
        return testMapper.testSql(name);
    }
}
