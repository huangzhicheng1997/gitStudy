package com.hzc.serviceuser.utils;

import com.google.common.collect.Lists;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 做一个缓存减少反射的性能消耗
 */
@Deprecated
public class JpaUtils{
    //单例保证cache不会被GC
    private static JpaUtils cache=new JpaUtils();
    private Map<String, List<Method>> map=new HashMap<>();

    private void doReflect(Object o,Object[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        String key = o.getClass().toString();
        List<Method> value = map.get(key);
        if(value==null){
            setCache(o);
        }
        //重写获得所有的get和set方法
        value=map.get(key);
        for (int i=0;i<value.size();i++) {
            Class<?> parameterType = value.get(0).getParameterTypes()[0];
            //按顺序执行每个set方法
            try {
                value.get(0).invoke(o, parameterType.getDeclaredMethod("valueOf", parameterType).invoke(parameterType, args[i]));
            }catch (Exception e){
                value.get(0).invoke(o,args[i]);
            }
            }
        }

    private void setCache(Object o){
        Class<?> clazz = o.getClass();
        String className=clazz.toString();
        Method[] declaredMethods = clazz.getDeclaredMethods();
        ArrayList<Method> methods = Lists.newArrayList();
        for (Method method:declaredMethods) {
            if (method.getName().substring(0,3).equals("set")){
                methods.add(method);
            }
        }

        map.put(className,methods);
    }

    public static void setObjRef(Object o,Object[] args){
        try {
            cache.doReflect(o,args);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

}
