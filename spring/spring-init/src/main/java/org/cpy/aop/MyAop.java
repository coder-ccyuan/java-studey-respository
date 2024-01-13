package org.cpy.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
//@Order(1)//给切面类的优先级
public class MyAop {
    @Before(value = "execution(public void org.cpy.entiey.Vechile.getType())")
    public void beforeShow(JoinPoint joinPoint){
        System.out.println("----Before");
        System.out.println(joinPoint.getSignature().getName());

    }
    @Before(value = "execution(public void org.cpy.entiey.AopDemo.getMes())")
    public void demoShow(){
        System.out.println("aop---demo");
    }
}
