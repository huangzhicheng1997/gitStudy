package com.hzc.serviceweb.utils;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


/**
 * Copyright (C), 2017-2018, 杭州众凡网络科技有限公司
 * FileName: ReflectUtils
 *
 * @author : 孙苏陵
 * Date:     2018/11/14 下午5:05
 * Description: 反射工具类
 * History:
 */
@Slf4j
public class ReflectUtils {
    /**
     * 对象转换 支持私有属性和内部类
     *
     * @param fromPojo
     * @param toPojo
     * @return
     */
    public static Object pojoToPojo(Object fromPojo, Object toPojo) {
        Class fromPojoClass = fromPojo.getClass();
        Method fromPojoClassDeclaredMethods[] = fromPojoClass.getDeclaredMethods();
        Class toPojoClass = toPojo.getClass();
        for (int i = 0; i < fromPojoClassDeclaredMethods.length; i++) {
            if (fromPojoClassDeclaredMethods[i].getName().indexOf("get") == 0) {
                String toName = fromPojoClassDeclaredMethods[i].getName().replace("get", "");
                toName = toName.substring(0, 1).toLowerCase() + toName.substring(1);
                try {
                    Field toPojoClassDeclaredField = toPojoClass.getDeclaredField(toName);
                    toPojoClassDeclaredField.setAccessible(true);
                    toPojoClassDeclaredField.set(toPojo, fromPojoClassDeclaredMethods[i].invoke(fromPojo));
                } catch (NoSuchFieldException e) {
                    log.error("目标POJO没有[" + toName + "]字段,将忽略");
                } catch (IllegalAccessException e) {
                    log.error("目标POJO没有[" + toName + "]字段,将忽略");
                } catch (InvocationTargetException e) {
                    log.error("目标POJO没有[" + toName + "]字段,将忽略");
                }
            }
        }
        return toPojo;
    }

}
