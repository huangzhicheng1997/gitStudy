package com.hzc.serviceuser.utils;

import com.hzc.serviceuser.dto.GoodsDetailDto;
import com.hzc.serviceuser.entity.Goods;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

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

   /* public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<GoodsDetailDto> result = GoodsDetailDto.class;
        Goods resource=new Goods();
        resource.setId("1");
        resource.setStatus("2");
        Class<?> reClass = resource.getClass();
        Field[] reFields = reClass.getDeclaredFields();
        GoodsDetailDto goodsDetailDto1 = result.newInstance();
        for (Field field:reFields) {
            if (field.getName().contains("serialVersionUID")){
                break;
            }
            field.setAccessible(true);
            String getMethod = "get"+field.getName().substring(0,1).toUpperCase()+field.getName().substring(1);
            String setMethod="set"+field.getName().substring(0,1).toUpperCase()+field.getName().substring(1);
            Method declaredMethod = reClass.getDeclaredMethod(getMethod);
            Object invoke =declaredMethod.invoke(resource);
            Method declaredMethod1 = result.getDeclaredMethod(setMethod, field.getType());
            declaredMethod1.invoke(goodsDetailDto1,invoke);
        }
        System.out.println(goodsDetailDto1.getStatus());
    }*/



}
