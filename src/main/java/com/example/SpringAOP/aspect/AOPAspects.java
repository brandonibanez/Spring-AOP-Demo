package com.example.SpringAOP.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class AOPAspects {

    @Pointcut("execution(* com.example.SpringAOP.dao.*.*(..))")
    public void forDAOPackage() {}

    @Pointcut("execution(* com.example.SpringAOP.dao.*.get*(..))")
    public void getter() {}

    @Pointcut("execution(* com.example.SpringAOP.dao.*.set*(..))")
    public void setter() {}

    @Pointcut("forDAOPackage() && !(getter() || setter())")
    public void forDAOWithoutGetterAndSetter() {}

}
