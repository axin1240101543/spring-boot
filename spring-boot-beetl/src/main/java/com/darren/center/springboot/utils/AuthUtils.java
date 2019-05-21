package com.darren.center.springboot.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * 权限判断工具类
 */
@Slf4j
public class AuthUtils {

    public boolean isHasAuthority(String url){
        log.info("开始判断是否具有权限, url:{}", url);
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attrs.getRequest();
        if ("/admin".equals(url)){
            return true;
        }
        return false;
    }

    /**
     * 获取bean
     * @param clazz
     * @param request
     * @param <T>
     * @return
     */
    private <T> T getDao(Class<T> clazz,HttpServletRequest request){
        BeanFactory factory =  WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        return factory.getBean(clazz);
    }

}
