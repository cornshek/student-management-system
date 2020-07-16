package com.zl.studentservice.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.netflix.discovery.converters.Auto;
import com.zl.commons.vo.JSONResult;
import com.zl.studentservice.client.TeacherServiceClient;
import com.zl.studentservice.pojo.Student;
import com.zl.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherServiceClient teacherServiceClient;
    @Value("${server.port}")
    int port;

    @RequestMapping("student/list")
    public String listStudent(Model model, int pageNum) {
        IPage<Student> iPage = studentService.queryPage(pageNum);
        model.addAttribute("students", iPage.getRecords());
        model.addAttribute("iPage", iPage);


        return "listStudent";
    }

    @RequestMapping("teacher/login.html")
    public String loginUI() {
            return "login";
    }

    @RequestMapping("login")
    public String login(String name, String password) {
        Integer signal = teacherServiceClient.login(name, password);
        if (signal == 0) {
            return "login";
        }
        return "redirect:/student/list?pageNum=1";
    }

    @RequestMapping("test")
    @ResponseBody
    public int test() {
        JSONResult<Student> jsonResult = new JSONResult<>();

        return port;

    }
}
