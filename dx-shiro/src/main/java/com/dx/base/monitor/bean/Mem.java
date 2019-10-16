package com.dx.base.monitor.bean;

import lombok.Data;

/**
 * Description: com.dx.base.monitor.bean
 *
 * 內存相关信息
 *
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/10
 */
@Data
public class Mem {
    /**
     * 内存总量
     */
    private double total;

    /**
     * 已用内存
     */
    private double used;

    /**
     * 剩余内存
     */
    private double free;

    public double getTotal() {
        return Arith.div(total, (1024 * 1024 * 1024), 2);
    }

    public double getUsed() {
        return Arith.div(used, (1024 * 1024 * 1024), 2);
    }

    public double getFree() {
        return Arith.div(free, (1024 * 1024 * 1024), 2);
    }

    public double getUsage() {
        return Arith.mul(Arith.div(used, total, 4), 100);
    }
}
