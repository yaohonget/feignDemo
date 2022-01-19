package com.hong.demo.feigndemo.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCodeEnum {
    SUCCESS("0000","successful"),
    FAIL("1111","failed"),
    ERROR("9999","unknown"),
    ;
    private String code;
    private String msg;

}
