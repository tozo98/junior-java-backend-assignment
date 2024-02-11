package io.falcon.assignment.aop;

import io.falcon.assignment.domain.EnrichedMessageResponse;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class EnrichedMessageProviderLogger {

    private static final Logger LOGGER = LoggerFactory.getLogger(EnrichedMessageProviderLogger.class);

    @Pointcut("execution (* io.falcon.assignment.service.EnrichedMessageProvider.findAll(..))")
    public void executeFindAllMethod() {
    }

    @AfterReturning(value = "executeFindAllMethod()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, List<EnrichedMessageResponse> result) {
        LOGGER.info("Returned messages: {}", result);
    }
}
