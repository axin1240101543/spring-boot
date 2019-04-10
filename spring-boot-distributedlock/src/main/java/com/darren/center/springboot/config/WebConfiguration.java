package com.darren.center.springboot.config;

import com.darren.center.springboot.context.ContextFilter;
import com.darren.center.springboot.context.ContextHelper;
import com.darren.center.springboot.filter.Filter1;
import com.darren.center.springboot.filter.Filter2;
import com.darren.center.springboot.filter.WebComponentFilter;
import com.darren.center.springboot.filter.WebComponentFilterChain;
import com.darren.center.springboot.id.CacheIDGenerator;
import com.darren.center.springboot.id.IDGenerator;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

@Configuration
public class WebConfiguration {

    @Bean
    public IDGenerator idGenerator(){
        return new CacheIDGenerator();
    }

    @Bean
    public ContextHelper contextHelper(){
        return new ContextHelper();
    }

    @Bean
    public WebComponentFilterChain webComponentFilterChain(){
        return new WebComponentFilterChain();
    }

    @Bean
    public ContextFilter contextFilter(){
        return new ContextFilter();
    }

    /*@Bean
    public Filter1 filter1(){
        return new Filter1();
    }

    @Bean
    public Filter2 filter2(){
        return new Filter2();
    }*/


    @Bean(name = "webComponentFilter")
    public WebComponentFilter webComponentFilter(){
        return new WebComponentFilter();
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new DelegatingFilterProxy());
        registrationBean.addUrlPatterns("/*");
        registrationBean.addInitParameter("targetBeanName", "webComponentFilter");
        registrationBean.setName("WebComponentFilter");
        registrationBean.setOrder(1);
        registrationBean.setEnabled(false);
        return registrationBean;
    }

}
