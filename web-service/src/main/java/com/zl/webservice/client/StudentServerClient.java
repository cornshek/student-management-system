package com.zl.webservice.client;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zl.webservice.pojo.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "student-server", url = "http://localhost:9099/")
public interface StudentServerClient {

    /*不支持接受IPage<> 原因暂时未知*/
    @RequestMapping("student/list")
    Page<Student> listStudent(@RequestParam("pageNum") int pageNum);

    @RequestMapping(value = "student/add")
    void addStudent(@RequestParam("studentJson") String studentJson);
}
