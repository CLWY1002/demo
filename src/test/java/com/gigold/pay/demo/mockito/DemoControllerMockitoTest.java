/**
 * gigold Inc.  吉高支付 湖南宝伦天地信息科技有限公司
 * Copyright (c) 2015 All Rights Reserved.
 */
package com.gigold.pay.demo.mockito;

import static org.mockito.Mockito.*;

import javax.servlet.http.HttpSession;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.gigold.pay.demo.BaseTest;
import com.gigold.pay.demo.bo.Person;
import com.gigold.pay.demo.controller.DemoController;
import com.gigold.pay.demo.controller.QueryDemoReqDto;
import com.gigold.pay.demo.controller.QueryDemoResDto;
import com.gigold.pay.demo.service.CodeItem;
import com.gigold.pay.demo.service.DemoService;
import com.gigold.pay.framework.base.SpringContextHolder;
import com.gigold.pay.framework.core.SysCode;
import com.gigold.pay.framework.core.exception.AbortException;

/**
 * The type Demo controller mockito test.
 *
 * @author mingbo.tang
 * @version $Id : DemoControllerMockitoTest.java,v 0.1 2015年10月17日 17:18 mingbo.tang $Exp
 */
@RunWith(PowerMockRunner.class)
public class DemoControllerMockitoTest extends BaseTest {

    /**
     * ====================== mock上下文创建 ==========================
     */
    //    @Rule
    //    public MockitoRule mockery = MockitoJUnit.rule();

    //    @Rule
    //    public PowerMockRule rule = new PowerMockRule();

    /**====================== mock对象定义 ========================== **/
    @Mock
    private DemoService demoService;

    @Mock
    private HttpSession session;

    /**====================== 测试对象定义 ==========================**/
    private DemoController demoController = new DemoController();

    /**
     * mock对象初始化
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        // 测试对象中被mock对象赋值
        demoController.setDemoService(demoService);
    }

    /**
     * Test query demo res dto.
     */
    @Test
    public void testQueryDemoResDto() {
        // 数据初始化
        final Person p = new Person();
        p.setId("1");
        p.setAge(18);
        p.setName("张三");
        p.setDesc("测试");

        QueryDemoReqDto dto = new QueryDemoReqDto();
        dto.setPerson(p);

        // 模拟设置期望
        when(demoService.query(anyString())).thenReturn(p).thenReturn(null);
        // 测试查询成功
        QueryDemoResDto result1 = demoController.query(dto);
        Assert.assertEquals(SysCode.SUCCESS, result1.getRspCd());
        Assert.assertEquals("1", result1.getPerson().getId());

        // 测试查询失败
        QueryDemoResDto result2 = demoController.query(dto);
        Assert.assertEquals("D0000", result2.getRspCd());

        // 确认执行顺序、次数与传入参数
        verify(demoService, times(2)).query(anyString());
    }

    /**
     * Test query demo res dto 1.
     */
    @Test
    public void testQueryDemoResDto1() {
        // 数据初始化
        final Person p = new Person();
        p.setId("1");
        p.setAge(18);
        p.setName("张三");
        p.setDesc("测试");

        // 模拟设置期望
        when(demoService.query(anyString())).thenReturn(p).thenReturn(null);
        // 测试查询成功
        QueryDemoResDto result1 = demoController.query2();
        Assert.assertEquals(SysCode.SUCCESS, result1.getRspCd());
        Assert.assertEquals("1", result1.getPerson().getId());

        // 测试查询失败
        QueryDemoResDto result2 = demoController.query2();
        Assert.assertEquals("D0000", result2.getRspCd());

        // 确认执行顺序、次数与传入参数
        verify(demoService, times(2)).query(anyString());
    }

    /**
     * Test insert.
     *
     * @throws AbortException the abort exception
     */
    @Test
    // 需要MOCK静态方法是必须加上次注解
    @PrepareForTest(SpringContextHolder.class)
    public void testInsert() throws AbortException {
        // 数据初始化
        final Person p = new Person();
        p.setId("1");
        p.setAge(18);
        p.setName("张三");
        p.setDesc("测试");

        // 模拟设置期望
        PowerMockito.mockStatic(SpringContextHolder.class);
        when(SpringContextHolder.getBean(Person.class)).thenReturn(p);

        when(demoService.addPerson(any(Person.class))).thenReturn("11")
            .thenThrow(new AbortException(CodeItem._FAIL, "failed"));

        // 测试插入成功
        QueryDemoResDto result1 = demoController.insert(session);
        Assert.assertEquals(SysCode.SUCCESS, result1.getRspCd());

        // 测试插入失败
        QueryDemoResDto result2 = demoController.insert(session);
        Assert.assertEquals("50000", result2.getRspCd());

        // 确认执行顺序、次数与传入参数
        verify(demoService, times(2)).addPerson(any(Person.class));
        PowerMockito.verifyStatic();
    }

    /**
     * Test get.
     *
     * @throws AbortException the abort exception
     */
    @Test
    public void testGet() throws AbortException {
        // 测试成功
        QueryDemoResDto result1 = demoController.get(session);
        Assert.assertEquals(SysCode.SUCCESS, result1.getRspCd());
    }

    /**
     * Test add.
     *
     * @throws AbortException the abort exception
     */
    @Test
    // 需要MOCK静态方法是必须加上次注解
    @PrepareForTest(SpringContextHolder.class)
    public void testAdd() throws AbortException {
        // 数据初始化
        final Person p = new Person();
        p.setId("1");
        p.setAge(18);
        p.setName("张三");
        p.setDesc("测试");

        // 模拟设置期望
        PowerMockito.mockStatic(SpringContextHolder.class);
        when(SpringContextHolder.getBean(Person.class)).thenReturn(p);

        when(demoService.addPersonFail(any(Person.class))).thenReturn("11")
                .thenThrow(new AbortException(CodeItem._FAIL, "failed"));

        // 测试成功
        QueryDemoResDto result1 = demoController.add();
        Assert.assertEquals(SysCode.SUCCESS, result1.getRspCd());

        // 测试失败
        QueryDemoResDto result2 = demoController.add();
        Assert.assertEquals(SysCode.SYS_FAIL, result2.getRspCd());

        // 确认执行顺序、次数与传入参数
        verify(demoService, times(2)).addPersonFail(any(Person.class));
        // 静态方法调用验证
        PowerMockito.verifyStatic();
    }

    /**
     * Test add 1.
     *
     * @throws AbortException the abort exception
     */
    @Test
    // 需要MOCK静态方法是必须加上次注解
    @PrepareForTest(SpringContextHolder.class)
    public void testAdd1() throws AbortException {
        // 数据初始化
        final Person p = new Person();
        p.setId("1");
        p.setAge(18);
        p.setName("张三");
        p.setDesc("测试");

        // 模拟设置期望
        PowerMockito.mockStatic(SpringContextHolder.class);
        when(SpringContextHolder.getBean(Person.class)).thenReturn(p);

        when(demoService.addPerson(any(Person.class))).thenReturn("11")
                .thenThrow(new AbortException(CodeItem._FAIL, "failed"));

        // 测试成功
        QueryDemoResDto result1 = demoController.add1();
        Assert.assertEquals(SysCode.SUCCESS, result1.getRspCd());

        // 测试失败
        QueryDemoResDto result2 = demoController.add1();
        Assert.assertEquals(SysCode.SYS_FAIL, result2.getRspCd());

        // 确认执行顺序、次数与传入参数
        verify(demoService, times(2)).addPerson(any(Person.class));
        // 静态方法调用验证
        PowerMockito.verifyStatic();
    }

    /**
     * Test add 2.
     *
     * @throws AbortException the abort exception
     */
    @Test
    // 需要MOCK静态方法是必须加上次注解
    @PrepareForTest(SpringContextHolder.class)
    public void testAdd2() throws AbortException {
        // 数据初始化
        final Person p = new Person();
        p.setId("1");
        p.setAge(18);
        p.setName("张三");
        p.setDesc("测试");

        // 模拟设置期望
        PowerMockito.mockStatic(SpringContextHolder.class);
        when(SpringContextHolder.getBean(Person.class)).thenReturn(p);

        when(demoService.addPerson(any(Person.class))).thenReturn("11")
                .thenThrow(new AbortException(CodeItem._FAIL, "failed"));

        // 测试成功
        QueryDemoResDto result1 = demoController.add2();
        Assert.assertEquals(SysCode.SUCCESS, result1.getRspCd());

        // 测试失败
        QueryDemoResDto result2 = demoController.add2();
        Assert.assertEquals(SysCode.SYS_FAIL, result2.getRspCd());

        // 确认执行顺序、次数与传入参数
        verify(demoService, times(2)).addPerson(any(Person.class));
        // 静态方法调用验证
        PowerMockito.verifyStatic();
    }

    /**
     * Test only.
     *
     * @throws AbortException the abort exception
     */
    @Test
    // 需要MOCK静态方法是必须加上次注解
    @PrepareForTest(SpringContextHolder.class)
    public void testOnly() throws AbortException {
        // 数据初始化
        final Person p = new Person();
        p.setId("1");
        p.setAge(18);
        p.setName("张三");
        p.setDesc("测试");

        // 模拟设置期望
        PowerMockito.mockStatic(SpringContextHolder.class);
        when(SpringContextHolder.getBean(Person.class)).thenReturn(p);

        when(demoService.addPerson(any(Person.class))).thenReturn("11")
                .thenThrow(new AbortException(CodeItem._FAIL, "failed"));

        // 测试成功
        QueryDemoResDto result1 = demoController.only();
        Assert.assertEquals(SysCode.SUCCESS, result1.getRspCd());

        // 测试失败
        QueryDemoResDto result2 = demoController.only();
        Assert.assertEquals(SysCode.SYS_FAIL, result2.getRspCd());

        // 确认执行顺序、次数与传入参数
        verify(demoService, times(2)).addPerson(any(Person.class));
        // 静态方法调用验证
        PowerMockito.verifyStatic();
    }
}
