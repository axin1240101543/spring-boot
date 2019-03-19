package com.darren.center.springboot.dao.read;

import com.darren.center.springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserReaderDao {

    User selectByPrimaryKey(Long id);

    List<User> selectUserList();

}