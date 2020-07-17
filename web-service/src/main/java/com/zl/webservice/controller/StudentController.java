package com.zl.webservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.zl.webservice.client.StudentServerClient;
import com.zl.webservice.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

    @Autowired
    StudentServerClient studentServerClient;

    @RequestMapping(value = "/student/add")
    public String addStudent(Student student) throws JsonProcessingException {

        /*
        * 将前端表单放送的student对象转换为json字符串
        * 通过Feign发送到student-server
        * student-server再处理json字符串
        */
        ObjectMapper objectMapper = new ObjectMapper();
        String studentJson = objectMapper.writeValueAsString(student);


        studentServerClient.addStudent(studentJson);
        return "redirect:/student/list?pageNum=1";
    }
}
