package com.zl.studentmanagementsystemeurekaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class StudentManagementSystemEurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemEurekaServiceApplication.class, args);
	}

}
