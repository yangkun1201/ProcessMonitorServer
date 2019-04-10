package com.tzc.yk.MonitorService;

import com.tzc.yk.MonitorService.mapper.LoginMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

}
