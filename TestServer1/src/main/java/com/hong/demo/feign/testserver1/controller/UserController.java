package com.hong.demo.feign.testserver1.controller;

import com.hong.demo.feign.testserver1.service.UserService;
import com.hong.demo.feigndemo.common.dto.PageDTO;
import com.hong.demo.feigndemo.common.dto.ResponseData;
import com.hong.demo.feigndemo.common.dto.UserDTO;
import com.hong.demo.feigndemo.common.enums.ErrorCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Value("${server.port}")
    private Integer serverPort;

    @GetMapping(value = "/getUserById/{userId}")
    public ResponseData<UserDTO> getUserById(@PathVariable(name="userId")Integer id, HttpServletRequest request){
        log.info("SERVER_PORT={},userId={}",serverPort,id);
        log.info("token={}",request.getHeader("token"));
        //int i = 1 / 0;
        UserDTO userDTO = userService.getUserById(id);
        return ResponseData.response(ErrorCodeEnum.SUCCESS,userDTO);
    }

    @PostMapping("/getUserPage")
    ResponseData<PageDTO<UserDTO>> getUserPage(PageDTO pageDTO){
        log.info("pageDTO={}", pageDTO);
        PageDTO<UserDTO> pages =  userService.getUserPage(pageDTO);
        return ResponseData.response(ErrorCodeEnum.SUCCESS,pages);
    }
}
