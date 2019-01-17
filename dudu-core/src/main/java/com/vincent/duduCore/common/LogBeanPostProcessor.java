package com.vincent.duduCore.common;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @description: 调试容器注入
 * @author: weijian.yan
 * @create: 2019-01-09 10:02
 **/
public class LogBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("postProcessBeforeInitialization:" +beanName);

        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("postProcessAfterInitialization:" +beanName);

        return bean;
    }
}
