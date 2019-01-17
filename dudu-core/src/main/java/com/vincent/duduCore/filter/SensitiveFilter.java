package com.vincent.duduCore.filter;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: 对敏感字符进行过滤
 * 过滤器基于JavaEE，拦截器只适用于SpringMVC
 * 拦截器是基于java的反射机制的，而过滤器是基于函数回调。
 * 拦截器不依赖与servlet容器，过滤器依赖与servlet容器。
 * 拦截器只能对action请求起作用，而过滤器则可以对几乎所有的请求起作用。
 * 拦截器可以访问action上下文、值栈里的对象，而过滤器不能访问。
 * 在action的生命周期中，拦截器可以多次被调用，而过滤器只能在容器初始化时被调用一次。
 * 拦截器可以获取IOC容器中的各个bean，而过滤器就不行，这点很重要，在拦截器里注入一个service，可以调用业务逻辑。
 * @author: weijian.yan
 * @create: 2019-01-06 21:57
 **/
public class SensitiveFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("SensitiveFilter init, filterConfig="+filterConfig);
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("SensitiveFilter doFilter before");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        chain.doFilter(request, response);

        System.out.println("SensitiveFilter doFilter after");
    }

    public void destroy() {
        System.out.println("SensitiveFilter destroy");
    }
}
