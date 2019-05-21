package com.darren.center.springboot.config;


import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Properties;

/**
 * 用来映射yml文件的自定义配置属性
 * 需要添加依赖
 * <dependency><groupId>org.springframework.boot</groupId><artifactId>spring-boot-configuration-processor</artifactId><optional>true</optional></dependency>
 *
 * beetl的自定义属性
 */
@Data
@ConfigurationProperties(prefix = BeetlProperties.BEETLCONF_PREFIX)
public class BeetlProperties {

    /**
     * 前缀
     */
    public static final String BEETLCONF_PREFIX = "beetl";

    /**
     * 开始定界符声明（默认是<%  %>）
     */
    private String delimiterStatementStart;

    /**
     * 结束定界符声明（默认是<%  %>）
     */
    private String delimiterStatementEnd;

    /**
     * 自定义的html标签所在的目录
     */
    private String resourceTagRoot;

    /**
     * 自定义的html标签所在的文件名后缀
     */
    private String resourceTagSuffix;

    /**
     * 是否检测文件变化,开发用true合适，但线上要改为false
     */
    private String resourceAutoCheck;

    @Value("${spring.mvc.view.prefix}")
    private String prefix;

    public Properties getProperties(){
        Properties properties = new Properties();
        if (StringUtils.isNotEmpty(delimiterStatementStart)){
            if (delimiterStatementStart.startsWith("\\")){
                delimiterStatementStart = delimiterStatementStart.substring(1);
            }
            properties.setProperty("DELIMITER_STATEMENT_START", delimiterStatementStart);
        }
        if (StringUtils.isNotEmpty(delimiterStatementEnd)){
            properties.setProperty("DELIMITER_STATEMENT_END", delimiterStatementEnd);
        }else {
            properties.setProperty("DELIMITER_STATEMENT_END", "null");
        }
        if (StringUtils.isNotEmpty(resourceTagRoot)){
            properties.setProperty("RESOURCE.tagRoot", resourceTagRoot);
        }
        if (StringUtils.isNotEmpty(resourceTagRoot)){
            properties.setProperty("RESOURCE.tagRoot", resourceTagRoot);
        }
        if (StringUtils.isNotEmpty(resourceTagSuffix)){
            properties.setProperty("RESOURCE.tagSuffix", resourceTagSuffix);
        }
        if (StringUtils.isNotEmpty(resourceAutoCheck)){
            properties.setProperty("RESOURCE.autoCheck", resourceAutoCheck);
        }
        return properties;
    }
}
