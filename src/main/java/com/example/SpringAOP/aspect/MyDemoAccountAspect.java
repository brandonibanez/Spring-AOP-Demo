package com.example.SpringAOP.aspect;

import com.example.SpringAOP.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@Component
public class MyDemoAccountAspect{

    private Logger logger = Logger.getLogger(getClass().getName());
    private final String classPath = "com.example.SpringAOP.aspect.AOPAspects.";

    @Before(classPath+"forDAOWithoutGetterAndSetter()")
    public void beforeAddAccounts() {
        System.out.println("Be the man!");
    }

    @Before(classPath+"forDAOWithoutGetterAndSetter()")
    public void beforeAddAccount() {
        System.out.println("Sampong mga daliri ko ay malupet naman!");
    }

    @AfterReturning(pointcut = classPath+"forDAOPackage()", returning = "result")
    public void afterReturningListAccounts(JoinPoint joinPoint, List<Account> result) {
        System.out.println("This is from method: " + joinPoint.getSignature().toShortString());
        System.out.println("Parameters of the method: " + Arrays.toString(joinPoint.getArgs()));
        result.forEach((a) -> {
            a.setFname(a.getFname().toUpperCase());
            System.out.println("AOP method: " + a);
        });
    }

    @After(classPath+"forDAOPackage()")
    public void afterListAccounts(JoinPoint joinPoint) {
        System.out.println("This is from aop last method: " + joinPoint.getSignature().toShortString());
        System.out.println("Parameters of the aop last method: " + Arrays.toString(joinPoint.getArgs()));
    }

    @Around(classPath+"forDAOPackage()")
    public Object calculateMethodTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        logger.info("Before Executing the method");

        long begin = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();

        List<Account> list = Objects.nonNull(result) ? (List<Account>) result : null;

        list.forEach((a) -> System.out.println("AOP method: " + a));

        long end = System.currentTimeMillis();

        long duration = end - begin;

        logger.info("The system took: " + duration / 1000.0 + " s");

        return result;
    }

}
