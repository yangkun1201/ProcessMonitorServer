package com.tzc.yk.MonitorService.serviceImpl;

import com.tzc.yk.MonitorService.mapper.AppConfigMapper;
import com.tzc.yk.MonitorService.mapper.LoginMapper;
import com.tzc.yk.MonitorService.pojo.AppConfig;
import com.tzc.yk.MonitorService.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppConfigService implements com.tzc.yk.MonitorService.service.AppConfigService {

    @Autowired
    AppConfigMapper appConfigMapper;
    @Autowired
    LoginMapper loginMapper;

    @Override
    public List<AppConfig> getAppConfig() throws Exception {
        return appConfigMapper.getAppConfig();
    }

    @Override
    public User getUserInfoByAccount(String account) throws Exception {
        return loginMapper.getUserInfoByAccount(account).get(0);
    }

    @Override
    public void updateUserSofts(String account, String sotfs) throws Exception {
        appConfigMapper.updateUserSofts(account,sotfs);
    }

    @Override
    public void addSoftsConfig(String name, String processname) throws Exception {
        appConfigMapper.addSoftsConfig(name, processname);
    }
}
