package com.zl.teacherservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.zl.teacherservice.mapper")
public class TeacherServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeacherServiceApplication.class, args);
	}

}
