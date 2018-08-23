package com.hh.springbootredis.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author HaoHao
 * @Description:
 * @date 2018/7/15下午10:22
 */
@Target({ElementType.METHOD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {

    // 操作类型
    String operateType() default "";

    // 操作名
    String operateName() default "";
}
