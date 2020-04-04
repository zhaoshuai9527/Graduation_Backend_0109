package com.login.control;

import com.common.Response.ResponseInfo;
import com.login.entity.HomeMessage;
import com.login.service.HomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(description = "首页接口", tags = { "HomeInterface" })
@CrossOrigin
public class HomeControl {
    @Autowired
    private HomeService homeService;
    @Autowired
    private final static Logger logger = LoggerFactory.getLogger(HomeControl.class);

    @RequestMapping(value = "/homeMessage",method = RequestMethod.POST)
    @ApiOperation(value = "首页", notes = "首页", tags = {"HomeInterface"}, produces = "application/json")
    public Object homeMessage(){
        List<HomeMessage> homeMessageList = homeService.homeMessage();
        return new ResponseInfo(homeMessageList);
    }

}
