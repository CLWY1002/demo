package com.gigold.pay.demo.facade;

import java.util.concurrent.TimeUnit;

import com.gigold.pay.framework.coordination.LockService;

public class DemoLockThread implements Runnable {

	private LockService lockService;

	public void run() {
		String name = "demo-lock";
		boolean success = this.lockService.tryLock(name, 1, TimeUnit.SECONDS);
		if(success) {
			System.out.println(Thread.currentThread().getName() + "获得" + name + "锁");
			try {
				Thread.sleep(3*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				this.lockService.unlock(name);
			}
		} else {
			System.out.println("获取锁失败");
		}
	}

	public LockService getLockService() {
		return lockService;
	}

	public void setLockService(LockService lockService) {
		this.lockService = lockService;
	}

}
