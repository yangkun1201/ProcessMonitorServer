package com.tzc.yk.MonitorService.service;

import com.tzc.yk.MonitorService.pojo.User;

import java.util.List;
import java.util.Map;

public interface LoginService {
    List<User> test() throws Exception;

    Map<String,Object> login(String account, String password) throws Exception;

}
