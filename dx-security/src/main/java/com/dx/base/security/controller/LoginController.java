package com.dx.base.security.controller;

import com.dx.base.common.bean.Constants;
import com.dx.base.common.bean.R;
import com.dx.base.security.bean.LoginUser;
import com.dx.base.security.bean.RouterVo;
import com.dx.base.security.bean.SysMenu;
import com.dx.base.security.bean.SysUser;
import com.dx.base.security.service.CaptchaCacheService;
import com.dx.base.security.service.SysLoginService;
import com.dx.base.security.service.SysMenuService;
import com.dx.base.security.service.TokenServiceImpl;
import com.dx.base.security.util.Base64Utile;
import com.dx.base.security.util.VerifyCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Description: com.dx.sys.controller
 * 登录模块
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/12
 */
@RestController
@Slf4j
public class LoginController {

    @Autowired
    private TokenServiceImpl tokenService;
    @Autowired
    private SysMenuService menuService;
    @Autowired
    private SysLoginService sysLoginService;
    @Autowired
    private CaptchaCacheService captchaCacheService;

    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @GetMapping("/login")
    public Object login(String username, String password, String code, String uuid) {

        // 生成令牌
        String token = sysLoginService.login(username, password, code, uuid);

        return R.ok(token);
    }


    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @PostMapping("/getInfo")
    public R getInfo(HttpServletRequest request) {
        LoginUser loginUser = tokenService.getLoginUser(request);
        SysUser sysUser = loginUser.getSysUser();

        Map map = new HashMap();
        map.put("sysUser", sysUser);
        R.ok(map);

        return R.ok(map);
    }


    /**
     * 获取路由信息
     *
     * @return 路由信息
     */
    @PostMapping("getRouters")
    public R getRouters(HttpServletRequest request) {
        LoginUser loginUser = tokenService.getLoginUser(request);
        // 用户信息
        SysUser user = loginUser.getSysUser();
        List<SysMenu> menus = menuService.selectMenuTreeByUserId(user.getId());

        List<RouterVo> routerVoList = menuService.buildMenus(menus);

        return R.ok(routerVoList);
    }


    /**
     * 生成验证码
     */
    @GetMapping("/captchaImage")
    public R getCode(HttpServletResponse response,String uuid) throws IOException {
        // 生成随机字串
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
        log.info("verifyCode:   " + verifyCode);
        // 唯一标识
        if(StringUtils.isEmpty(uuid)){
            uuid = getUuid();
        }
        log.info("uuid:   " + uuid);
        String verifyKey = Constants.CAPTCHA_CODE_KEY + uuid;

        captchaCacheService.getVerifyCode(verifyKey, verifyCode);

        //TODO 生成图片  要进行可配置的
        int w = 111, h = 36;
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        VerifyCodeUtils.outputImage(w, h, stream, verifyCode);
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("uuid", uuid);
            //map.put("img", new sun.misc.BASE64Encoder().encode(stream.toByteArray()));
            map.put("img", Base64Utile.encode(stream.toByteArray()));
            return R.ok(map);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(e.getMessage());
        } finally {
            stream.close();
        }
    }

    /**
     * 获取uuid
     *
     * @return
     */
    private String getUuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }


}
