package com.vincent.duduCore.interceptor;

import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

/**
 * @description: 错误拦截器 By WebRequestInterceptor
 * WebRequestInterceptorAdapter实现了AsyncHandlerInterceptor调用了WebRequestInterceptor
 * @author: weijian.yan
 * @create: 2019-01-06 14:49
 **/
public class ErrorInterceptorV2 implements WebRequestInterceptor {
    
    /*
    * @Description:
    * 我们主要用它来进行资源的准备工作
    * 无法像 HandlerInterceptorAdapter 一样，可以中断流程
    * @param null 
    * @return:  
    * @Author: weijian.yan 
    * @Date: 2019/1/6 
    */ 
    public void preHandle(WebRequest request) throws Exception {
        System.out.println("ErrorInterceptorV2, preHandle......");
    }

    /*
    * @Description:
    * 在 Controller 中的方法调用之后,视图返回被渲染之前被调用，所以可以在这个方法里面通过改变数据模型 ModelMap 来改变数据的展示
    * @param null
    * @return:
    * @Author: weijian.yan
    * @Date: 2019/1/6
    */
    public void postHandle(WebRequest request, ModelMap model) throws Exception {
        System.out.println("ErrorInterceptorV2, postHandle......");
    }

    /*
    * @Description:
    * 在视图返回并被渲染之后执行,可以在该方法中进行资源的释放操作
    * @param request
    * @param ex Exception 参数表示的是当前请求的异常对象，如果在 Controller 中抛出的异常已经被 Spring 的异常处理器给处理了的话，那么这个异常对象就是是 null
    * @return: void
    * @Author: weijian.yan
    * @Date: 2019/1/6
    */
    public void afterCompletion(WebRequest request, Exception ex) throws Exception {
        System.out.println("ErrorInterceptorV2, afterCompletion......");
    }
}
