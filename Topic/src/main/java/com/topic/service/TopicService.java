package com.topic.service;

import com.github.pagehelper.PageInfo;
import com.topic.entity.QueryInfo;
import com.topic.entity.SelectTopic;
import com.topic.entity.Topic;


public interface TopicService {
    public PageInfo<Topic> getTopicList(QueryInfo queryInfo);

    public int publishTopic(Topic topic);

    public int editTopic(Topic topic);

    public int deleteTopic(String titleNo);

    public PageInfo<Topic> getTopicListByTeacherName(QueryInfo queryInfo);




    public int selectTopic(SelectTopic selectTopic);
}
