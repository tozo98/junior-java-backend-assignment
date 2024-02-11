package io.falcon.assignment.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.DateTimeException;

@ControllerAdvice
public class MessageConsumerRestControllerAdvice extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageConsumerRestControllerAdvice.class);

    @ExceptionHandler(DateTimeException.class)
    public ResponseEntity<Object> handleDateTimeException(DateTimeException ex, WebRequest request) {
        LOGGER.error(ex.getMessage(), ex);
        String errorMessage = "Timestamp has incorrect format.";
        return handleExceptionInternal(ex, errorMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

}
