//package com.vincent.duduCore.interceptor;
//
///**
// * @description: 拦截器
// * 通过继承 Struts2 框架提供的AbstractInterceptor抽象类来实现拦截的功能
// * @author: weijian.yan
// * @create: 2019-01-06 14:53
// **/
//public class ErrorInterceptorV3   extends AbstractInterceptor{
//    public String intercept(ActionInvocation invocation) throws Exception {
//
//        UserInfo info = (UserInfo) ServletActionContext.getRequest().getSession().getAttribute("user");
//
//        if(info != null && !info.getName().equals("") && !info.getPwd().equals(""))
//        {
//            return invocation.invoke();
//        }
//        return "login";
//    }
//}
