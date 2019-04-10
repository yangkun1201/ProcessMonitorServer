package com.tzc.yk.MonitorService;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tzc.yk.MonitorService.mapper")
public class MonitorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonitorServiceApplication.class, args);
	}

}
