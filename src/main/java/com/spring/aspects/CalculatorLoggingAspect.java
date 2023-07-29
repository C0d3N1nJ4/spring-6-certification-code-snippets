package com.spring.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class CalculatorLoggingAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* *.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        var name = joinPoint.getSignature().getName();
        var args = Arrays.toString(joinPoint.getArgs());
        log.info("The method {}() begins with {}", name, args);
    }

    @After("execution(* *.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        var name = joinPoint.getSignature().getName();
        log.info("The method {}() ends", name);
    }

    @AfterReturning("execution(* *.*(..))")
    public void logAfterReturning(JoinPoint joinPoint) {
        var name = joinPoint.getSignature().getName();
        log.info("The method {}() ends", name);
    }

    //Executed only after there is an exception thrown by the join point method
    @AfterThrowing("execution(* *.*(..))")
    public void logAfterThrowing(JoinPoint joinPoint) {
        var name = joinPoint.getSignature().getName();
        log.info("An exception has been thrown in {}()", name);
    }

    //The exception thrown by the join point can be accessed by adding an argument of type Exception to the advice method
    //The type Throwable is a superclass of all errors and exceptions in Java
    //The following advice will catch all exceptions thrown by the join points
    @AfterThrowing(pointcut = "execution(* *.*(..))", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Exception ex) {
        var name = joinPoint.getSignature().getName();
        log.info("An exception {} has been thrown in {}()", ex, name);
    }


    //OR
    //If you are interested in only 1 type of exception, you can specify the type in the advice method
    //This advice will only execute when exceptions of a compatible type are thrown
    @AfterThrowing(pointcut = "execution(* *.*(..))", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, IllegalArgumentException ex) {
        var args = Arrays.toString(joinPoint.getArgs());
        var name = joinPoint.getSignature().getName();
        log.info("An exception {} has been thrown in {}()", args, name);
    }


    //The @Around advice is the most powerful advice
    //It can be used to implement method caching, security, logging, etc.
    //It gains full control of a join point so you can combine all the other advices into one
    //You can control when to proceed to the join point and when to skip it

    @Around("execution(* *.*(..))")
    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable{
        var name = joinPoint.getSignature().getName();
        log.info("The method {}() begins with {}", name, Arrays.toString(joinPoint.getArgs()));
        try {
            joinPoint.proceed();
        } catch (IllegalArgumentException e) {
            log.error("Illegal argument {} in {}()", Arrays.toString(joinPoint.getArgs()), name);
            throw e;
        }
        log.info("The method {}() ends", name);
    }

    @Before("execution(* *.*(..))")
    public void logJointPoint(JoinPoint joinPoint) {
        log.info("Joint point {}", joinPoint.getKind());
        log.info("Signature declaring type {}", joinPoint.getSignature().getDeclaringTypeName());
        log.info("Signature name {}", joinPoint.getSignature().getName());
        log.info("Arguments {}", Arrays.toString(joinPoint.getArgs()));
        log.info("Target class {}", joinPoint.getTarget().getClass().getName());
        log.info("This class {}", joinPoint.getThis().getClass().getName());
    }

}
