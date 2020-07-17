package com.zl.webservice.client;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zl.webservice.pojo.Deduct;
import com.zl.webservice.pojo.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "CREDIT-SERVER", url = "http://localhost:9097/")
public interface DeductServiceClient {

    /**
     * 不支持Form表单POST的数据格式
     * 暂时用Json字符串代替传递数据
     * @param deductJson
     */
    @RequestMapping(value = "addDeduct")
    void addDeduct(@RequestParam("deductJson") String deductJson);

    /*不支持接受IPage<> 原因暂时未知*/
    @RequestMapping("listDeduct")
    Page<Deduct> listDeduct(@RequestParam("pageNum") int pageNum, @RequestParam(value = "studentId") int studentId);

}
