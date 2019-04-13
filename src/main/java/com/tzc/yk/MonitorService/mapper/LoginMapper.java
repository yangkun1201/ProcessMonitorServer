package com.tzc.yk.MonitorService.mapper;

import com.tzc.yk.MonitorService.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoginMapper {
    List<User> test() throws Exception;

    List<User> getUserInfoByAccount(@Param("account") String account) throws Exception;

    void registeredAccount(User user) throws Exception;

}
