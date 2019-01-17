package com.vincent.duduCore.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: 错误拦截器 by HandlerInterceptorAdapter
 * 通过直接实现HandlerInterceptor接口来实现拦截器的功能。不过在 Spring 框架之中，其还提供了AsyncHandlerInterceptor和HandlerInterceptorAdapter.
 * HandlerInterceptorAdapter继承了AsyncHandlerInterceptor继承了HandlerInterceptor
 * @author: weijian.yan
 * @create: 2019-01-06 14:36
 **/
public class ErrorInterceptor extends HandlerInterceptorAdapter {
    @Override
    /*
    * @Description:
    * 在请求处理前执行，可进行一些前置初始化操作或者是对当前请求做一个预处理，通过返回值 True/False 是否继续执行下去
    * 一个请求中可以同时存在多个 Interceptor 。每个 Interceptor 的调用会依据它的声明顺序依次执行
    * @param request
    * @param response
    * @param handler 
    * @return: boolean 
    * @Author: weijian.yan 
    * @Date: 2019/1/6 
    */ 
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("ErrorInterceptor, preHandle......");
        return true;
    }

    @Override
    /*
    * @Description: preHandle 返回 True 才会执行
    * 在 Controller 中的方法调用之后,在 DispatcherServlet 进行视图返回渲染之前被调用;对 Controller 处理之后的 ModelAndView 对象进行操作
    * 先声明的 Interceptor 的 postHandle 方法反而会后执行
    * @param request
    * @param response
    * @param handler
    * @param modelAndView 
    * @return: void 
    * @Author: weijian.yan 
    * @Date: 2019/1/6 
    */ 
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
        System.out.println("ErrorInterceptor, postHandle......");
    }

    @Override
    /*
    * @Description:  preHandle 返回 True 才会执行
    * 在 DispatcherServlet 渲染了对应的视图之后执行，这个方法的主要作用是用于进行资源清理的工作
    * @param request
    * @param response
    * @param handler
    * @param ex Exception 参数表示的是当前请求的异常对象，如果在 Controller 中抛出的异常已经被 Spring 的异常处理器给处理了的话，那么这个异常对象就是是 null
    * @return: void
    * @Author: weijian.yan
    * @Date: 2019/1/6
    */
    public void afterCompletion(
            HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println("ErrorInterceptor, afterCompletion......");
    }

    @Override
    public void afterConcurrentHandlingStarted(
            HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("ErrorInterceptor, afterConcurrentHandlingStarted......");
    }
}
