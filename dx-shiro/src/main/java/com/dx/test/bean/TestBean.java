package com.dx.test.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * Description: com.dx.bean
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/9/30
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_test")
public class TestBean extends Model<TestBean> {

    /**
     * 学生id
     */
    @TableId("id")
    private String id;

    /**
     * 学生姓名
     */
    @TableField("name")
    private String name;

    /**
     * 逻辑删除
     */
    @TableLogic
    private int isDel;



    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
