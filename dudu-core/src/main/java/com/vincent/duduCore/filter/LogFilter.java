package com.vincent.duduCore.filter;

import com.alibaba.fastjson.JSON;
import com.vincent.duduCore.log.TraceInfo;
import com.vincent.duduCore.utils.HttpServletRequestWrapperUtils;
import com.vincent.duduCore.utils.HttpServletResponseWrapperUtils;
import com.vincent.duduCore.utils.ServletRequestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogFilter implements Filter {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            HttpServletRequestWrapperUtils requestWrapper = new HttpServletRequestWrapperUtils(request);
            HttpServletResponseWrapperUtils responseWrapper = new HttpServletResponseWrapperUtils(response);

            TraceInfo trace = new TraceInfo();
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();

            trace.setRequestBody(ServletRequestUtils.getBodyString(requestWrapper));
            chain.doFilter(requestWrapper, responseWrapper);
            trace.setResponseBody(responseWrapper.getResponseBody());
            response.getWriter().write(trace.getResponseBody());

            stopWatch.stop();
            trace.setExecutionTime(stopWatch.getTotalTimeSeconds());
            logger.trace(JSON.toJSONString(trace));

            return;
        }

        chain.doFilter(req, res);
    }
}
