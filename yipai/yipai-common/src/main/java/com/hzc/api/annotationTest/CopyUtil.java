package com.hzc.api.annotationTest;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class CopyUtil {
    /*public static  <T> T copyObj(Object source,Class<T> target) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> sourceClass= source.getClass();
        Field[] fields = sourceClass.getDeclaredFields();
        T t = null;
        try {
            t = target.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        List<String> ls = new ArrayList<>();
        for (Field field :fields) {
            field.setAccessible(true);
            Field[] declaredFields = target.getDeclaredFields();
            for (Field field2 : declaredFields) {
                if (field2.getAnnotation(SourceField.class) == null&&) {
                    break;
                }
                field2.setAccessible(true);
                if (field2.getAnnotation(SourceField.class).FieldName().equals(field.getName())) {
                    String fieldName = field2.getAnnotation(SourceField.class).FieldName();
                    ls.add(fieldName);
                    break;
                }
            }

        }
            *//*
            if( target.getField(field.getName()).getAnnotation(SourceField.class)==null&&target.getField(field.getName())==null){
                break;
            }
            if(target.getField(field.getName()).getAnnotation(SourceField.class)==null&&target.getField(field.getName())!=null){
                String getMethod="get"+field.getName().substring(0,1).toUpperCase()+field.getName().substring(1);
                String setMethod="set"+field.getName().substring(0,1).toUpperCase()+field.getName().substring(1);
                Method declaredMethod = sourceClass.getDeclaredMethod(getMethod);
                declaredMethod.setAccessible(true);
                Object sourceFiledValue = declaredMethod.invoke(source);
                Method declaredMethod1 = target.getDeclaredMethod(setMethod);
                declaredMethod1.setAccessible(true);
                declaredMethod1.invoke(t,sourceFiledValue);
                break;
            }
            String annotationValue = target.getField(field.getName()).getAnnotation(SourceField.class).FieldName();
            if ((target.getField(field.getName())==null&&target.getField(annotationValue)==null)){
                break;
            }*//*
            SourceField annotation = target.getField(field.getName()).getAnnotation(SourceField.class);
            String getMethod="get"+field.getName().substring(0,1).toUpperCase()+field.getName().substring(1);
            String targetFiledName = annotation.FieldName();
            String setMethod="set"+targetFiledName.substring(0,1).toUpperCase()+targetFiledName.substring(1);
            Method declaredMethod = sourceClass.getDeclaredMethod(getMethod);
            declaredMethod.setAccessible(true);
            Object sourceFiledValue = declaredMethod.invoke(source);
            Method declaredMethod1 = target.getDeclaredMethod(setMethod);
            declaredMethod1.setAccessible(true);
            declaredMethod1.invoke(t,sourceFiledValue);
        }
        return t;
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, NoSuchFieldException {
        A a=new A();
        a.setName("h");
        a.setValue("v");
        B b = CopyUtil.copyObj(a, B.class);
        System.out.println(b.toString());
    }*/
}
