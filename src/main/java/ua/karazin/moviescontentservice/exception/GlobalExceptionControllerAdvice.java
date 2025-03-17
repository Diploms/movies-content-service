package ua.karazin.moviescontentservice.exception;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;

import java.io.IOException;
import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionControllerAdvice {
    @ExceptionHandler({
            ConstraintViolationException.class,
            MissingPathVariableException.class,
            IllegalArgumentException.class
    })
    public void handleConstraintViolationException(ServletWebRequest webRequest, Exception ex) throws IOException {
        sendError(webRequest, ex, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({
            NoSuchElementException.class,
            EntityNotFoundException.class
    })
    public void handle404Exceptions(ServletWebRequest webRequest, Exception ex) throws IOException {
        sendError(webRequest, ex, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({
            EntityExistsException.class
    })
    public void handle422Exceptions(ServletWebRequest webRequest, Exception ex) throws IOException {
        sendError(webRequest, ex, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    private void sendError(ServletWebRequest webRequest, Exception exception, HttpStatus httpStatus) throws IOException {
        webRequest
                .getResponse()
                .sendError(httpStatus.value(), exception.getMessage());
    }
}
