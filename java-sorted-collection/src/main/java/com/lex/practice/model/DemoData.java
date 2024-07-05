package com.lex.practice.model;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemoData {
    @ExcelProperty("Title")
    private String string;
    @ExcelProperty("Date")
    private Date date;
    @ExcelProperty("DoubleTypeData")
    private Double doubleData;

    @ExcelIgnore
    private String ignore;

}
