package com.tzc.yk.MonitorService.service;

import com.tzc.yk.MonitorService.pojo.AppTimeRequest;
import com.tzc.yk.MonitorService.pojo.AppTimeResponse;
import java.util.List;


public interface AppService {

    public void addAppTimeInfo(AppTimeRequest appTimeRequest) throws Exception;
    public List<AppTimeResponse> getAppTimeInfo(String account, String soft)throws Exception;

}
