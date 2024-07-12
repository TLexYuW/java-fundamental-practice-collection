package com.lex.practice.execl.easy.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.metadata.data.CellData;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.lex.practice.model.ExcelStudentDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;


public class ExcelStudentDTOListener implements ReadListener<ExcelStudentDTO> {
    private static final Logger log = LoggerFactory.getLogger(ExcelStudentDTOListener.class);

    @Override
    public void invoke(ExcelStudentDTO excelStudentDTO, AnalysisContext context) {
        System.out.println("excelStudentDTO: " + excelStudentDTO);
        // Get sheet information
        String sheetName = context.readSheetHolder().getSheetName();
        Integer sheetNo = context.readSheetHolder().getSheetNo();
        System.out.println(sheetName);
        System.out.println(sheetNo);

        // Get current row number
        Integer rowIndex = context.readRowHolder().getRowIndex();
        System.out.println(rowIndex);

        // Access cell data (if needed)
        CellData cellData = (CellData) context.readRowHolder().getCellMap().get(0); // column index
        System.out.println(cellData);

        // Check if it's a CSV file
        Boolean isCsv = context.readWorkbookHolder().getExcelType().equals(ExcelTypeEnum.CSV);
        System.out.println(isCsv);

        Map<Integer, Head> headMap = context.readSheetHolder().getExcelReadHeadProperty().getHeadMap();

        for (Map.Entry<Integer, Head> entry : headMap.entrySet()) {
            System.out.println("Column " + entry.getKey() + ": " + entry.getValue().getHeadNameList().toString());
        }

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("All Done!");
    }
}
