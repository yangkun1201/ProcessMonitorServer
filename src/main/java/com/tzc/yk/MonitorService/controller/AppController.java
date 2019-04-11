package com.tzc.yk.MonitorService.controller;

import com.tzc.yk.MonitorService.pojo.*;
import com.tzc.yk.MonitorService.service.AppConfigService;
import com.tzc.yk.MonitorService.service.AppService;
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
public class AppController {


    Logger logger = LoggerFactory.getLogger(AppController.class);

    @Autowired
    AppService appService;
    @Autowired
    AppConfigService appConfigService;

    @RequestMapping(value = "/uploadAppTimeInfo",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> uploadAppTimeInfo(@RequestBody AppTimeRequest appTimeRequest){
        Map<String,Object> datas = new HashMap<>();

        logger.info(appTimeRequest.getAccount());
        for(AppTimeItem appTimeItem:appTimeRequest.getAppStatus()){
            logger.info(appTimeItem.getAppName());
            logger.info(appTimeItem.getAppTime()+"");
        }
        try {
            appService.addAppTimeInfo(appTimeRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        datas.put("status","ok");
        return datas;
    }

    @RequestMapping(value = "/getAppTimeInfo",method = RequestMethod.GET)
    @ResponseBody
    public List<AppTimeResponse> getAppTimeInfo(@RequestParam("account") String account){
        List<AppTimeResponse> datas = null;
        List<AppConfig> appConfigList = null;
        Map<String,String> processNameToAppName = new HashMap<>();
        try {
            datas = appService.getAppTimeInfo(account,null);
            appConfigList = appConfigService.getAppConfig();

            for(AppConfig appConfig:appConfigList){
                processNameToAppName.put(appConfig.getProcessName(),appConfig.getName());
            }

            for(AppTimeResponse appTimeResponse : datas){
                if(processNameToAppName.containsKey(appTimeResponse.getSoft())){
                    appTimeResponse.setSoft(processNameToAppName.get(appTimeResponse.getSoft()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datas;
    }

}
