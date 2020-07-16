package com.zl.studentservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(value = "teacher-server", url = "http://localhost:9098/")
public interface TeacherServiceClient {

    @RequestMapping("login")
    Integer login(@RequestParam("name") String name, @RequestParam("password") String password);
}
