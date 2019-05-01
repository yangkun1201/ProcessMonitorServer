package com.tzc.yk.MonitorService.serviceImpl;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.tzc.yk.MonitorService.mapper.LoginMapper;
import com.tzc.yk.MonitorService.pojo.FaceItem;
import com.tzc.yk.MonitorService.pojo.User;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoginService implements com.tzc.yk.MonitorService.service.LoginService {

    @Autowired
    LoginMapper loginMapper;

    Logger logger = LoggerFactory.getLogger(LoginService.class);

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

    @Override
    public Map<String,Object> getAccountByFaceId(String faceId) throws Exception {

        Map<String,Object> data = new HashMap<>();
        List<FaceItem> faceItems = getAllFaces();
        for(FaceItem faceItem : faceItems){
            double confidence = compareFaces(faceId,faceItem.getFaceId());
            if(confidence > 85){
                data.put("account",faceItem.getAccount());
                data.put("confidence",confidence);
                return data;
            }
        }
        return null;
    }

    double compareFaces(String face1,String face2){
        double confidence = 0;
        String apiKey = "q7Xo9qxCY2mWGbVIWgFfd-m-Mjn7tBMA";
        String api_secret = "qemnywB2_l8mqP2mjCLqcUvj9J4CifOW";

        RequestBody requestBody = new FormBody.Builder()
                .add("api_key",apiKey)
                .add("api_secret",api_secret)
                .add("image_base64_1",face1)
                .add("image_base64_2",face2)
                .build();

        Request request = new Request.Builder()
                .url("https://api-cn.faceplusplus.com/facepp/v3/compare")
                .post(requestBody)
                .build();

        OkHttpClient client = new OkHttpClient();
        try {
            Response response = client.newCall(request).execute();
            String result = response.body().string();
            System.out.println(result);
            JsonObject jsonObject = new JsonParser().parse(result).getAsJsonObject();
            confidence = jsonObject.get("confidence").getAsDouble();
            System.out.println(confidence);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return confidence;
    }

    @Override
    public User getUserInfoByAccount(String account) throws Exception {
        return loginMapper.getUserInfoByAccount(account).get(0);
    }
}
