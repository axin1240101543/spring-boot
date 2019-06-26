package com.darren.center.springboot.designmode.strategypattern;

import com.darren.center.springboot.command.AbstractAction;
import com.darren.center.springboot.command.ActionMapper;
import com.darren.center.springboot.entity.WebParams;
import com.darren.center.springboot.enums.ActionEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component("Action1")
public class Action1 extends AbstractAction {

    public Action1(@Value("${service.code.Action1:Action1}")String serviceCode,
                   @Qualifier("Action-BaseActionMapper")ActionMapper actionMapper) {
        super(serviceCode, actionMapper);
    }

    @Override
    public boolean action(WebParams params) throws Exception {
        return params.getType().equals(ActionEnum.SERVICE_1.getService());
    }

    @Override
    public String doAction(WebParams params) throws Exception {
        return "进入Action1的处理逻辑";
    }
}
