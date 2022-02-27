package org.showcase.common.config.logconfig;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Component
public class LogInterceptor implements HandlerInterceptor {
    private static final String TRACE_ID = "traceId";

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception arg3) throws Exception {
        MDC.remove(TRACE_ID);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView arg3) throws Exception {
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String traceId = request.getHeader(TRACE_ID);
        if (StringUtils.isEmpty(traceId)) {
            MDC.put(TRACE_ID, UUID.randomUUID().toString());
        } else {
            MDC.put(TRACE_ID, traceId);
        }
        response.addHeader(TRACE_ID,traceId);
        return true;
    }

}
