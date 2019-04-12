package com.darren.center.springboot;

import com.darren.center.springboot.aop.LockKeyGenerator;
import com.darren.center.springboot.aop.LockKeyGeneratorImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DarrenSpringBootCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(DarrenSpringBootCenterApplication.class, args);
	}

	@Bean
	public LockKeyGenerator cacheKeyGenerator(){
		return new LockKeyGeneratorImpl();
	}

}

