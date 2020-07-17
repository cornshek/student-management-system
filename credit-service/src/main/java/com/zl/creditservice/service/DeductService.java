package com.zl.creditservice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zl.creditservice.pojo.Deduct;

public interface DeductService {
    void addDeduct(Deduct deduct);

    IPage<Deduct> listByStudentId(int pageNum, int studentId);
}
