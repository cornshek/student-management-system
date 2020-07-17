package com.zl.webservice.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zl.webservice.client.StudentServerClient;
import com.zl.webservice.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @Autowired
    StudentServerClient studentServerClient;

    @RequestMapping("student/list")
    public String listStudent(Model model, int pageNum) {
        Page<Student> page = studentServerClient.listStudent(pageNum);
        model.addAttribute("students", page.getRecords());
        model.addAttribute("iPage", page);

        return "listStudent";
    }

    @RequestMapping("teacher/login.html")
    public String login() {
        return "login";
    }

    @RequestMapping("student/add.html")
    public String addStudent() {
        return "addStudent";
    }
}
