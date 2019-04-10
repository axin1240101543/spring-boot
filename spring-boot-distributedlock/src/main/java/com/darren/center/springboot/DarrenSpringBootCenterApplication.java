package com.darren.center.springboot;

import com.darren.center.springboot.aop.LockKeyGenerator;
import com.darren.center.springboot.aop.LockKeyGeneratorImpl;
import com.darren.center.springboot.context.ContextFilter;
import com.darren.center.springboot.context.ContextHelper;
import com.darren.center.springboot.filter.Filter;
import com.darren.center.springboot.filter.WebComponentFilterChain;
import com.darren.center.springboot.id.IDGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

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

