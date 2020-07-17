package com.zl.webservice.controller;

import com.zl.webservice.client.TeacherServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @Autowired
    TeacherServiceClient teacherServiceClient;

    @RequestMapping("login")
    public String login(String name, String password) {
        Integer signal = teacherServiceClient.login(name, password);
        if (signal == 0) {
            return "login";
        }
        return "redirect:/student/list?pageNum=1";
    }
}
