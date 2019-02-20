package com.vincent.duduCore.resolver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: 全局异常处理
 * @author: weijian.yan
 * @create: 2019-02-16 21:35
 **/
public class ExceptionResolver implements HandlerExceptionResolver {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ex.printStackTrace();

        logger.debug(ex.getMessage());

        //向前台返回错误信息
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", ex.getMessage());
        modelAndView.setViewName("/WEB-INF/views/share/error.jsp");

        return modelAndView;
    }
}
