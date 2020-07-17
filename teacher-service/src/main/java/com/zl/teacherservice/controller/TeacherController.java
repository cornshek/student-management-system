package com.zl.teacherservice.controller;

import com.zl.teacherservice.pojo.Teacher;
import com.zl.teacherservice.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class TeacherController {

    @Autowired
    TeacherService teacherService;
    @Autowired
    HttpSession session;

    @RequestMapping("login")
    @ResponseBody
    public Integer login(String name, String password, Model model) {
        Teacher teacher = teacherService.login(name, password);
        if (teacher == null) {
            model.addAttribute("error", "登录失败");
            return 0;
        }

        session.setAttribute("teacher", teacher);
        return 1;
    }

}
