package com.tzc.yk.MonitorService.controller;

import com.tzc.yk.MonitorService.pojo.User;
import com.tzc.yk.MonitorService.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
public class LoginController {


    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> login(@RequestBody User user){

        logger.info("account : " + user.getAccount());
        logger.info("password : " + user.getPassword());
        logger.info("servie received");


        Map<String,Object> datas = null;
        try {
            datas = loginService.login(user.getAccount(),user.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datas;
    }

    @RequestMapping("/test")
    @ResponseBody
    public List<User> test(){
        List<User> ls = null;
        try {
            ls = loginService.test();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }

}
