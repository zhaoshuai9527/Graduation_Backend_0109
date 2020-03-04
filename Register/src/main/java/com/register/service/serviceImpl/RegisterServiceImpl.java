package com.register.service.serviceImpl;

import com.register.dao.InsertUserDao;
import com.register.dao.RegisterDao;
import com.register.entity.Student;
import com.register.entity.Teacher;
import com.register.entity.User;
import com.register.service.RegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegisterDao registerDao;
    @Autowired
    private InsertUserDao insertUserDao;
    @Autowired
    private RedisTemplate redisTemplate ;
    @Autowired
    private RabbitTemplate rabbitTemplate ;
    @Autowired
    private final static Logger logger = LoggerFactory.getLogger(RegisterServiceImpl.class);


    @Override
    public int registerStudent(Student student) {
        int qryStudentNum = registerDao.qryStudent(student.getStuNo());
        logger.info("查询该学号是否存在："+qryStudentNum);
        if (qryStudentNum == 0){
        //将输入的password进行MD5加密
        String md5Password = DigestUtils.md5DigestAsHex(student.getStuPassword().getBytes());
        student.setStuPassword(md5Password);
        int i = registerDao.registerStudent(student);
        logger.info("Dao层返回值："+i);
        User stuUser = new User();
        if (i== 1){//表示注册成功
            stuUser.setUserNo(student.getStuNo());
            stuUser.setUserName(student.getStuName());
            stuUser.setPassword(student.getStuPassword());
            stuUser.setIdentity("0");// 0 代表学生
            int insertCode = insertUserDao.insertUser(stuUser);
            logger.info("insertCode:"+insertCode);
            if (insertCode != 1){
                insertCode = 3;
                return insertCode;// 注册成功 ！(并将信息在user表中备份）
            }
        }
        return i;
    }else{
            return 2;//该学号已经被注册
        }
    }

    @Override
    public int registerTeacher(Teacher teacher) {
        int qryTeacherNum = registerDao.qryTeacher(teacher.getTeachNo());
        logger.info("查询该教师编码是否存在："+qryTeacherNum);
        if (qryTeacherNum == 0){
            //将输入的password进行MD5加密
            String md5Password = DigestUtils.md5DigestAsHex(teacher.getTeachPassword().getBytes());
            teacher.setTeachPassword(md5Password);
            int i = registerDao.registerTeacher(teacher);
            logger.info("Dao层返回值："+i);
            return i;
        }else{
            return 2;//该学号已经被注册
        }
    }

    //验证码
    public void sendSms(String phone){
        //6位验证码
        String smsCode = ((int)(Math.random()*900000) + 100000) + "" ;
        //redis  : sms_1888888888  value:144545
        redisTemplate.opsForValue().set("smscode_"+phone  , smsCode  ,1 , TimeUnit.DAYS);
        System.out.println(phone+"-"+smsCode);
        //发送  -> MQ
        Map<String,String> map = new HashMap<>();
        map.put("phone",phone) ;
        map.put("code",smsCode) ;
        logger.info(map.get("code")+"++"+map.get("phone"));
        rabbitTemplate.convertAndSend("sms",  map);
    }
}
