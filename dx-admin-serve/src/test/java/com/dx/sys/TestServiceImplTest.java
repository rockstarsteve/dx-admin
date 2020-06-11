package com.dx.sys;

import com.dx.sys.entity.SysUser;
import com.dx.sys.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Description: com.dx.service.impl
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/9/30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TestServiceImplTest {

    @Autowired
    private ISysUserService sysUserService;


    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void test() {
        List<SysUser> sysUserList = sysUserService.list();

        log.info(sysUserList.toString());
    }


}
