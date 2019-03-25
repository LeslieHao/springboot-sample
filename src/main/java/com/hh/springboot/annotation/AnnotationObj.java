package com.hh.springboot.annotation;

import java.lang.annotation.Annotation;

import com.alibaba.fastjson.JSON;

/**
 * @author HaoHao
 * @Description:
 * @date 2018/7/15下午9:31
 */
@Deprecated
@TestAnnotation("man")
public class AnnotationObj {


    public static void main(String[] args) {
        // 是否标记的了注解
        boolean b = AnnotationObj.class.isAnnotationPresent(TestAnnotation.class);

        // 获取标记的某个注解
        TestAnnotation annotation = AnnotationObj.class.getAnnotation(TestAnnotation.class);

        // 获取对象标记的注解数组
        Annotation[] annotations = AnnotationObj.class.getAnnotations();

        if (b) {
            System.out.println("注解的value:"+annotation.value());
            System.out.println(JSON.toJSONString(annotations));
        }
    }
}
