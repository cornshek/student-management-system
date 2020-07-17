package com.zl.studentservice.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.discovery.converters.Auto;
import com.zl.commons.vo.JSONResult;
import com.zl.studentservice.pojo.Student;
import com.zl.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping("student/list")
    @ResponseBody
    public Page<Student> listStudent(int pageNum) {
        IPage<Student> iPage = studentService.queryPage(pageNum);

        Page<Student> pageData = new Page<>();
        pageData.setCurrent(iPage.getCurrent());
        pageData.setRecords(iPage.getRecords());
        pageData.setSize(iPage.getSize());
        pageData.setPages(iPage.getPages());
        pageData.setTotal(iPage.getTotal());

        return pageData;
    }

    @RequestMapping(value = "student/add" )
    @ResponseBody
    public void addStudent(String studentJson) throws IOException {

        /*
        * 从web-server接收json字符串
        * 转换为student对象
        * 操作数据库执行插入
        * */
        ObjectMapper objectMapper = new ObjectMapper();
        Student student = objectMapper.readValue(studentJson, Student.class);

        studentService.addStudent(student);
    }

    @RequestMapping("deductCredit")
    @ResponseBody
    public void deductCredit(int studentId,  int deductValue) {
        System.out.println(studentId);
        System.out.println(deductValue);
        Student studentToUpdate = studentService.queryById(studentId);
        System.out.println(studentToUpdate);
        studentToUpdate.setCredit(studentToUpdate.getCredit() - deductValue);
        studentService.deductCreditByStudentId(studentToUpdate);
    }
}
