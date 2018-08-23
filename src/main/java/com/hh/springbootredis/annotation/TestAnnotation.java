package com.hh.springbootredis.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import java.lang.annotation.*;

/**
 * @author HaoHao
 * @Description:
 * @date 2018/7/15下午6:18
 */
//@Retention(RetentionPolicy.SOURCE) //只在源码阶段保留,编译时将被忽视或者丢弃
//@Retention(RetentionPolicy.CLASS) // 保留在编译进行的时候,并不会被加载到JVM 中
@Retention(RetentionPolicy.RUNTIME) // 可以被保留到运行的时候, 会被加载到JVM, 所以运行时可以获取到
//
//@Documented  // 文档相关
//
//@Target(ElementType.ANNOTATION_TYPE) // 可以用在注解上
//@Target(ElementType.TYPE) // 可以用在类上
//@Target(ElementType.FIELD) // 可以用在域上
//@Target(ElementType.METHOD) // 可以用在方法上
//@Target(ElementType.PARAMETER) // 可以用在参数上
//@Target(ElementType.CONSTRUCTOR) // 可以用在构造上
//@Target(ElementType.LOCAL_VARIABLE) // 可以用在局部变量上
//@Target(ElementType.PACKAGE) // 可以用在包上
//
//@Inherited // 注解TestAnnotation 的类的子类可以继承TestAnnotation 的注解
//
//// 可重复的
//@RoleAnnotation("man")
//@RoleAnnotation("woman")
public @interface TestAnnotation {


    /*
       元注解: 可以注解到注解上的注解
        1.@Retention: 标明注解的存活时间
        2.@Target: 标明注解使用的地方
        3.@Inherited: 子类没有被任何注解标记的话 可以继承父类的注解
        4.@Repeatable: 可重复的注解
        5.@Documented: 文档相关
     */

    String value() default "";
}
