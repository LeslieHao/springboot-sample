package com.hh.springbootredis.annotation;

import java.lang.annotation.Repeatable;

/**
 * @author HaoHao
 * @Description:
 * @date 2018/7/15下午8:50
 */
@Repeatable(RoleAnnotations.class)
@interface RoleAnnotation {

    String value();

}
