/** 
* Copyright (c) Hedgeness Inc 2016-2018
* All rights reserved. 
*/

package com.hedgeness.app;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import com.hedgeness.app.config.filter.CorsFilter;

/**
 * Spring Boot Application Initializer for Hedgeness App
 * 
 * @author Pavan
 *
 */
@SpringBootApplication
@EnableAsync
@EnableMongoAuditing
@EnableCaching
@EnableScheduling
public class OAuth2ServerApplication {

	@Autowired
	@Qualifier("corsFilter")
	private CorsFilter filter; // inject CORSFilter bean```																								98

	public static void main(String[] args) {
		SpringApplication.run(OAuth2ServerApplication.class, args);
	}

	/**
	 * to register cors filter to Initializer
	 * 
	 * @author Pavan
	 * @return FilterRegistrationBean
	 */
	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean bean = new FilterRegistrationBean(filter);
		bean.addUrlPatterns("/*");
		return bean;
	}

	@Bean(name = "HedgnessAPPTask")
	public Executor asyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		int coresize= Runtime.getRuntime().availableProcessors() > 1? Runtime.getRuntime().availableProcessors()-1 : 1;
		executor.setCorePoolSize(coresize);
		executor.setMaxPoolSize(coresize);
		executor.setQueueCapacity(500);
		executor.setThreadNamePrefix("HedgnessAPPTask-");
		executor.initialize();
		return executor;
	}
	@Bean
	public RestTemplate restTemplate(){
		return  new RestTemplate();
	}

	@Bean
	public CacheManager cacheManager() {
	    SimpleCacheManager cacheManager = new SimpleCacheManager();
	    List<Cache> caches = new ArrayList<Cache>();
	    caches.add(new ConcurrentMapCache("aclcache"));
	    caches.add(new ConcurrentMapCache("userAclcache"));
	    caches.add(new ConcurrentMapCache("indexdata"));
	    cacheManager.setCaches(caches);
	    return cacheManager;
	}
}
