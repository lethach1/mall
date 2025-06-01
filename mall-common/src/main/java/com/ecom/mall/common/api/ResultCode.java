package com.ecom.mall.common.api;

public enum ResultCode implements ErrorCode {
    SUCCESS(200, "Operation completed successfully"),
    FAILED(500, "Operation encountered an error"),
    VALIDATE_FAILED(404, "Parameter validation failed"),
    UNAUTHORIZED(401, "User is not logged in or token has expired"),
    FORBIDDEN(403, "Access is denied due to insufficient permissions");

    private long code;
    private String message;

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}