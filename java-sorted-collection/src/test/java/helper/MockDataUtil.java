package helper;

import com.lex.practice.model.DemoData;
import com.lex.practice.model.ExcelStudentDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class MockDataUtil {

    public static List<DemoData> generateDemoData() {
        List<DemoData> list = new ArrayList<DemoData>();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setString("Str-" + i);
            data.setDate(new Date());
            data.setDoubleData(new Random().nextDouble());
            list.add(data);
        }
        return list;
    }

    public static List<ExcelStudentDTO> generateStudentData() {
        List<ExcelStudentDTO> list = new ArrayList<ExcelStudentDTO>();
        for (int i = 0; i < 10; i++) {
            ExcelStudentDTO data = new ExcelStudentDTO();
            data.setName("Student-" + i);
            data.setBirthday(new Date());
            data.setSalary(new Random().nextDouble(100.0,100000.0));
            list.add(data);
        }
        return list;
    }


}
