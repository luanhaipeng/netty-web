package cn.ubibi.nettyweb.framework.commons.annotation;


import java.lang.annotation.*;


@Target({ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JSONTextBeanArray {
    Class elementType();
}
