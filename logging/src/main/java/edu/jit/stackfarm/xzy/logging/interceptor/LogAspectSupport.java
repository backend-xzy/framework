package edu.jit.stackfarm.xzy.logging.interceptor;

import org.aspectj.lang.reflect.MethodSignature;

public abstract class LogAspectSupport {

    protected String getMethodString(MethodSignature methodSignature) {
        Class<?>[] paramTypes = methodSignature.getParameterTypes();
        String[] paramNames = methodSignature.getParameterNames();
        StringBuilder sb = new StringBuilder();
        sb.append(methodSignature.getReturnType().getName())
                .append(' ')
                .append(methodSignature.getDeclaringTypeName())
                .append('#')
                .append(methodSignature.getName())
                .append('(');
        for (int i = 0; i < paramTypes.length; i++) {
            sb.append(paramTypes[i].getName())
                    .append(' ')
                    .append(paramNames[i]);
            if (i != paramTypes.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
