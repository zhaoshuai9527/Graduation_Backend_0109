package com.topic.service;

import com.github.pagehelper.PageInfo;
import com.topic.entity.DeleteTopic;
import com.topic.entity.QueryInfo;
import com.topic.entity.Selectwish;
import com.topic.entity.Topic;
import org.springframework.stereotype.Service;


public interface TopicService {
    public PageInfo<Topic> getTopicList(QueryInfo queryInfo);

    public int publishTopic(Topic topic);

    public int editTopic(Topic topic);

    public int deleteTopic(String titleNo);



    public int selectWishOneTopic(Selectwish selectwish);
}
