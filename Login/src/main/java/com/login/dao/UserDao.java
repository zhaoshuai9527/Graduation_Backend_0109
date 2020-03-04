package com.login.dao;

import com.login.entity.AddUser;
import com.login.entity.EditUser;
import com.login.entity.UpdateIdentityOfUser;
import com.login.entity.User;
import org.mapstruct.Mapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserDao {
    public List<User> getUserListOfStudent(@Param("query") String query);
    public List<User> getUserListOfTeacher(@Param("query") String query);
    public List<User> getUserListOfAdmin(@Param("query") String query);
    public List<User> getUserList(@Param("query") String query);
    public List<User> getUserListOfAll();


    public int ifExistOfStudent(String userNo);
    public int ifExistOfTeacher(String userNo);
    public int ifExistOfAdmin(String userNo);

    public int addStudent(AddUser addUser);
    public int addTeacher(AddUser addUser);
    public int addAdmin(AddUser addUser);
    public int addUser(AddUser addUser);


    public int editUser(EditUser editUser);


    public int deleteUser(String userNo);

    public int updateUser(UpdateIdentityOfUser updateIdentityOfUser);
}
