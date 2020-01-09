package com.login.dao;

import com.login.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;


public interface LoginDao extends JpaRepository<User,String>, JpaSpecificationExecutor<User> {
    @Query(nativeQuery = true,value = "select count(*) from tf_f_user where userNo = ? and  password = ?")
    public int qryUser(String userNo, String password);
}
