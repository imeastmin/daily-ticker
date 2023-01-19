package com.gym.ticket.exception;

import com.gym.ticket.payload.ErrorResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ValidationException;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorResponse> callBadRequestException() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponse.error(CustomErrorCode.BAD_REQUEST, CustomErrorCode.BAD_REQUEST.getMessage()));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> callNotCorrectDataException() {
        return ResponseEntity.status(CustomErrorCode.NOT_CORRECT_DATA.getStatus())
                .body(ErrorResponse.error(CustomErrorCode.NOT_CORRECT_DATA, CustomErrorCode.NOT_CORRECT_DATA.getMessage()));
    }
}
