package com.tzc.yk.MonitorService.serviceImpl;

import com.tzc.yk.MonitorService.mapper.LoginMapper;
import com.tzc.yk.MonitorService.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoginService implements com.tzc.yk.MonitorService.service.LoginService {

    @Autowired
    LoginMapper loginMapper;

    @Override
    public List<User> test() throws Exception {
        return loginMapper.test();
    }

    @Override
    public Map<String,Object> login(String account, String password) throws Exception {

        int code = 0;
        String username = "";
        String softs = "";
        String phone = "";

        List<User> ls = loginMapper.getUserInfoByAccount(account);
        if(ls==null || ls.size()==0){
            code = 2;
        }else{
            User user = ls.get(0);
            if(user.getPassword().equals(password)){
                code = 0;
                username = user.getUsername();
                softs = user.getSofts();
                phone = user.getPhone();
            }else{
                code = 1;
            }
        }

        Map<String,Object> datas = new HashMap<>();
        datas.put("code",code);
        datas.put("username",username);
        datas.put("softs",softs);
        datas.put("phone",phone);

        return datas;
    }

}
