package springboottest;

import com.dx.sys.entity.SysMenu;
import com.dx.sys.mapper.SysMenuMapper;
import com.dx.sys.service.ISysMenuService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

/**
 * description
 *
 * @author yaojian
 * @createTime 2021/12/06
 */
@RunWith(MockitoJUnitRunner.class)
public class Demo {
    /**
     * InjectMocks
     * 注入storeService对象到上下文环境中
     * <p>
     * 注意，与Autowire不同的是，InjectMocks可以跟Mock注解搭配使用
     */
    @InjectMocks
    ISysMenuService menuService;

    /**
     * 创建mock对象，自动被注入到被@InjectMocks注解所修饰的对象里
     */
    @Mock
    SysMenuMapper sysMenuMapper;

    @Test
    public void testCountLeftGoods() {
        String goodsId = "1";
        // 方法打桩
        List<SysMenu> sysMenuList = menuService.selectMenuTreeByUserId("1");
        System.out.println(sysMenuList);

        List<SysMenu> sysMenuList1 = sysMenuMapper.selectMenuTreeAll();

//        Mockito.when(.thenReturn(1);
//        Assert.assertEquals(Integer.valueOf(1), storeService.countLeftGoods(goodsId));
    }

}
