package com.ecom.mall.common.exception;

import com.ecom.mall.common.api.ErrorCode;

/* Lớp xử lý Asserts, được sử dụng để đưa ra nhiều ngoại lệ API khác nhau */
public class Asserts {
    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(ErrorCode errorCode) {
        throw new ApiException(errorCode);
    }
}
