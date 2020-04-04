package com.topic.control;

import com.common.Response.ResponseInfo;
import com.common.Result.Result;
import com.github.pagehelper.PageInfo;
import com.login.entity.UserInfo;
import com.topic.entity.*;
import com.topic.service.TopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@RestController
@CrossOrigin("*")
public class TopicControl {

    @Autowired
    private TopicService topicService;
    @Autowired
    private RedisTemplate redisTemplate;
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
    public Object publishTopic(@RequestBody Topic topic, HttpServletRequest httpServletRequest){
        String tokenId = httpServletRequest.getHeader("token");
        UserInfo userInfo = (UserInfo) redisTemplate.opsForValue().get(tokenId);
        if (userInfo.getIdentity().equals("0")){
            return new ResponseInfo("4001","您没有该权限！");
        }
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


    //学生根据教师名字搜索题目
    //查询题目
    @PostMapping(value = "/getTopicListByTeacherName")
    public Object getTopicListByTeacherName(@RequestBody QueryInfo queryInfo){

        PageInfo<Topic> topicList = topicService.getTopicListByTeacherName(queryInfo);
        logger.info(topicList + "");
        return new ResponseInfo(topicList);
    }





    //学生选题
    @PostMapping(value = "/selectTopic")
    public Object selectTopic(@RequestBody CheckTopicParam checkTopicParam,HttpServletRequest httpServletRequest){
        String tokenId = httpServletRequest.getHeader("token");
        logger.info("tokenId: "+tokenId);
        UserInfo userInfo = (UserInfo) redisTemplate.opsForValue().get(tokenId);
        if (!(userInfo.getIdentity().equals("0"))){
            return new ResponseInfo("您不是学生，不可以进行选题操作");
        }
        SelectTopic selectTopic = new SelectTopic();
        //将学生登录者的账号和姓名封装到selectTopic中
        selectTopic.setStuNo(userInfo.getUserNo());
        selectTopic.setStuName(userInfo.getUserName());
        selectTopic.setTeacherNo(checkTopicParam.getTeacherNo());
        selectTopic.setTitleNo(checkTopicParam.getTitleNo());
        selectTopic.setTitleName(checkTopicParam.getTitleName());
        selectTopic.setCount(checkTopicParam.getCount());
        int resultCode = topicService.selectTopic(selectTopic);
        if (resultCode == 1){
            return new Result(true,1001,"预选题成功！");
        }else if(resultCode == 3){
            return new Result(false,3001,"您已预选题！");
        }else if(resultCode == 4){
            return new Result(false,4001,"只允许预选最多三个题目！");
        }
        return new Result(false,2001,"预选题失败！");
    }
}
