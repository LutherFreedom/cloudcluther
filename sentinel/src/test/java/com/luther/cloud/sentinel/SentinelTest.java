package com.luther.cloud.sentinel;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * All rights Reserved, Designed by Luther
 *
 * @auther: Luther
 * @createdTime: 2019/8/6 15:00
 * @version： 0.0.1
 * @copyRight: @2019
 * TODO:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SentinelTest {

    @Autowired
    private AnnotationDemo demo;

    @Test
    public void test() {
        long start = System.currentTimeMillis();
        initFlowRules();
        while (System.currentTimeMillis() - start < 2000) {
            demo.testAnnotation();
        }
    }

    @Test
    public void testCode(){
        long start = System.currentTimeMillis();
        initFlowRules();
        while (System.currentTimeMillis() - start < 2000) {
            effectCode();
        }
    }

    @Test
    public void testAnotherClass(){
        long start = System.currentTimeMillis();
        initFlowRules();
        while (System.currentTimeMillis() - start < 2000) {
            demo.testAnnotation2();
        }
    }

    @Test
    public void testIgnoreException() throws IllegalAccessException {
        long start = System.currentTimeMillis();
        initFlowRules();
        while (System.currentTimeMillis() - start < 2000) {
            demo.testIgnoreException();
        }
    }

    public void effectCode(){
        try (Entry entry = SphU.entry("HelloWorld")) {
            System.out.println("hello world");
        } catch (BlockException e) {
            System.out.println("blocked!");
        }
    }

    private void initFlowRules() {
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("HelloWorld");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setCount(20);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }
}
