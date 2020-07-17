package com.zl.webservice.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zl.webservice.client.DeductServiceClient;
import com.zl.webservice.client.StudentServerClient;
import com.zl.webservice.pojo.Deduct;
import com.zl.webservice.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @Autowired
    StudentServerClient studentServerClient;
    @Autowired
    DeductServiceClient deductServiceClient;

    @RequestMapping("student/list")
    public String listStudent(Model model, int pageNum) {
        Page<Student> page = studentServerClient.listStudent(pageNum);
        model.addAttribute("students", page.getRecords());
        model.addAttribute("iPage", page);

        return "listStudent";
    }

    @RequestMapping("listDeduct")
    public String listDeduct(Model model, int pageNum, int studentId) {
        Page<Deduct> page = deductServiceClient.listDeduct(pageNum, studentId);
        model.addAttribute("deducts", page.getRecords());
        model.addAttribute("iPage", page);

        return "listDeduct";
    }

    @RequestMapping("teacher/login.html")
    public String login() {
        return "login";
    }

    @RequestMapping("student/add.html")
    public String addStudent() {
        return "addStudent";
    }

    @RequestMapping("deductUI")
    public String deductUI(Model model, int id) {
        model.addAttribute("stuId", id);
        return "deduct";
    }
}
