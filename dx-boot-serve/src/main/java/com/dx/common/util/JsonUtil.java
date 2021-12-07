package com.dx.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * description
 *
 * @author yaojian
 * @createTime 2021/12/07
 */
public class JsonUtil {

    /**
     * 定义一个json转换对象
     */
    private static ObjectMapper mp = new ObjectMapper();

    /**
     * 利用json把对象转为String类型
     *
     * @param obj
     * @return
     * @throws JsonProcessingException
     */
    public static String toJSONString(Object obj){
        String jsonString = "";
        try {
            jsonString = mp.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

}
