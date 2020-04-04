package com.login.control;

import com.common.Result.Result;
import com.common.Utils.Token;
import com.login.entity.LoginUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.login.service.LoginService;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@Api(description = "登录接口", tags = { "LoginInterface" })
@CrossOrigin("*")
public class LoginControl {

    @Autowired
    private LoginService loginService;
    @Autowired
    private final static Logger logger = LoggerFactory.getLogger(LoginControl.class);

    @RequestMapping(value = "/userLogin",method = RequestMethod.POST)
    @ApiOperation(value = "登录", notes = "用户登录", tags = {"LoginInterface"}, produces = "application/json")
    public Map<String, Object> login(@RequestBody LoginUser user){
        String username = user.getAccount();
        String password = user.getPassword();
        Map resMap = loginService.login(username, password);
//        if (loginCode == 1){
//            String token = Token.sign(username,password);
//            logger.info("token:"+token);
//            if (token != null){
//                map.put("code", "10000");
//                map.put("message","认证成功");
//                map.put("token", token);
//                return map;
//            }
//            map.put("code", "00000");
//            map.put("message","认证失败");
//            return map;
//        }
//        map.put("xxx",new Result(false,2002,"登陆失败！"));
        return resMap;
    }


}
