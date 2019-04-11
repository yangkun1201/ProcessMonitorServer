package com.tzc.yk.MonitorService.mapper;

import com.tzc.yk.MonitorService.pojo.AppConfig;
import com.tzc.yk.MonitorService.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppConfigMapper {

    List<AppConfig> getAppConfig() throws Exception;

    void updateUserSofts(@Param("account")String account,
                         @Param("softs")String softs) throws Exception;

    void addSoftsConfig(@Param("name")String name,
                        @Param("processname")String processname) throws Exception;

}
