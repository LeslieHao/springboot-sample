package com.hh.springboot.annotation;

/**
 * @author HaoHao
 * @Description: Java8 新增 只允许有一个抽象方法, Object 中的方法和 Default 方法不算; lambda
 * @date 2018/7/15下午9:07
 */
@FunctionalInterface
public interface TestFunctionInterface {

    public abstract void say(String word);

    static void main(String[] args) {
        TestFunctionInterface functionalInterface = System.out::println;
        functionalInterface.say("你好~");
    }
}
