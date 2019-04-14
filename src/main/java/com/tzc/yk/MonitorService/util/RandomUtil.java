package com.tzc.yk.MonitorService.util;

import java.util.Random;

public class RandomUtil {

    private volatile static RandomUtil instances;

    private RandomUtil(){}

    public static RandomUtil getInstance() {

        if(instances == null){
            synchronized (RandomUtil.class){
                if(instances == null){
                    instances = new RandomUtil();
                }
            }
        }
        return instances;
    }

    public String getVerificationCode(){
        String randomCode = "";
        Long time = System.currentTimeMillis();
        Random random = new Random();
        time = time + random.nextInt(1000000);
        String temp = time.toString();
        int length = temp.length();
        randomCode = temp.substring(length-6,length);
        return randomCode;
    }

}
