package com.login.dao;

import com.login.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface LoginDao {

    public int qryUser(String userNo, String password);
}
