package com.topic.dao;

import com.topic.entity.DeleteTopic;
import com.topic.entity.QueryInfo;
import com.topic.entity.Selectwish;
import com.topic.entity.Topic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface TopicDao {
    //查所有题目
    public List<Topic> getTopicList(String query);
    public List<Topic> getTopicListOfAll();
    //发布题目
    public int publishTopic(Topic topic);
    //修改题目
    public int editTopic(Topic topic);
    //删除题目
    public int deleteTopic(String titleNo);

    public int selectWishOneTopic(Selectwish selectwish);
}
