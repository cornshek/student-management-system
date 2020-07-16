package com.zl.teacherservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zl.teacherservice.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {
}
