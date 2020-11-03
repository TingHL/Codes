package com.atguigu.spring5.aopanno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//增强类
@Component
@Aspect  //生成代理对象
@Order(3)  //代理对象优先级
public class UserProxy {
    //相同的切入点抽取
    @Pointcut(value = "execution(* com.atguigu.spring5.aopanno.User.add(..))")
    public void pointdemo(){
    }

    //前置通知
    //@Before 注解表示作为前置通知  切入点表达式execution([权限修饰符][返回类型][类全路径][方法名称]([参数列表]))
    @Before(value = "pointdemo()")
    public void before(){
        System.out.println("before...");
    }

    //最终通知
    //在方法执行之后执行 方法被调用的时候就会执行 不管调用之后方法有没出错
    @After(value = "pointdemo()")
    public void after(){
        System.out.println("after...");
    }


    //在返回值之后执行
    @AfterReturning(value = "execution(* com.atguigu.spring5.aopanno.User.add(..))")
    public void afterReturning(){
        System.out.println("afterReturning...");
    }

    //异常通知
    @AfterThrowing(value = "execution(* com.atguigu.spring5.aopanno.User.add(..))")
    public void afterThrowing(){
        System.out.println("afterThrowing...");
    }

    //在方法执行之前、之后都执行 环绕通知
    @Around(value = "execution(* com.atguigu.spring5.aopanno.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前...");

        //被增强方法执行
        proceedingJoinPoint.proceed();
        System.out.println("环绕之后");
    }
}
