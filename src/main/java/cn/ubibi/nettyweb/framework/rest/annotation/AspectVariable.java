package cn.ubibi.nettyweb.framework.rest.annotation;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AspectVariable {
    String value() default "";
}
