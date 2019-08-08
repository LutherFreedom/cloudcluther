package com.luther.cloud.provider.api;

import com.luther.cloud.apis.HelloApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * All rights Reserved, Designed by Luther
 *
 * @auther: Luther
 * @createdTime: 2019/8/6 21:44
 * @version： 0.0.1
 * @copyRight: @2019
 * TODO:
 */
@RestController
@RequestMapping("api")
public class HelloController implements HelloApi {

    @GetMapping("hello")
    @Override
    public String hello() {
        return "hello";
    }

    @GetMapping("world")
    @Override
    public String world() {
        return "world";
    }
}
