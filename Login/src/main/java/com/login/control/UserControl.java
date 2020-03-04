package com.login.control;

import com.common.Response.ResponseInfo;
import com.github.pagehelper.PageInfo;
import com.login.entity.*;
import com.login.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Api(description = "用户列表接口", tags = { "UserInterface" })
@CrossOrigin
public class UserControl {
    @Autowired
    private UserService userService;
    @Autowired
    private final static Logger logger = LoggerFactory.getLogger(UserControl.class);

    @RequestMapping(value = "/getUserList",method = RequestMethod.POST)
    @ApiOperation(value = "用户列表查询", notes = "用户列表", tags = {"UserInterface"}, produces = "application/json")
    public Object getUserList(@RequestBody QueryUserList queryUserList){

        logger.info(queryUserList.getQuery() +"==="+ queryUserList.getPageNum() +"==="+ queryUserList.getPageSize());
        PageInfo<User> userList = userService.getUserList(queryUserList);
        logger.info(userList.getTotal()+"$$$"+userList.getPageNum()+"$$$"+userList.getPageSize() +"$$$" + userList);
        return new ResponseInfo(userList);
    }


    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    @ApiOperation(value = "添加用户", notes = "添加用户", tags = {"UserInterface"}, produces = "application/json")
    public Object addUser(@RequestBody AddUser addUser){

        logger.info(addUser.getUserNo() +"==="+ addUser.getUserName() +"==="+ addUser.getIdentity());
        int result = userService.addUser(addUser);
        if (result == 1){
            return new ResponseInfo("2001","成功");
        }else{
            return new ResponseInfo("3001","失败");
        }

    }

    @RequestMapping(value = "/editUser",method = RequestMethod.POST)
    @ApiOperation(value = "修改用户", notes = "修改用户", tags = {"UserInterface"}, produces = "application/json")
    public Object editUser(@RequestBody EditUser editUser){

        int result = userService.editUser(editUser);
        if (result == 1){
            return new ResponseInfo("2001","成功");
        }else{
            return new ResponseInfo("3001","失败");
        }
    }

    @RequestMapping(value = "/deleteUser",method = RequestMethod.POST)
    @ApiOperation(value = "删除用户", notes = "删除用户", tags = {"UserInterface"}, produces = "application/json")
    public Object deleteUser(@RequestBody DeleteUser deleteUser){
        logger.info("userNo"+deleteUser.getUserNo());
        int result = userService.deleteUser(deleteUser.getUserNo());
        if (result == 1){
            return new ResponseInfo("2001","成功");
        }else{
            return new ResponseInfo("3001","失败");
        }
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    @ApiOperation(value = "分配用户角色", notes = "分配用户角色", tags = {"UserInterface"}, produces = "application/json")
    public Object updateUser(@RequestBody UpdateIdentityOfUser updateIdentityOfUser){
        int result = userService.updateUser(updateIdentityOfUser);
        if (result == 1){
            return new ResponseInfo("2001","成功");
        }else{
            return new ResponseInfo("3001","失败");
        }
    }
}
