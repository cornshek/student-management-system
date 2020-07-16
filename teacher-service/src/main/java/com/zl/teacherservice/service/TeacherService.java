package com.zl.teacherservice.service;

import com.zl.teacherservice.pojo.Teacher;

public interface TeacherService {
    Teacher login(String name, String password);
}
