package com.darren.center.springboot.config;

import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(BeetlProperties.class)
public class MyBeetlConfig {

    @Autowired
    private BeetlProperties beetlProperties;

    /**
     * Beetl的配置
     * @return
     */
    @Bean(initMethod = "init")
    public BeetlConfiguration beetlConfiguration(){
        BeetlConfiguration beetlConfiguration = new BeetlConfiguration();
        beetlConfiguration.setResourceLoader(new ClasspathResourceLoader(MyBeetlConfig.class.getClassLoader(), beetlProperties.getPrefix()));
        beetlConfiguration.setConfigProperties(beetlProperties.getProperties());
        return beetlConfiguration;
    }

    /**
     * Beetl视图解析器
     * @return
     */
    @Bean
    public BeetlSpringViewResolver beetlSpringViewResolver(){
        BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
        beetlSpringViewResolver.setConfig(beetlConfiguration());
        beetlSpringViewResolver.setContentType("text/html;charset=UTF-8");
        beetlSpringViewResolver.setOrder(0);
        return beetlSpringViewResolver;
    }

}
