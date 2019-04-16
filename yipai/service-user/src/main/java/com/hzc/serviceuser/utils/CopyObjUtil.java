package com.hzc.serviceuser.utils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


/**
 * write by huangzhicheng 2019.03.04
 * 浅拷贝 （临时工具）
  */
public class CopyObjUtil {
    public static <T> T cloneObj(Object resource, Class<T> result)  {
        Class<?> reClass = resource.getClass();
        Field[] reFields = reClass.getDeclaredFields();
        T t = null;
        try {
            t = result.newInstance();
        } catch (Exception e) {
         e.printStackTrace();
        }
        for (Field field:reFields) {
            if(field.getName().contains("serialVersionUID")){
                break;
            }
            field.setAccessible(true);
            String getMethod = "get"+field.getName().substring(0,1).toUpperCase()+field.getName().substring(1);
            String setMethod="set"+field.getName().substring(0,1).toUpperCase()+field.getName().substring(1);
            try {
                Method declaredMethod = reClass.getDeclaredMethod(getMethod);
                Object invoke = declaredMethod.invoke(resource);
                Method declaredMethod1 = result.getDeclaredMethod(setMethod, field.getType());
                declaredMethod1.invoke(t,invoke);
            }catch (Exception e){
                break;
            }

        }
       return t;
    }
}
