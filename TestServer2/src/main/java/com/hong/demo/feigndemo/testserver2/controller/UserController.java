package com.hong.demo.feigndemo.testserver2.controller;

import com.hong.demo.feigndemo.common.dto.PageDTO;
import com.hong.demo.feigndemo.common.dto.ResponseData;
import com.hong.demo.feigndemo.common.dto.UserDTO;
import com.hong.demo.feigndemo.testserver2.service.TestService2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Qualifier("com.hong.demo.feigndemo.testserver2.service.TestService2")
    @Autowired
    private TestService2 feignUserService;

    @GetMapping(value = "/getUserById/{userId}")
    public ResponseData<UserDTO> getUserById(@PathVariable(name="userId")Integer id, HttpServletRequest request){
        log.info("token={}",request.getHeader("token"));
        log.info("userId={}",id);
        log.debug("userId={}",id);
        log.error("userId={}",id);
        ResponseData<UserDTO> responseData = feignUserService.getUserById(id);
        return responseData;
    }

    @GetMapping(value ="/getUserPage")
    public ResponseData<PageDTO<UserDTO>> getUserPage(PageDTO pageDTO){
        ResponseData<PageDTO<UserDTO>> responseData =  feignUserService.getUserPage(pageDTO);
        return responseData;
    }
}
