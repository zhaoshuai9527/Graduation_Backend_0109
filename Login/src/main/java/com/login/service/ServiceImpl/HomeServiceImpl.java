package com.login.service.ServiceImpl;

import com.login.dao.HomeDao;
import com.login.entity.HomeMessage;
import com.login.service.HomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeDao homeDao;

    @Autowired
    private final static Logger logger = LoggerFactory.getLogger(HomeServiceImpl.class);

    @Override
    public List<HomeMessage> homeMessage() {
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//        long currentTimeMillis = System.currentTimeMillis();
//        HomeMessage homeMessage = new HomeMessage();
//        homeMessage.getTime(df.format(new Date()) + "");// new Date()为获取当前系统时间
//        logger.info(homeMessage.getTime(df.format(new Date()) + ""));
        List<HomeMessage> homeMessage = homeDao.getHomeMessage();
        return homeMessage;
    }
}
