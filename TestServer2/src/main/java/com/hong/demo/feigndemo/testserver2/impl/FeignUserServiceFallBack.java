package com.hong.demo.feigndemo.testserver2.impl;

import com.hong.demo.feigndemo.common.dto.PageDTO;
import com.hong.demo.feigndemo.common.dto.ResponseData;
import com.hong.demo.feigndemo.common.dto.UserDTO;
import com.hong.demo.feigndemo.common.enums.ErrorCodeEnum;
import com.hong.demo.feigndemo.testserver2.service.TestService2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FeignUserServiceFallBack implements TestService2 {
    @Override
    public ResponseData<UserDTO> getUserById(Integer id) {
        log.error("FeignUserServiceFallBack-getUserById-failed");
        return ResponseData.response(ErrorCodeEnum.FAIL,null);
    }

    @Override
    public ResponseData<PageDTO<UserDTO>> getUserPage(PageDTO pageDTO) {
        log.error("FeignUserServiceFallBack-getUserPage-failed");
        return ResponseData.response(ErrorCodeEnum.FAIL,null);
    }
}
