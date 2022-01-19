package com.hong.demo.feign.testserver1.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="start.spring.io", url="https://start.spring.io/actuator/info")
public interface TestService {
    @RequestMapping(value="")
    public String test001();
}
