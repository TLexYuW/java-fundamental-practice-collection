package easy;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.lex.practice.execl.easy.listener.DemoDataListener;
import com.lex.practice.execl.easy.listener.ExcelStudentDTOListener;
import com.lex.practice.model.DemoData;
import com.lex.practice.model.ExcelStudentDTO;
import helper.MockDataUtil;
import helper.TestFileUtil;
import org.junit.jupiter.api.Test;

import java.io.File;


class EasyDemoTest {

    @Test
    public void test() {
        String fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
        System.out.println(fileName);
        EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).sheet().doRead();
    }

    @Test
    public void writeDataInXlsx() {
        String fileName = "D:/Random/excel/demo.xlsx";

        EasyExcel.write(fileName, DemoData.class)
                .sheet("TestWriteExcel1")
                .doWrite(MockDataUtil.generateDemoData());
    }

    @Test
    public void writeDataInXlsx2() {
        String fileName = "D:/Random/excel/demo.xlsx";
        try (ExcelWriter excelWriter = EasyExcel.write(fileName).build()) {
            WriteSheet writeSheet1 = EasyExcel.writerSheet("TestWriteExcel1").head(DemoData.class).build();
            WriteSheet writeSheet2 = EasyExcel.writerSheet("TestWriteExcel2").head(ExcelStudentDTO.class).build();
            excelWriter.write(MockDataUtil.generateDemoData(), writeSheet1);
            excelWriter.write(MockDataUtil.generateStudentData(), writeSheet2);
        }
    }

    @Test
    public void readXlsx() {
        String fileName = "D:/Random/excel/demo.xlsx";
        EasyExcel.read(fileName, new DemoDataListener())
                .sheet("TestWriteExcel1")
                .head(DemoData.class)
                .doRead();
        EasyExcel.read(fileName, new ExcelStudentDTOListener())
                .sheet("TestWriteExcel2")
                .head(ExcelStudentDTO.class)
                .doRead();
    }

    @Test
    public void writeWithEncrypt() {
        String fileName = "D:/Random/excel/demoWithEncrypt.xlsx";

        EasyExcel.write(fileName, DemoData.class)
                .password("123456")
                .sheet("TestWriteExcel")
                .doWrite(MockDataUtil.generateDemoData());
    }




}