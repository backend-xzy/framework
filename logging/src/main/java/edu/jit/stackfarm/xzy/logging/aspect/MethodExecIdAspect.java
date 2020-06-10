package edu.jit.stackfarm.xzy.logging.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.util.UUID;

@Aspect
@Order(Ordered.HIGHEST_PRECEDENCE + 2)
public class MethodExecIdAspect {

    static final ThreadLocal<UUID> methodExecId = new ThreadLocal<>();

    @Before("edu.jit.stackfarm.xzy.logging.aspect.AnnotationLogAspect.needLog()")
    public void generateMethodExecId() {
        methodExecId.set(UUID.randomUUID());
    }


    @After("edu.jit.stackfarm.xzy.logging.aspect.AnnotationLogAspect.needLog()")
    public void clearThreadLocal() {
        methodExecId.remove();
    }
}
