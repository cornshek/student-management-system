package com.zl.teacherservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zl.teacherservice.mapper.TeacherMapper;
import com.zl.teacherservice.pojo.Teacher;
import com.zl.teacherservice.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherMapper mapper;

    @Override
    public Teacher login(String name, String password) {
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .eq("name", name)
                .eq("password", password);
        return mapper.selectOne(queryWrapper);
    }
}
