package com.agis.AdminService.exception;

import com.agis.AdminService.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class RestResponseEntityExceptionHandler {

    @ExceptionHandler(PermissionServiceCustomException.class)
    public ResponseEntity<ErrorResponse> handleProductServiceException(PermissionServiceCustomException exception) {
        return new ResponseEntity<>(new ErrorResponse()
                .builder()
                .errorMessage(exception.getMessage())
                .errorCode(exception.getErrorCode()).build(), HttpStatus.NOT_FOUND);
    }
}
