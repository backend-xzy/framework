package edu.jit.stackfarm.xzy.logging.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(LoggingConfiguration.class)
public @interface EnableLogging {

}
