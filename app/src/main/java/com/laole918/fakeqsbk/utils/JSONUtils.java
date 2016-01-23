package com.laole918.fakeqsbk.utils;

import com.alibaba.fastjson.JSON;

/**
 * Created by laole918 on 2016/1/3.
 */
public class JSONUtils {

    public static <T> T parseObject(String jsonString, Class<T> clazz) {
        if(jsonString != null && clazz != null) {
            try {
                return JSON.parseObject(jsonString, clazz);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
