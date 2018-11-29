package com.hh.springbootredis.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author HaoHao
 * @Description: 切面
 * @date 2018/7/15下午10:23
 */
@Aspect
@Component
public class LogAspect {


    /**
     * 第一个 * 代表所有的返回值类型
     * 第二个 * 代表包底下所有类
     * 地三个 * 代表所有方法
     * 最后一个.. 代表所有参数v
     */
    @Pointcut("execution(* com.hh.springbootredis.controller..*.*(..))")
//    @Pointcut("@annotation(com.yeepay.g3.jrhz.cashier.aop.RsaDecrypt)")
    public void controllerAspectj() {
    }

    @Before("controllerAspectj()")
    public void doBefore(JoinPoint joinpoint) {

        String name = joinpoint.getTarget().getClass().getName();

        String method = joinpoint.getSignature().getName();

        Class cls = joinpoint.getTarget().getClass();

        Method[] methods = cls.getMethods();



        for (Method m : methods) {
            Log log = m.getAnnotation(Log.class);
            if (log != null) {
                System.out.println("注解类型: " + log.operateType());
                System.out.println("注解名: " + log.operateName());
            }
        }

        System.out.println("name: " + name);
        System.out.println("method: " + method);
    }


    @Around("controllerAspectj()")
    public String doAround(ProceedingJoinPoint joinpoint) throws Throwable {
        // before
        System.out.println("before~");

        // do
        Object response = joinpoint.proceed();

        // after
        System.out.println("方法返回结果: " + response);

        // 如果拦截的controller 添加了@responseBody 注解,after 必须返回结果
        return response.toString();

    }


    @After("controllerAspectj()")
    public void doAfter(JoinPoint joinPoint) {

        System.out.println("after~");

    }


    @AfterThrowing(pointcut = "controllerAspectj()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
        System.out.println("抛出了异常: " + e.getMessage());
    }
}

