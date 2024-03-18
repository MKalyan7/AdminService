package com.agis.AdminService.exception;

import lombok.Data;

@Data
public class PermissionServiceCustomException extends RuntimeException{

    private String errorCode;

    public PermissionServiceCustomException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
