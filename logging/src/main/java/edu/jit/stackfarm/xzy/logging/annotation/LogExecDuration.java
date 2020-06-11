package edu.jit.stackfarm.xzy.logging.annotation;

import java.lang.annotation.*;

/**
 * 标注于类或方法上，标注在类上表示对该类所有方法生效
 * 记录方法执行时长
 */
@Documented
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LogExecDuration {
}
