package com.luther.cloud.provider2.api;

import com.luther.cloud.provider2.sao.HelloSao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * All rights Reserved, Designed by Luther
 *
 * @auther: Luther
 * @createdTime: 2019/8/6 21:57
 * @version： 0.0.1
 * @copyRight: @2019
 * TODO:
 */
@RestController
@RequestMapping("api")
public class HelloController {
    private final HelloSao helloSao;

    public HelloController(HelloSao helloSao) {
        this.helloSao = helloSao;
    }

    @GetMapping("hello")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok(helloSao.hello());
    }
}
