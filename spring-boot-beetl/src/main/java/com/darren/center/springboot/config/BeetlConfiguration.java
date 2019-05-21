package com.darren.center.springboot.config;

import com.darren.center.springboot.utils.AuthUtils;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;

/**
 * beetl拓展配置, 绑定一些工具类, 方便在模板中直接调用.
 */
public class BeetlConfiguration extends BeetlGroupUtilConfiguration{

    @Override
    protected void initOther() {
        groupTemplate.registerFunctionPackage("auth", new AuthUtils());
    }
}
