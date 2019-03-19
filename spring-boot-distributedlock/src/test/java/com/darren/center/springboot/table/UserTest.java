package com.darren.center.springboot.table;

import com.darren.center.springboot.dao.read.UserReaderDao;
import com.darren.center.springboot.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    private ApplicationContext context;

    @Test
    public void get(){
        UserReaderDao userReaderDao = context.getBean(UserReaderDao.class);
        User user = userReaderDao.selectByPrimaryKey((long)4);
        System.out.println(user);
    }

}
