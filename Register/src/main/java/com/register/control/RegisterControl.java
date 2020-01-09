package com.register.control;

import com.SMS.SmsUtil;
import com.aliyuncs.exceptions.ClientException;
import com.common.Result.Result;
import com.register.entity.Student;
import com.register.entity.Teacher;
import com.register.service.RegisterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(description = "注册接口", tags = { "RegisterInterface" })
public class RegisterControl {

    @Autowired
    private RegisterService registerService;

    @Autowired(required = false)
    private SmsUtil smsUtil;

    @RequestMapping(value = "/registerStudent",method = RequestMethod.POST)
    @ApiOperation(value = "学生注册", notes = "学生注册", tags = {"RegisterInterface"}, produces = "application/json")
    public Object registerStudent(@RequestBody Student student){
        int i = registerService.registerStudent(student);
        if (i == 1){
            return new Result(true,2001,"注册成功");
        }else if ( i == 2){
            return new Result(false,2002,"该学号已经被注册");
        }else if ( i == 3){
            return new Result(false,2002,"注册成功,但信息没在User表中备份");
        }
        return new Result(false,2002,"注册失败");
    }

    @RequestMapping(value = "/registerTeacher",method = RequestMethod.POST)
    @ApiOperation(value = "教师注册", notes = "教师注册", tags = {"RegisterInterface"}, produces = "application/json")
    public Object registerTeacher(@RequestBody Teacher teacher){
        int i = registerService.registerTeacher(teacher);
        if (i == 1){
            return new Result(true,2001,"注册成功");
        }else if ( i == 2){
            return new Result(false,2002,"该教师号已经被注册");
        }
        return new Result(false,2002,"注册失败");
    }

    @RequestMapping(value = "/getSMSCode",method = RequestMethod.POST)
    public void getSMSCode(String phone,String sign_name,String template_code){
        try {
            smsUtil.sendSms(phone,sign_name,template_code);
        } catch (ClientException e) {
            e.printStackTrace();
        }

    }




}
