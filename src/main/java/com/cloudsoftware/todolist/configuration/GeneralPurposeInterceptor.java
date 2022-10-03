package com.cloudsoftware.todolist.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GeneralPurposeInterceptor implements HandlerInterceptor {

    private final Logger LOGGER = LoggerFactory.getLogger(GeneralPurposeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LOGGER.info("In preHandle method of generalPurposeInterceptor");
        Long startTime = System.currentTimeMillis();
        request.setAttribute("startTime",startTime);
        String header = request.getHeader("X-AUTH-KEY");
        LOGGER.info(header);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long endTime = System.currentTimeMillis();
        long startTime = (Long) request.getAttribute("startTime");

        LOGGER.info("In postHandle : remote address processed this request took " + (endTime - startTime) + "ms");
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LOGGER.info("In afterCompletion method of generalPurposeInterceptor");
    }
}
