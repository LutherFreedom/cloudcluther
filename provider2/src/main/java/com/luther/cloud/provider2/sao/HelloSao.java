package com.luther.cloud.provider2.sao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * All rights Reserved, Designed by Luther
 *
 * @auther: Luther
 * @createdTime: 2019/8/6 21:54
 * @version： 0.0.1
 * @copyRight: @2019
 * TODO:
 */
@FeignClient("provider")
public interface HelloSao{

    @GetMapping("api/hello")
     String hello();

    @GetMapping("api/world")
     String world();
}
