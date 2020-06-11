package edu.jit.stackfarm.xzy.logging.annotation;

import java.lang.annotation.*;

/**
 * 标注于类或方法上，标注在类上表示对该类所有方法生效
 * 记录方法入参
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface LogParam {
}
