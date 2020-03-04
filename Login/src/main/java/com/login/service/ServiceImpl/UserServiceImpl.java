package com.login.service.ServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.login.dao.UserDao;
import com.login.entity.*;
import com.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public PageInfo<User> getUserList(QueryUserList queryUserList) {
        PageHelper.startPage(queryUserList.getPageNum(), queryUserList.getPageSize());
        if (queryUserList.getQuery() != null && !(("").equals(queryUserList.getQuery()))){
            String query = queryUserList.getQuery();
            //查询语句必须写在pageHelper.startPage()方法之后
            List<User> userList = userDao.getUserList(query);
            //pageInfo中封装分页信息
            PageInfo<User> pageInfo = new PageInfo<>(userList);
            return pageInfo;
        }else{
            //查询语句必须写在pageHelper.startPage()方法之后
            List<User> userList = userDao.getUserListOfAll();
            //pageInfo中封装分页信息
            PageInfo<User> pageInfo = new PageInfo<>(userList);
            return pageInfo;
        }
    }


    @Override
    public int addUser(AddUser addUser) {
        // 校验userNo是否存在
        String userNo = addUser.getUserNo();
        String identity = addUser.getIdentity();
        if (identity.equals("0")){// 学生
            int i = userDao.ifExistOfStudent(userNo);
            if (i == 0){
                int resultOfStudent = userDao.addStudent(addUser);
                int resultOfUser = userDao.addUser(addUser);
                if (resultOfStudent == 1 && resultOfUser == 1){
                    return resultOfStudent;
                }
            }
            return 886;
        }else if (identity.equals("1")){// 老师
            int i = userDao.ifExistOfTeacher(userNo);
            if (i ==0){
                int resultOfTeacher = userDao.addTeacher(addUser);
                int resultOfUser = userDao.addUser(addUser);
                if (resultOfTeacher == 1 && resultOfUser == 1){
                    return 1;
                }
            }
            return 886;
        }else{// 管理员
            int i = userDao.ifExistOfAdmin(userNo);
            if (i == 0){
                int resultOfAdmin = userDao.addAdmin(addUser);
                int resultOfUser = userDao.addUser(addUser);
                if (resultOfAdmin == 1 && resultOfUser == 1){
                    return 1;
                }
            }
            return 886;
        }
    }


    @Override
    public int editUser(EditUser editUser) {

        int resultOfEditUser = userDao.editUser(editUser);
        return resultOfEditUser;
    }

    @Override
    public int deleteUser(String userNo) {
        int resultOfDeleteUser = userDao.deleteUser(userNo);
        return resultOfDeleteUser;
    }

    @Override
    public int updateUser(UpdateIdentityOfUser updateIdentityOfUser) {
        int resultOfUpdateUser = userDao.updateUser(updateIdentityOfUser);
        return resultOfUpdateUser;
    }
}
