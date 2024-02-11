package io.falcon.assignment.aop;

import io.falcon.assignment.domain.MessageEntity;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MessageSaverLogger {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageSaverLogger.class);


    @Pointcut("execution (* io.falcon.assignment.dataaccess.MessageRepository.save(..))")
    public void executeSaveMethod() {
    }

    @AfterReturning(value = "executeSaveMethod()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, MessageEntity result) {
        LOGGER.info("MessageEntity saved! {}", result);
    }


}
