package com.login.service.ServiceImpl;

import com.login.dao.LoginDao;
import com.login.entity.UserInfo;
import com.login.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private final static Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Override
    public Map login(String userNo, String password) {

        UserInfo userInfo = loginDao.qryUser(userNo, password);
        if (userInfo.getIdentity() == null){
            Map errMap = new HashMap();
            errMap.put("code","0");
            errMap.put("desc","登录用户不存在!");
            return errMap;
        }
        String tokenStr = setCache(userInfo);


        Map res = new HashMap();
        res.put("code","1");
        res.put("tokenId",tokenStr);


        return res;

    }

    public String setCache(UserInfo userInfo)
    {
        String token = UUID.randomUUID().toString().replaceAll("-","");
        redisTemplate.opsForValue().set(token,userInfo,100,TimeUnit.MINUTES);
        logger.info(token);
//        redisTemplate.expire(token,3600, TimeUnit.SECONDS);
//        replaceAll("-","")
        return token;

    }
}
