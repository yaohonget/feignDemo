package com.hong.demo.feign.testserver1.service;

import com.hong.demo.feigndemo.common.dto.PageDTO;
import com.hong.demo.feigndemo.common.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {
    private static List<UserDTO> userDTOS = new ArrayList<>();

    static {
        userDTOS.add(new UserDTO(1,"User1",10,"User1,Age 10Year"));
        userDTOS.add(new UserDTO(2,"User2",30,"User2,Age 30Year"));
        userDTOS.add(new UserDTO(3,"User3",19,"User3,Age 19Year"));
        userDTOS.add(new UserDTO(4,"User4",20,"User4,Age 20Year"));
        userDTOS.add(new UserDTO(5,"User5",19,"User5,Age 19Year"));
        userDTOS.add(new UserDTO(6,"User6",40,"User6,Age 40Year"));
        userDTOS.add(new UserDTO(7,"User7",19,"User7,Age 19Year"));
        userDTOS.add(new UserDTO(8,"User8",20,"User8,Age 20Year"));
        userDTOS.add(new UserDTO(9,"User9",10,"User9,Age 10Year"));
        userDTOS.add(new UserDTO(10,"User10",22,"User10,Age 22Year"));
        userDTOS.add(new UserDTO(11,"User11",19,"User11,Age 19Year"));
    }

    public UserDTO getUserById(Integer id){
        if(id == null){
            RuntimeException e = new RuntimeException("id should not be null");
            log.error("id should not be null",e);
            throw e;
        }
        Optional<UserDTO> first = Optional.ofNullable(userDTOS)
                .orElseGet(ArrayList::new)
                .stream()
                .filter(x -> id.equals(x.getId()))
                .findFirst();
        if(first.isPresent()){
            return first.get();
        }
        return null;
    }

    public PageDTO<UserDTO> getUserPage(PageDTO pageDTO) {
        int pageNum = pageDTO.getPageNum()==null||pageDTO.getPageNum()<0?0:pageDTO.getPageNum();
        int pageSize = pageDTO.getPageSize()==null||pageDTO.getPageSize()<=0?3:pageDTO.getPageSize();

        int startIndex = ((pageNum-1)*pageSize)<0?0:(pageNum-1)*pageSize;
        if(startIndex>userDTOS.size()){
            startIndex = (userDTOS.size() - pageSize)<0?0:userDTOS.size() - pageSize;
        }
        int endIndex = startIndex + pageSize;
        if(endIndex>userDTOS.size()){
            endIndex = userDTOS.size();
        }
        List<UserDTO> userDTOS = UserService.userDTOS.subList(startIndex, endIndex);
        PageDTO pages = new PageDTO();
        pages.setTotalSize(userDTOS.size());
        pages.setPageNum(pageNum);
        pages.setPageSize(pageSize);
        pages.setPageContent(userDTOS);
        return pages;
    }


}
