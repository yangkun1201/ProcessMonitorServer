package com.tzc.yk.MonitorService.serviceImpl;

import com.tzc.yk.MonitorService.mapper.AppMapper;
import com.tzc.yk.MonitorService.mapper.LoginMapper;
import com.tzc.yk.MonitorService.pojo.AppTimeItem;
import com.tzc.yk.MonitorService.pojo.AppTimeRequest;
import com.tzc.yk.MonitorService.pojo.AppTimeResponse;
import com.tzc.yk.MonitorService.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppService implements com.tzc.yk.MonitorService.service.AppService {

    @Autowired
    AppMapper appMapper;

    @Override
    public void addAppTimeInfo(AppTimeRequest appTimeRequest) throws Exception {
        String account = appTimeRequest.getAccount();
        List<AppTimeItem> apps = appTimeRequest.getAppStatus();
        for(AppTimeItem app : apps){
            List<AppTimeResponse> ls = appMapper.getAppTimeInfo(account,app.getAppName());
            if(ls.size()==0){ //查询列表为空，新增数据
                appMapper.addAppTimeInfo(account,app.getAppName(),app.getAppTime(),0);
            }else{ //查询列表非空，更新数据
                AppTimeResponse oldData = ls.get(0);
                int curTime = app.getAppTime();
                int totalTime = oldData.getCurTime() + oldData.getTotalTime();
                appMapper.updateAppTimeInfo(account,app.getAppName(),curTime,totalTime);
            }
        }

    }

    @Override
    public List<AppTimeResponse> getAppTimeInfo(String account, String soft) throws Exception {
        return appMapper.getAppTimeInfo(account,soft);
    }

}
