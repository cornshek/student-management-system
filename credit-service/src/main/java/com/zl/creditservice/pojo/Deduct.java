package com.zl.creditservice.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.sql.Date;

public class Deduct {
    @TableId(type = IdType.AUTO)
    private long id;
    private Integer value;
    private String reason;
    private Date deductDate;
    private Integer studentId;

    @Override
    public String toString() {
        return "Deduct{" +
                "id=" + id +
                ", value=" + value +
                ", reason='" + reason + '\'' +
                ", deductDate=" + deductDate +
                ", studentId=" + studentId +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getDeductDate() {
        return deductDate;
    }

    public void setDeductDate(Date deductDate) {
        this.deductDate = deductDate;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}
