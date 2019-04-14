package com.tzc.yk.MonitorService;

import com.google.gson.Gson;
import com.tzc.yk.MonitorService.mapper.LoginMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MonitorServiceApplicationTests {

	@Autowired
	LoginMapper loginMapper;

	Logger logger = LoggerFactory.getLogger(MonitorServiceApplicationTests.class);

	@Test
	public void contextLoads() {
	}

	@Test
	public void testLogin(){

	}

	@Test
	public void testGson(){
		Gson gson = new Gson();
		Map<String,Object> data = new HashMap<>();
		data.put("code","123456");
		String jsonData = gson.toJson(data);
		System.out.println(jsonData);
	}

	@Test
	public void testVerificationCode(){
		for(int i=0;i<100;i++){
			getVerificationCode();
		}
	}

	public void getVerificationCode(){
		Long time = System.currentTimeMillis();
		Random random = new Random();
		time = time + random.nextInt(1000000);
		String temp = time.toString();
		int length = temp.length();
		String code = temp.substring(length-6,length);
		System.out.println(code);
	}

}
