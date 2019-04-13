package com.tzc.yk.MonitorService.controller;

import com.tzc.yk.MonitorService.pojo.*;
import com.tzc.yk.MonitorService.service.AppConfigService;
import com.tzc.yk.MonitorService.service.AppService;
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
public class AppConfigController {


    Logger logger = LoggerFactory.getLogger(AppConfigController.class);

    @Autowired
    AppConfigService appConfigService;

    @RequestMapping(value = "/getAppConfigInfo",method = RequestMethod.GET)
    @ResponseBody
    public List<AppConfig> getAppConfigInfo(){
        List<AppConfig> appConfigList = null;
        try {
            appConfigList = appConfigService.getAppConfig();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return appConfigList;
    }

    @RequestMapping(value = "/getUserInfoByAccount",method = RequestMethod.GET)
    @ResponseBody
    public User getUserInfoByAccount(@RequestParam("account") String account){
        User user = null;
        try {
            user = appConfigService.getUserInfoByAccount(account);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @RequestMapping(value = "updateUserSofts",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> updateUserSofts(@RequestParam("account")String account,
                                              @RequestParam("softs")String softs){
        Map<String,Object> result = new HashMap<>();
        try {
            appConfigService.updateUserSofts(account, softs);
            result.put("status","ok");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("status","failure");
        }
        return result;
    }

    @RequestMapping(value = "addSoftsConfig",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addSoftsConfig(@RequestParam("name")String name,
                                             @RequestParam("processname")String processname){
        Map<String,Object> result = new HashMap<>();
        try {
            appConfigService.addSoftsConfig(name, processname);
            result.put("status","ok");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("status","failure");
        }
        return result;
    }

    @RequestMapping(value = "deleteSoftsConfigById",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> deleteSoftsConfigById(@RequestParam("id")int id){
        Map<String,Object> result = new HashMap<>();
        try {
            appConfigService.deleteSoftsConfigById(id);
            result.put("status","ok");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("status","failure");
        }
        return result;
    }

}
