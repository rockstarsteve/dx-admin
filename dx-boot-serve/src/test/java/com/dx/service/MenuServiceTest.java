package com.dx.service;

import com.dx.sys.entity.SysMenu;
import com.dx.sys.mapper.SysMenuMapper;
import com.dx.sys.service.ISysMenuService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * description
 *
 * @author yaojian
 * @createTime 2021/12/21
 */
@Slf4j
@SpringBootTest
public class MenuServiceTest {

    @Autowired
    SysMenuMapper sysMenuMapper;
    @Autowired
    ISysMenuService menuService;

    @Test
    public void testCountLeftGoods() {

        // 方法打桩
        List<SysMenu> sysMenuList = menuService.selectMenuTreeByUserId("1");
        log.info(sysMenuList.toString());

        List<SysMenu> sysMenuList1 = sysMenuMapper.selectMenuTreeAll();
        System.out.println(sysMenuList1.toString());

        Assert.assertEquals(1, 1);
    }
}
