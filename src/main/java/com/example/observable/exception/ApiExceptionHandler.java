package com.example.observable.exception;


import com.example.observable.util.UriUtil;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestControllerAdvice
public class ApiExceptionHandler {

    private final MessageSource messageSource;

    public ApiExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiErrorResponse handleUserNotFoundException(Exception exception) {
        List<Message> messages = Arrays.asList(new Message(exception.getMessage()));
        return new ApiErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now(), messages, UriUtil.path());
    }

    @ExceptionHandler(RestClientException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrorResponse handleRestClientException(Exception exception) {
        List<Message> messages = Arrays.asList(new Message(exception.getMessage()));
        return new ApiErrorResponse(HttpStatus.BAD_REQUEST, LocalDateTime.now(), messages, UriUtil.path());
    }

    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrorResponse handleHttpClientErrorException(Exception exception) {
        List<Message> messages = Arrays.asList(new Message(exception.getMessage()));
        return new ApiErrorResponse(HttpStatus.NOT_FOUND, LocalDateTime.now(), messages, UriUtil.path());
    }


}
