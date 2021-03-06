package com.zl.studentservice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zl.studentservice.pojo.Student;

import java.util.List;

public interface StudentService {

    /*查询所有学生*/
    IPage<Student> queryPage(int pageNum);

    /*添加学生*/
    void addStudent(Student student);

    /*根据扣除记录修改剩余学分*/
    void deductCreditByStudentId(Student student);

    Student queryById(int id);
}
