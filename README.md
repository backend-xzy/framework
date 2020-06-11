# framework
framework based on spring framework to convenient development

## how to get
install it and add it into your dependencies

### maven
```java
<dependency>
    <groupId>edu.jit.stackfarm.xzy</groupId>
    <artifactId>logging</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```
## how to use
### logging
put `@EnableLogging` on your configuration class and put `@LogExecTime`/`@LogParam`/`@LogReturnValue` on your class/method that needs to be logged