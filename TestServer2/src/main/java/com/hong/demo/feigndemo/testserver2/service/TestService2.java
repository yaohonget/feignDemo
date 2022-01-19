package com.hong.demo.feigndemo.testserver2.service;

import com.hong.demo.feigndemo.common.dto.PageDTO;
import com.hong.demo.feigndemo.common.dto.ResponseData;
import com.hong.demo.feigndemo.common.dto.UserDTO;
import com.hong.demo.feigndemo.testserver2.impl.FeignUserServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="demo-server-1000", fallback=FeignUserServiceFallBack.class) //configuration
public interface TestService2 {
    @GetMapping(value = "/user/getUserById/{userId}")
    ResponseData<UserDTO> getUserById(@PathVariable(name="userId") Integer id);

    @RequestMapping(value = "/user/getUserPage",method=RequestMethod.GET)
    ResponseData<PageDTO<UserDTO>> getUserPage(PageDTO pageDTO);
}
