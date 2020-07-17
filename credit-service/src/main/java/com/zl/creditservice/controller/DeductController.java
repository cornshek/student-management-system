package com.zl.creditservice.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zl.creditservice.pojo.Deduct;
import com.zl.creditservice.service.DeductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class DeductController {
    @Autowired
    DeductService deductService;

    @RequestMapping("addDeduct")
    @ResponseBody
    public void addDeduct(String deductJson) throws IOException {
        /*
         * 从web-server接收json字符串
         * 转换为deduct对象
         * 操作数据库执行插入
         * */
        ObjectMapper objectMapper = new ObjectMapper();
        Deduct deduct = objectMapper.readValue(deductJson, Deduct.class);

        deductService.addDeduct(deduct);
    }

    @RequestMapping("listDeduct")
    @ResponseBody
    public Page<Deduct> listStudent(int pageNum, int studentId) {
        IPage<Deduct> iPage = deductService.listByStudentId(pageNum,studentId);

        Page<Deduct> pageData = new Page<>();
        pageData.setCurrent(iPage.getCurrent());
        pageData.setRecords(iPage.getRecords());
        pageData.setSize(iPage.getSize());
        pageData.setPages(iPage.getPages());
        pageData.setTotal(iPage.getTotal());

        System.out.println(pageData);
        return pageData;
    }
}
