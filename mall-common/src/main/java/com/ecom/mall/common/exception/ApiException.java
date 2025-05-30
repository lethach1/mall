package com.ecom.mall.common.exception;

import com.ecom.mall.common.api.ErrorCode;

/* Custom API Exceptions */
public class ApiException extends RuntimeException {
    private ErrorCode errorCode;

    public ApiException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
