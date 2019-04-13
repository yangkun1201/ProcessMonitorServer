package com.tzc.yk.MonitorService.service;

import com.tzc.yk.MonitorService.pojo.AppConfig;
import com.tzc.yk.MonitorService.pojo.AppTimeRequest;
import com.tzc.yk.MonitorService.pojo.AppTimeResponse;
import com.tzc.yk.MonitorService.pojo.User;

import java.util.List;


public interface AppConfigService {

    List<AppConfig> getAppConfig() throws Exception;

    User getUserInfoByAccount(String account) throws Exception;

    void updateUserSofts(String account,String sotfs) throws Exception;

    void addSoftsConfig(String name,String processname) throws Exception;

    void deleteSoftsConfigById(int id) throws Exception;

}
