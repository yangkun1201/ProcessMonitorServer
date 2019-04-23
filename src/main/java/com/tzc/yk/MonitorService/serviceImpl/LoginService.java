package com.tzc.yk.MonitorService.serviceImpl;

import com.tzc.yk.MonitorService.mapper.LoginMapper;
import com.tzc.yk.MonitorService.pojo.FaceItem;
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

    @Override
    public void registeredAccount(User user) throws Exception {
        loginMapper.registeredAccount(user);
    }

    @Override
    public boolean checkAccountExist(String account) throws Exception {
        if(loginMapper.getUserInfoByAccount(account).size()>0){
            return true;
        }
        return false;
    }

    @Override
    public void addFaceId(String account, String faceBase64) throws Exception {
        List<FaceItem> faceItemList = loginMapper.getAllFaces();
        boolean hasAccount = false;
        for(FaceItem faceItem:faceItemList){
            if(faceItem.getAccount().equals(account)){
                hasAccount = true;
                break;
            }
        }
        if(hasAccount){
            loginMapper.updateFaceId(account,faceBase64);
        }else{
            loginMapper.addFaceId(account, faceBase64);
        }

    }

    @Override
    public List<FaceItem> getAllFaces() throws Exception {
        return loginMapper.getAllFaces();
    }
}
