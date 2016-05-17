///**
// * gigold Inc.  吉高支付 湖南宝伦天地信息科技有限公司
// * Copyright (c) 2015 All Rights Reserved.
// */
//package com.gigold.pay.demo.service;
//
//
//import com.gigold.pay.framework.base.transaction.GigoldTransactionTemplate;
//import com.gigold.pay.framework.channel.test.BaseTest;
//import com.gigold.pay.framework.channel.test.TransactionTemplateStuk;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
//import com.gigold.pay.demo.bo.Person;
//import com.gigold.pay.demo.dao.DemoDAO;
//import com.gigold.pay.demo.service.CodeItem;
//import com.gigold.pay.demo.service.Demo2Service;
//import com.gigold.pay.demo.service.DemoService;
//import com.gigold.pay.framework.core.exception.AbortException;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.stubbing.OngoingStubbing;
//import org.powermock.modules.junit4.PowerMockRunner;
//import org.springframework.transaction.support.TransactionCallback;
//import org.springframework.transaction.support.TransactionTemplate;
//
//import static org.mockito.Mockito.*;
//
///**
// * Demo2ServiceMockitoTest Unit test
// *
// * @author mingbo.tang
// * @version $Id : Demo2ServiceMockitoTest.java,v 0.1 2015年10月16日 13:43 mingbo.tang $Exp
// */
//@RunWith(PowerMockRunner.class)
//public class Demo2ServiceMockitoTest extends BaseTest {
//
//    /**
//     * ====================== mock上下文创建 ==========================
//     */
//    //    @Rule
//    //    public MockitoRule mockery = MockitoJUnit.rule();
//
//    //    @Rule
//    //    public PowerMockRule rule = new PowerMockRule();
//
//    /**
//     * ====================== mock对象定义 ==========================
//     **/
//    @Mock
//    private DemoDAO                   demoDAO;
//
//    @Mock
//    private DemoService               demoService;
//
//    private GigoldTransactionTemplate newTransactionTemplate = new TransactionTemplateStuk();
//
//    /**
//     * ====================== 测试对象定义 ==========================
//     **/
//    private Demo2Service              demo2Service        = new Demo2Service();
//
//    /**
//     * mock对象初始化
//     *
//     * @throws Exception the exception
//     */
//    @Before
//    public void setUp() throws Exception {
//        // 测试对象中被mock对象赋值
//        demo2Service.setDao(demoDAO);
//        demo2Service.setService(demoService);
//        demo2Service.setNewTransactionTemplate(newTransactionTemplate);
//    }
//
//    /**
//     * Test add person.
//     *
//     * @throws AbortException the abort exception
//     */
//    @Test
//    public void testAddPerson() throws AbortException {
//
//        // 模拟设置期望
//
//        when(demoDAO.addPerson(any(Person.class))).thenReturn(1L);
//        when(demoService.addPerson(any(Person.class))).thenReturn(1L)
//            .thenThrow(new AbortException(CodeItem._FAIL, "failed"))
//            .thenThrow(new RuntimeException("my failed"));
//        // 测试正常新增
//        Long id1 = demo2Service.addPerson(new Person());
//        Assert.assertTrue(1L== id1);
//        // 测试抛出AbortException
//        Long id2 = demo2Service.addPerson(new Person());
//        Assert.assertNull(id2);
//        // 测试抛出未知RuntimeException
//        Long id3 = demo2Service.addPerson(new Person());
//        Assert.assertNull(id3);
//
//        // 确认执行顺序、次数与传入参数
//        verify(demoDAO, times(3)).addPerson(any(Person.class));
//        verify(demoService, atLeast(3)).addPerson(any(Person.class));
//    }
//
//    /**
//     * Test modify person.
//     *
//     * @throws AbortException the abort exception
//     */
//    @Test
//    public void testModifyPerson() throws AbortException {
//
//        // 模拟设置期望
//        when(demoService.modifyPerson(any(Person.class))).thenReturn(true).thenReturn(false);
//        // 测试正常修改
//        boolean flag1 = demo2Service.modifyPerson(new Person());
//        Assert.assertTrue(flag1);
//        // 测试修改失败
//        boolean flag2 = demo2Service.modifyPerson(new Person());
//        Assert.assertFalse(flag2);
//        // 确认执行顺序、次数与传入参数
//        verify(demoService, times(2)).modifyPerson(any(Person.class));
//    }
//
//    /**
//     * Test query.
//     *
//     * @throws AbortException the abort exception
//     */
//    @Test
//    public void testQuery() throws AbortException {
//        final Person p = new Person();
//        p.setId("1");
//        p.setAge(18);
//        p.setName("张三");
//        p.setDesc("测试");
//
//        // 模拟设置期望
//        when(demoService.query(any(Person.class))).thenReturn(p);
//        // 测试查询
//        Person person = demo2Service.query("随便输入");
//        Assert.assertEquals("1", person.getId());
//        Assert.assertEquals("张三", person.getName());
//        Assert.assertEquals(18, person.getAge());
//        // 确认执行顺序、次数与传入参数
//        verify(demoService, times(1)).query(any(Person.class));
//    }
//}
