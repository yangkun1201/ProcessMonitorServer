package com.tzc.yk.MonitorService.controller;

import com.tzc.yk.MonitorService.pojo.User;
import com.tzc.yk.MonitorService.service.LoginService;
import com.tzc.yk.MonitorService.util.RandomUtil;
import com.tzc.yk.MonitorService.util.SmsUtil;
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
        logger.info("service received");

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

    @RequestMapping(value = "/registeredAccount",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> registeredAccount(@RequestBody User user){
        Map<String,Object> result = new HashMap<>();
        try {
            loginService.registeredAccount(user);
            result.put("status","ok");
        } catch (Exception e) {
            result.put("status","failure");
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "checkAccountExist",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> checkAccountExist(@RequestParam("account")String account){
        Map<String,Object> result = new HashMap<>();
        try {
            if(loginService.checkAccountExist(account)){
                result.put("isExist",1);
            }else{
                result.put("isExist",0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "sendSms",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> sendSms(@RequestParam("phone")String phone){
        Map<String,Object> result = new HashMap<>();
        String verificationCode = RandomUtil.getInstance().getVerificationCode();
        String sendResult = SmsUtil.getInstances().sendSms(phone,verificationCode);
        result.put("status",sendResult);
        result.put("verificationCode",verificationCode);
        return result;
    }

}
