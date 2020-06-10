package edu.jit.stackfarm.xzy.logging.aspect;

import edu.jit.stackfarm.xzy.logging.interceptor.LogAspectSupport;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import static edu.jit.stackfarm.xzy.logging.aspect.MethodExecIdAspect.methodExecId;

@Aspect
public class AnnotationLogAspect extends LogAspectSupport {

    private final Logger logger = LoggerFactory.getLogger(AnnotationLogAspect.class);

    @Pointcut("@annotation(edu.jit.stackfarm.xzy.logging.annotation.LogExecTime)")
    public void logExecTime() {
    }

    @Pointcut("@annotation(edu.jit.stackfarm.xzy.logging.annotation.LogParam)")
    public void logParam() {
    }

    @Pointcut("@annotation(edu.jit.stackfarm.xzy.logging.annotation.LogReturnValue)")
    public void logReturnValue() {
    }

    @Pointcut("logExecTime() || logParam() || logReturnValue()")
    public void needLog() {
    }

    @Around("logExecTime()")
    public Object processLogExecTimeAnnotation(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object ret = joinPoint.proceed();
        long end = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        logger.debug("{} {}执行时间: {}ms", methodExecId.get(), getMethodString(signature), end - start);
        return ret;
    }

    @Before("logParam()")
    public void processLogParamAnnotation(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        logger.debug("{} {}入参为{}", methodExecId.get(), getMethodString(signature), Arrays.toString(args));
    }

    @AfterReturning(
            value = "logReturnValue()",
            returning = "returnValue")
    public void processLogReturnValue(JoinPoint joinPoint, Object returnValue) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        logger.debug("{} {}返回值为{}", methodExecId.get(), getMethodString(signature), returnValue);
    }

}
