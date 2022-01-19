package com.hong.demo.feign.testserver1.controller;

import com.hong.demo.feign.testserver1.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private TestService feignTestService;

    @RequestMapping("test001")
    public String test001() {
        String str = feignTestService.test001();
        return str;
    }
}
