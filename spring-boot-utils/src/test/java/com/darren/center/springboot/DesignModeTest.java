package com.darren.center.springboot;

import com.darren.center.springboot.command.Action;
import com.darren.center.springboot.command.ActionMapper;
import com.darren.center.springboot.entity.WebParams;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration("src/main/resources")
public class DesignModeTest {

    @Resource(name = "Action-BaseActionMapper")
    private ActionMapper mapper;

    @Test
    public void test() throws Exception{
        WebParams webParams = WebParams.getWebparams();
        webParams.setType("Action2");
        Action action = mapper.findAction(webParams.getType());
        boolean flag = action.action(webParams);
        String result = null;
        if (flag){
            result = action.doAction(webParams);
        }
        log.info(result);
    }

}
