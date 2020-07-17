package com.zl.studentservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zl.studentservice.mapper.StudentMapper;
import com.zl.studentservice.pojo.Student;
import com.zl.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper mapper;

    @Override
    public IPage<Student> queryPage(int pageNum) {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();

        Page<Student> page = new Page<>(pageNum, 10);

        return mapper.selectPage(page, queryWrapper);
    }

    @Override
    public void addStudent(Student student) {
        mapper.insert(student);
    }

    @Override
    public void deductCreditByStudentId(Student student) {
        mapper.updateById(student);
    }

    @Override
    public Student queryById(int id) {
        return mapper.selectById(id);
    }


}
