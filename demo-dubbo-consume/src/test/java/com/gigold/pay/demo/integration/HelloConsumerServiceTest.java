package com.gigold.pay.demo.integration;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gigold.pay.framework.service.AbstractService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath*:/**/spring/**/*Beans.xml" })
public class HelloConsumerServiceTest extends AbstractService {
    @Autowired
    public PubMsgConsumerIntegration pubMsgConsumerIntegration;

    @Test
    public void testSayHello() {
        String message = null;
        List resultList = null;
        try {
            resultList = pubMsgConsumerIntegration.getMsgInfo("ALL");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("resultList:" + resultList);
        // System.out.println(resultList.size());
        Assert.assertEquals("you", message);

    }
}
