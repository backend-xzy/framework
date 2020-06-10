package edu.jit.stackfarm.xzy.logging.annotation;

import edu.jit.stackfarm.xzy.logging.aspect.AnnotationLogAspect;
import edu.jit.stackfarm.xzy.logging.aspect.MethodExecIdAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggingConfiguration {

    @Bean
    public AnnotationLogAspect annotationLogAspect() {
        return new AnnotationLogAspect();
    }

    @Bean
    public MethodExecIdAspect methodExecIdAspect() {
        return new MethodExecIdAspect();
    }
}
