package com.gigold.pay.demo.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.gigold.pay.framework.base.aspect.AopContext;
import com.gigold.pay.framework.cache.CheckCache;
import com.gigold.pay.framework.cache.EvictCache;
import com.gigold.pay.framework.core.Domain;

@Component
public class DemoCacheService extends Domain {

	private static final long serialVersionUID = -8627707989463306954L;

	@CheckCache(key = "${key}", namespace = "demo", eternal = true, cacheNull = true)
	public List<String> test(String key) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 100; i++) {
			list.add(i + "");
		}
		return list;
	}

	@EvictCache(key = "${key}", namespace = "demo")
	public void delete(String key) {

	}

	@EvictCache(key = "${key = [];foreach (sample : " + AopContext.CONTEXT_KEY_RETVAL
			+ ") { key.add(sample.name); } return key;}", namespace = "sample")
	public List<SampleEntity> delete(String ... id) {
		List<SampleEntity> list = new ArrayList<SampleEntity>();
		SampleEntity sample = new SampleEntity();
		sample.setId("1");
		sample.setName("sample");
		list.add(sample);
		
		sample = new SampleEntity();
		sample.setId("2");
		sample.setName("sample2");
		list.add(sample);
		return list;
	}
	
	@EvictCache(key = "${sample.id}", namespace = "sample", renew = "${sample}")
	public void save(SampleEntity sample) {
		
	}
	
	@EvictCache(key = "${sample.id}", namespace = "sample", renew = "${sample}")
	public void update(SampleEntity sample) {
		
	}

	class SampleEntity implements Serializable {

		private static final long serialVersionUID = -1635840052294743097L;

		private String id;
		private String name;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}
}
