package com.login.service.ServiceImpl;

import com.login.dao.LoginDao;
import com.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    @Override
    public int login(String userNo, String password) {

        int loginCode = loginDao.qryUser(userNo, password);
        return loginCode;

    }
}
