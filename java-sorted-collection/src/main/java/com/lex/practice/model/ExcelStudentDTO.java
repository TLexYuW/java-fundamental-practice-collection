package com.lex.practice.model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ExcelStudentDTO {
    @ExcelProperty("姓名")
    private String name;
    @ExcelProperty("生日")
    private Date birthday;
    @ExcelProperty("薪水")
    private Double salary;
}
