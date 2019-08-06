package com.luther.cloud.sentinel.handle;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * All rights Reserved, Designed by Luther
 *
 * @auther: Luther
 * @createdTime: 2019/8/6 16:39
 * @version： 0.0.1
 * @copyRight: @2019
 * TODO:
 */
public class BlockHandler {
    public static void blockHelloWorld(BlockException be) {
        System.out.println("other Class Block handler");
    }

    public static void blockHelloWorld2(BlockException be) {
        System.out.println("other Class Block handler2");
    }

    public static ResponseEntity<Void> blockLogin(String userName, String pwd, BlockException be) {
        System.out.println("login block");
        return ResponseEntity.status(201).body(null);
    }

    public static ResponseEntity<Void> blockLogin(String code, BlockException be) {
        System.out.println("wx login block");
        return ResponseEntity.status(201).body(null);
    }
}
