package cn.ubibi.nettyweb.framework.rest.model;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class MethodArgument {
    private Method method;
    private Type type;
    private Annotation[] annotations;


    public MethodArgument(Method method, Type type, Annotation[] annotations) {
        this.method = method;
        this.type = type;
        this.annotations = annotations;
    }

    public Method getMethod() {
        return method;
    }

    public Type getType() {
        return type;
    }

    public Annotation[] getAnnotations() {
        return annotations;
    }

}
