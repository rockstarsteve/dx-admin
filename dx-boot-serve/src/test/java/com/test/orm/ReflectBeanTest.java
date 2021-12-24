package com.test.orm;

import lombok.Data;
import org.junit.Test;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static cn.afterturn.easypoi.util.PoiCssUtils.isNum;

/**
 * description
 *
 * @author yaojian
 * @createTime 2021/12/24
 */
public class ReflectBeanTest {

    @Test
    public void showSql() {

        User obj = new User();
        obj.setId("001");
        obj.setName("tom");
        obj.setAge(23);

        Table table = obj.getClass().getAnnotation(Table.class);
        StringBuffer sbSql = new StringBuffer();
        String tableName = table.value();
        sbSql.append("select * from " + tableName + " where 1=1 ");
        Field[] fileds = obj.getClass().getDeclaredFields();
        for (Field f : fileds) {
            String fieldName = f.getName();
            String methodName = "get" + fieldName.substring(0, 1).toUpperCase()
                    + fieldName.substring(1);
            try {
                Column column = f.getAnnotation(Column.class);
                if (column != null) {
                    Method method = obj.getClass().getMethod(methodName);
                    Object v = method.invoke(obj);
                    if (v != null) {
                        if (v instanceof String) {
                            String value = v.toString().trim();
                            // 判断参数是不是 in 类型参数 1,2,3
                            if (value.contains(",")) {
                                //去掉value中的,
                                String sqlParams = value.replace(",", "").trim();
                                //value中都是纯数字
                                if (isNum(sqlParams)) {
                                    sbSql.append(" and " + column.value() + " in (" + value + ") ");
                                } else {
                                    String[] split = value.split(",");
                                    //将value重置为空
                                    value = "";
                                    for (int i = 0; i < split.length - 1; i++) {
                                        value += "'" + split[i] + "',";
                                    }
                                    value += "'" + split[split.length - 1] + "'";
                                    sbSql.append(" and " + column.value() + " in (" + value + ") ");
                                }
                            } else {
                                if (value != null && value.length() > 0) {
                                    sbSql.append(" and " + column.value() + " like '%" + value + "%' ");
                                }
                            }
                        } else {
                            sbSql.append(" and " + column.value() + "=" + v.toString() + " ");
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String sqlStr = sbSql.toString();
        System.out.println(sqlStr);

    }

}


@Data
@Table("t_user")
class User implements Serializable {
    @Column("id")
    private String id;
    @Column("name")
    private String name;
    @Column("age")
    private int age;
}