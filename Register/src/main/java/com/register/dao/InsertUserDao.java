package com.register.dao;

import com.register.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface InsertUserDao {
    public int qryUser(String userNo);

    public int insertUser(User user);
}
