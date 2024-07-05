package com.lex.practice.execl.easy.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.lex.practice.model.ExcelStudentDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ExcelStudentDTOListener implements ReadListener<ExcelStudentDTO> {
    private static final Logger log = LoggerFactory.getLogger(ExcelStudentDTOListener.class);

    @Override
    public void invoke(ExcelStudentDTO excelStudentDTO, AnalysisContext analysisContext) {
        System.out.println("excelStudentDTO: " + excelStudentDTO);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("All Done!");
    }
}
