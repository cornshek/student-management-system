package com.zl.creditservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zl.creditservice.mapper.DeductMapper;
import com.zl.creditservice.pojo.Deduct;
import com.zl.creditservice.service.DeductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeductServiceImpl implements DeductService {

    @Autowired
    DeductMapper deductMapper;

    @Override
    public void addDeduct(Deduct deduct) {
        deductMapper.insert(deduct);
    }

    @Override
    public IPage<Deduct> listByStudentId(int pageNum, int studentId) {
        QueryWrapper<Deduct> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("student_id", studentId);

        Page<Deduct> page = new Page<>(pageNum, 10);

        return deductMapper.selectPage(page, queryWrapper);
    }
}
