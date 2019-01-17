package com.vincent.duduCore.annotation;

import org.springframework.web.servlet.HandlerInterceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description: 异常拦截器
 * @author: weijian.yan
 * @create: 2019-01-06 22:31
 **/
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ControllerException {
    Class<? extends HandlerInterceptor>[] value() default {};
}
