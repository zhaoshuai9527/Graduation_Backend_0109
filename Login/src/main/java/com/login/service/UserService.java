package com.login.service;

import com.github.pagehelper.PageInfo;
import com.login.entity.*;


public interface UserService {
    public PageInfo<User> getUserList(QueryUserList queryUserList);


    public int addUser(AddUser addUser);

    public int editUser(EditUser editUser);

    public int deleteUser(String userNo);

    public int updateUser(UpdateIdentityOfUser updateIdentityOfUser);
}
