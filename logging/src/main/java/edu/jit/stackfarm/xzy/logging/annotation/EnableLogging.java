package edu.jit.stackfarm.xzy.logging.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 启用日志模块，注册日志注解处理切面类
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(LoggingConfiguration.class)
public @interface EnableLogging {

}
