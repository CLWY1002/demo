package com.gigold.pay.demo.service;
///**
// * gigold Inc.  吉高支付 湖南宝伦天地信息科技有限公司
// * Copyright (c) 2015 All Rights Reserved.
// */
//package com.gigold.pay.demo.jmock;
//

//import com.gigold.pay.demo.bo.Person;
//import com.gigold.pay.demo.dao.DemoDAO;
//import com.gigold.pay.demo.service.CodeItem;
//import com.gigold.pay.demo.service.Demo2Service;
//import com.gigold.pay.demo.service.DemoService;
//import com.gigold.pay.framework.core.exception.AbortException;
//import com.gigold.pay.framework.core.log.DomainLogger;
//import org.jmock.Expectations;
//import org.jmock.Mockery;
//import org.jmock.integration.junit4.JUnitRuleMockery;
//import org.jmock.lib.legacy.ClassImposteriser;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Rule;
//import org.junit.Test;
//
///**
// * Demo2ServiceJmockTest Unit test
// *
// * @author mingbo.tang
// * @version $Id : Demo2ServiceJmockTest.java,v 0.1 2015年10月16日 13:43 mingbo.tang $Exp
// */
//public class Demo2ServiceJmockTest extends BaseTest {
//
//    /**
//     * ====================== mock上下文创建 ==========================
//     */
//    @Rule
//    public JUnitRuleMockery mockery = new JUnitRuleMockery();
//
//    /**====================== mock对象定义 ========================== **/
//    private DemoDAO      demoDAO;
//    private DemoService  demoService;
//    /**====================== 测试对象定义 ==========================**/
//    private Demo2Service demo2Service = new Demo2Service();
//
//    /**
//     * mock对象初始化
//     *
//     * @throws Exception the exception
//     */
//    @Before
//    public void setUp() throws Exception {
//        // 如果MOCK的是CLASS 不是INTERFACE必须加上此声明
//        mockery.setImposteriser(ClassImposteriser.INSTANCE);
//        // mock对象初始化
//        demoDAO = mockery.mock(DemoDAO.class);
//        demoService = mockery.mock(DemoService.class);
//        // 测试对象中被mock对象赋值
//        demo2Service.setDao(demoDAO);
//        demo2Service.setService(demoService);
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
//        mockery.checking(new Expectations() {
//            {
//                // 不限制调用次数
//                allowing(demoDAO).addPerson(with(any(Person.class)));
//                will(returnValue("1"));
//
//                // 至少调用两次
//                atLeast(2).of(demoService).addPerson(with(any(Person.class)));
//                will(onConsecutiveCalls(returnValue("1"),
//                    throwException(new AbortException(CodeItem._FAIL, "failed"))));
//            }
//        });
//        // 测试正常新增
//        String id = demo2Service.addPerson(new Person());
//        Assert.assertEquals("1", id);
//        // 测试抛出AbortException
//        try {
//            demo2Service.addPerson(new Person());
//        } catch (AbortException e) {
//            Assert.assertEquals(CodeItem._FAIL, e.getCode());
//        }
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
//        mockery.checking(new Expectations() {
//            {
//                // 至少调用两次
//                atLeast(2).of(demoService).modifyPerson(with(any(Person.class)));
//                will(onConsecutiveCalls(returnValue(true), returnValue(false)));
//            }
//        });
//        // 测试正常修改
//        boolean flag1 = demo2Service.modifyPerson(new Person());
//        Assert.assertTrue(flag1);
//        // 测试修改失败
//        boolean flag2 = demo2Service.modifyPerson(new Person());
//        Assert.assertFalse(flag2);
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
//        mockery.checking(new Expectations() {
//            {
//                // 只调用一次
//                oneOf(demoService).query(with(any(String.class)));
//                will(returnValue(p));
//            }
//        });
//        // 测试查询
//        Person person = demo2Service.query("随便输入");
//        Assert.assertEquals("1", person.getId());
//        Assert.assertEquals("张三", person.getName());
//        Assert.assertEquals(18, person.getAge());
//        // 校验expectations中的规则是否满足
//        mockery.assertIsSatisfied();
//    }
//}
