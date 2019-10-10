package com.dx.base.util;

/**
 * Description: com.dx.bean
 * 常量
 *
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/8
 */
public class Constant {

    /**
     * 菜单类型
     *
     * @author chenshun
     * @email sunlightcs@gmail.com
     * @date 2016年11月15日 下午1:24:29
     */
    public enum MenuType {
        /**
         * 目录
         */
        CATALOG(0),
        /**
         * 菜单
         */
        MENU(1),
        /**
         * 按钮
         */
        BUTTON(2);

        private int value;

        MenuType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }



}
