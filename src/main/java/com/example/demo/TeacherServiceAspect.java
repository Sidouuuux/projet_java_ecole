package com.example.demo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TeacherServiceAspect {
    @Before(value = "execution(* com.example.demo.TeacherService.*(..)) && args(s)")
    public void beforeAdvice(JoinPoint joinPoint, String s) {
        System.out.println("Before method:" + joinPoint.getSignature());

        System.out.println("Creating Employee with name - ");
    }

    @After(value = "execution(* com.example.demo.TeacherService.*(..)) && args(s)")
    public void afterAdvice(JoinPoint joinPoint, String s) {
        System.out.println("After method:" + joinPoint.getSignature());

        System.out.println("Successfully created Employee with name - ");
    }
}
