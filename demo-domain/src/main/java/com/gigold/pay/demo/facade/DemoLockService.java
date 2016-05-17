package com.gigold.pay.demo.facade;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.gigold.pay.framework.coordination.LockService;
import com.gigold.pay.framework.core.Domain;

@Component
public class DemoLockService extends Domain {

	private static final long serialVersionUID = 2542937828801068911L;

	@Autowired
	private LockService lockService;

	public void testLock() throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(100);
		for (int i = 0; i < 100; i++) {
			DemoLockThread t = new DemoLockThread();
			t.setLockService(lockService);
			service.execute(t);
			//Thread.sleep(1000);
		}
		service.shutdown();
	}

	public static void main(String[] args) throws InterruptedException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath*:/**/spring/**/*Beans.xml");
		try {
			context.start();
			DemoLockService service = context.getBean(DemoLockService.class);
			service.testLock();
		} finally {
			Thread.sleep(30*1000);//防止线程没执行完然后关闭上下文
			context.stop();
			context.close();
		}
		System.out.println("main end");
	}

}
