package com.example.kongjian.aopdemo;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * Created by user on 2018/4/25.
 */
@Aspect
public class BehaviorAspect {

    @Pointcut("execution(@com.example.kongjian.aopdemo.BehaviorTrace * *(..))")
    public void methodAnnotatedWidthBehavior(){

    }

    //正对切面进行编程
    //环绕
    @Around("methodAnnotatedWidthBehavior()")
    public Object waveJointPoint(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long begin = System.currentTimeMillis();
        Object o = proceedingJoinPoint.proceed();

        long duration = System.currentTimeMillis() - begin;
        //获取功能的名称
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        BehaviorTrace behaviorTrace = methodSignature.getMethod().getAnnotation(BehaviorTrace.class);

        String funName = behaviorTrace.value();
        Log.i("aspectj", String.format("%s 功能耗时：%d ms", funName, duration));
        return o;
    }

}

