package com.hh.springboot.annotation;

/**
 * @author HaoHao
 * @Description: Java 注解学习
 * @date 2018/7/15下午6:22
 */
@Deprecated //废弃的, 会被划横线  编译时会发出warning
public class AnnotationDemo {


    @TestAnnotation("test")
    @Deprecated
    @SuppressWarnings("") // 压制警告
    void test() {

    }

    public static void main(String[] args) {
        AnnotationDemo annotationDemo = new AnnotationDemo();
        annotationDemo.test();
    }

    @FunctionalInterface // 函数式接口注解
    interface FunctionI{
         void run();
    }
}
