package com.hong.demo.feigndemo.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)
public class PageDTO<T> {
    private Integer pageSize;
    private Integer pageNum;
    private Integer totalSize;
    private List<T> pageContent;
}
