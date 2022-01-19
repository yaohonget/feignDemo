package com.hong.demo.feigndemo.common.dto;

import com.hong.demo.feigndemo.common.enums.ErrorCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Data
@Accessors(chain=true)
public class ResponseData<T> {
    private String code;
    private String msg;
    private T data;

    public static <T> ResponseData<T> response(ErrorCodeEnum errorCodeEnum, T data){
        return new ResponseData(errorCodeEnum.getCode(),errorCodeEnum.getMsg(),data);
    }
}
