package com.luther.cloud.sentinel.api;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.luther.cloud.sentinel.handle.BlockHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * All rights Reserved, Designed by Luther
 *
 * @auther: Luther
 * @createdTime: 2019/8/6 16:11
 * @version： 0.0.1
 * @copyRight: @2019
 * TODO:
 */
@RestController
@RequestMapping("/login")
public class Login {

    @RequestMapping("/lg")
    @SentinelResource(value = "login", blockHandler = "blockLogin", blockHandlerClass = BlockHandler.class)
    public ResponseEntity<Void> login(@RequestParam("userName") String userName, @RequestParam("pwd") String password) {
        return ResponseEntity.ok(null);
    }

    @RequestMapping("/wxlg")
    public ResponseEntity<Void> login(@RequestParam("code") String code) {
        return ResponseEntity.ok(null);
    }
}
