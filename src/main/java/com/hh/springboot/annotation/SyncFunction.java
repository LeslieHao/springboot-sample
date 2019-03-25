package com.hh.springboot.annotation;

/**
 * @author HaoHao
 * @Description:
 * @date 2018/7/15下午9:22
 */
@FunctionalInterface
public interface SyncFunction<T1,T2> {


    void execute(T1 t1, T2 t2);
}
