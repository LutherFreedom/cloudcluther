package com.luther.cloud.sentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.luther.cloud.sentinel.handle.BlockHandler;
import com.luther.cloud.sentinel.handle.FallBackHandle;
import org.springframework.stereotype.Component;

/**
 * All rights Reserved, Designed by Luther
 *
 * @auther: Luther
 * @createdTime: 2019/8/6 15:15
 * @version： 0.0.1
 * @copyRight: @2019
 * TODO:
 */
@Component
public class AnnotationDemo {
    @SentinelResource(value = "HelloWorld", blockHandler = "outBlock", fallback = "fallback")
    public void testAnnotation() {
        System.out.println("helloWord2");
    }

    @SentinelResource(value = "HelloWorld", blockHandler = "blockHelloWorld", blockHandlerClass = BlockHandler.class)
    public void testAnnotation2() {
        System.out.println("helloWord3");
    }

    @SentinelResource(value = "HelloWorld", blockHandler = "blockHelloWorld2", blockHandlerClass = BlockHandler.class,
            fallback = "fallback", fallbackClass = FallBackHandle.class,exceptionsToIgnore = IllegalAccessException.class)
    public void testIgnoreException() throws IllegalAccessException {
        System.out.println("helloWord4");
//        throw new IllegalAccessException("ASDADA");
    }

    public void outBlock(BlockException be) {
        System.out.println("blocked2!");
    }

    public void fallback(Throwable throwable) {
        throwable.printStackTrace();
        System.out.println(throwable.getMessage());
        System.out.println("fallback!");
    }

}
