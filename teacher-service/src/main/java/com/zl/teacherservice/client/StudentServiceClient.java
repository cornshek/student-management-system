package com.zl.teacherservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "student-server", url = "http://localhost:9099/")
public interface StudentServiceClient {

    @RequestMapping("student/list")
    void studentList();
}
