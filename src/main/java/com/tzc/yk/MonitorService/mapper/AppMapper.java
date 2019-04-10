package com.tzc.yk.MonitorService.mapper;

import com.tzc.yk.MonitorService.pojo.AppTimeResponse;
import com.tzc.yk.MonitorService.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppMapper {

    public void addAppTimeInfo(@Param("account")    String account,
                               @Param("soft")       String soft,
                               @Param("cur_time")   int curTime,
                               @Param("total_time") int totalTime) throws Exception;

    public void updateAppTimeInfo(@Param("account")    String account,
                                  @Param("soft")       String soft,
                                  @Param("cur_time")   int curTime,
                                  @Param("total_time") int totalTime) throws Exception;

    public List<AppTimeResponse> getAppTimeInfo(@Param("account") String account,
                                                @Param("soft") String soft)throws Exception;


}
