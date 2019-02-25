package com.vincent.duduCore.annotation;

import java.lang.annotation.*;

/**
 * @description: 自定义注解
 * @author: weijian.yan
 * @create: 2019-02-20 16:41
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface AnnotationSimple {
    String msg() default  "";
}
