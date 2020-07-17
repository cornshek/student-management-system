package com.zl.creditservice.client;

import com.zl.creditservice.pojo.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "student-SERVER", url = "http://localhost:9099/")
public interface StudentServiceClient {

    @RequestMapping("deductCredit")
    void deductCredit(@RequestParam("studentId") int studentId, @RequestParam("deductValue") int deductValue);
}
