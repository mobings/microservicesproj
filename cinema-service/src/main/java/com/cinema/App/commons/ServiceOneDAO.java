package com.cinema.App.commons;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.cinema.App.model.ServiceOneEntity;
import com.cinema.App.repository.ServiceOneRepository;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;


//@Component
//@DefaultProperties(threadPoolKey="serviceone-id",threadPoolProperties= {
//		@HystrixProperty(name="coreSize", value="2"),
//		@HystrixProperty(name="maxQueueSize",value="-1")},
//		commandProperties= {@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="50"),
//					@HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value="3")})
//public class ServiceOneDAO {
//
//@Autowired
//ServiceOneRepository serviceOneRepository;
//public ServiceOneEntity getById(int serviceId, int delayMs) {
//	System.err.println("ServiceOneEntity.getByID called");
//	SleepUtils.sleep(delayMs);
//	return serviceOneRepository.findById(serviceId).get();
//}
//
//@HystrixCommand(threadPoolKey="serviceone-hang", threadPoolProperties= {
//		@HystrixProperty(name="coreSize", value="2"),
//		@HystrixProperty(name="maxQueueSize",value="-1")},
//	commandProperties= {
//		@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="1300000")})	
//public String callHangingService() {
//	System.err.println("ServiceOneEntity.callHandingService called");
//	SleepUtils.sleep(120000);
//	return "handing method finally returned";
//}
//
//public ServiceOneEntity getIdFallbackMethod(int serviceId, int delayMs) {
//	return new ServiceOneEntity(serviceId, "Fallback method called : "+serviceId);
//}
//
//}

@Component
//@DefaultProperties(commandProperties= {
//	@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="500")})
public class ServiceOneDAO {
	
	@Autowired
	ServiceOneRepository serviceOneRepository;
	@HystrixCommand(
			fallbackMethod="getIdFallbackMethod",
			commandProperties= {
			@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="500"),
			@HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value="3")
			})
	//@HystrixCommand(commandKey="getserviceid")
	public ServiceOneEntity getById(int serviceId, int delayMs) {
		System.err.println("ServiceOneEntity.getByID called");
		SleepUtils.sleep(delayMs);
		return serviceOneRepository.findById(serviceId).get();
	}
	
	public ServiceOneEntity getIdFallbackMethod(int serviceId, int delayMs) {
		return new ServiceOneEntity(serviceId, "Fallback method called : "+serviceId);
	}

}
