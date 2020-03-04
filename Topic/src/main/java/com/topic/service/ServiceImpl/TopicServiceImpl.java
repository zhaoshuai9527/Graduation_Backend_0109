package com.topic.service.ServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topic.dao.TopicDao;
import com.topic.entity.DeleteTopic;
import com.topic.entity.QueryInfo;
import com.topic.entity.Selectwish;
import com.topic.entity.Topic;
import com.topic.service.TopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicDao topicDao;
    @Autowired
    private final static Logger logger = LoggerFactory.getLogger(TopicServiceImpl.class);

    @Override
    public PageInfo<Topic> getTopicList(QueryInfo queryInfo) {
        PageHelper.startPage(queryInfo.getPageNum(), queryInfo.getPageSize());
        if (queryInfo.getQuery() != null && !(("").equals(queryInfo.getQuery()))){
            String query = queryInfo.getQuery();
            //查询语句必须写在pageHelper.startPage()方法之后
            List<Topic> userList = topicDao.getTopicList(query);
            //pageInfo中封装分页信息
            PageInfo<Topic> pageInfo = new PageInfo<>(userList);
            return pageInfo;
        }else{
            //查询语句必须写在pageHelper.startPage()方法之后
            List<Topic> userList = topicDao.getTopicListOfAll();
            //pageInfo中封装分页信息
            PageInfo<Topic> pageInfo = new PageInfo<>(userList);
            return pageInfo;
        }
    }

    @Override
    public int publishTopic(Topic topic) {
        logger.info(topic.getTitleNo()+"=="+topic.getTitleName());
        int publishTopicCode = topicDao.publishTopic(topic);
        return publishTopicCode;
    }

    @Override
    public int editTopic(Topic topic) {
        int editTopicCode = topicDao.editTopic(topic);
        return editTopicCode;
    }

    @Override
    public int deleteTopic(String titleNo) {
        int deleteTopicCode = topicDao.deleteTopic(titleNo);
        return deleteTopicCode;
    }


    @Override
    public int selectWishOneTopic(Selectwish selectwish) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        selectwish.getSelectTime(df.format(new Date()) + "");// new Date()为获取当前系统时间
        logger.info(selectwish.getSelectTime(df.format(new Date()) + ""));

        int selectWishOneTopicCode = topicDao.selectWishOneTopic(selectwish);
        return selectWishOneTopicCode;
    }
}
