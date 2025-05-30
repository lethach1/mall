package com.ecom.mall.common.api;

/* Giao diện mã trả về API */
public interface ErrorCode {

    /* Lấy mã lỗi */
    long getCode();

    /* Message trả về */
    String getMessage();
}
