package com.topic.control;

import com.common.Response.ResponseInfo;
import com.common.Result.Result;
import com.github.pagehelper.PageInfo;
import com.topic.entity.DeleteTopic;
import com.topic.entity.QueryInfo;
import com.topic.entity.Selectwish;
import com.topic.entity.Topic;
import com.topic.service.TopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class TopicControl {

    @Autowired
    private TopicService topicService;
    @Autowired
    private final static Logger logger = LoggerFactory.getLogger(TopicControl.class);

    //查询题目
    @PostMapping(value = "/getTopicList")
    public Object getTopicList(@RequestBody QueryInfo queryInfo){

        PageInfo<Topic> topicList = topicService.getTopicList(queryInfo);
        logger.info(topicList + "");
        return new ResponseInfo(topicList);
    }

    //教师发布题目
    @PostMapping(value = "/publishTopic")
    public Object publishTopic(@RequestBody Topic topic){
        logger.info(topic.getTitleNo());
        int publishTopicCode = topicService.publishTopic(topic);
        logger.info(publishTopicCode + "");
        if (publishTopicCode == 1){
            return new ResponseInfo("2001","发表题目成功");
        }else {
            return new ResponseInfo("3001","发表题目失败");
        }
    }

    //教师修改题目
    @PostMapping(value = "/editTopic")
    public Object editTopic(@RequestBody Topic topic){
        int editTopicCode = topicService.editTopic(topic);
        if (editTopicCode == 1){
            return new ResponseInfo("2001","修改题目成功");
        }else {
            return new ResponseInfo("3001","修改题目失败");
        }
    }


    //教师删除题目
    @PostMapping(value = "/deleteTopic")
    public Object deleteTopic(@RequestBody DeleteTopic deleteTopic){
        int deleteTopicCode = topicService.deleteTopic(deleteTopic.getTitleNo());
        if (deleteTopicCode == 1){
            return new ResponseInfo("2001","删除题目成功");
        }else {
            return new ResponseInfo("3001","删除题目失败");
        }
    }
    //学生预选题
    @PostMapping(value = "/selectWishOneTopic")
    public Object prepareSelectTopic(@RequestBody Selectwish selectwish){
        int selectWishOneTopicCode = topicService.selectWishOneTopic(selectwish);
        logger.info(selectWishOneTopicCode + "");
        if (selectWishOneTopicCode == 1){
            return new Result(true,1001,"预选题目成功");
        }
        return new Result(false,2001,"预选题目失败");
    }
}
