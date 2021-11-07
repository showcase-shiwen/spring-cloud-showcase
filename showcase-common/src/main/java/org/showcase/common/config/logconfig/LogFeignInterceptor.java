package org.showcase.common.config.logconfig;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.MDC;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogFeignInterceptor  implements RequestInterceptor {

    private static final String TRACE_ID = "traceId";

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header(TRACE_ID, MDC.get(TRACE_ID));
    }
}
