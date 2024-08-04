package com.lex.practice.reflection.demos._1;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author : LEX_YU
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Info {
    @ExcelProperty(value = "", index = 0)
    public String key;
    @ExcelProperty(value = "", index = 1)
    public int driver1Id;
    @ExcelProperty(value = "", index = 2)
    public String driver1Name;
    @ExcelProperty(value = "", index = 3)
    public long driver1LoginId;
    @ExcelProperty(value = "", index = 4)
    public String driver1Phone;
    @ExcelProperty(value = "", index = 5)
    public String driver1Birthday;
    @ExcelProperty(value = "", index = 6)
    public String driver1Email;
    @ExcelProperty(value = "", index = 7)
    public String driver1Addr;

    @ExcelProperty(value = "", index = 8)
    public int driver2Id;
    @ExcelProperty(value = "", index = 9)
    public String driver2Name;
    @ExcelProperty(value = "", index = 10)
    public long driver2LoginId;
    @ExcelProperty(value = "", index = 11)
    public String driver2Phone;
    @ExcelProperty(value = "", index = 12)
    public String driver2Birthday;
    @ExcelProperty(value = "", index = 13)
    public String driver2Email;
    @ExcelProperty(value = "", index = 14)
    public String driver2Addr;

    private static void setDriverFields(Info.InfoBuilder infoBuilder, Driver driver) {
        int seq = driver.getSeq() + 1;
        String[] fields = {"Id", "Name", "LoginId", "Phone", "Birthday", "Email", "Addr"};

        for (String field : fields) {
            try {
                Field infoField = Info.InfoBuilder.class.getDeclaredField("driver" + seq + field);
                infoField.setAccessible(true);
                switch (field) {
                    case "Id":
                        infoField.set(infoBuilder, driver.getId());
                        break;
                    case "Name":
                        infoField.set(infoBuilder, driver.getName());
                        break;
                    case "LoginId":
                        infoField.set(infoBuilder, driver.getLoginId());
                        break;
                    case "Phone":
                        infoField.set(infoBuilder, driver.getPhone());
                        break;
                    case "Birthday":
                        infoField.set(infoBuilder, driver.getBirthday());
                        break;
                    case "Email":
                        infoField.set(infoBuilder, driver.getEmail());
                        break;
                    case "Addr":
                        infoField.set(infoBuilder, driver.getAddr());
                        break;
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static Info buildInfoWithDrivers(String key, List<Driver> drivers) {
        Info.InfoBuilder infoBuilder = Info.builder().key(key);
        drivers.forEach(driver -> setDriverFields(infoBuilder, driver));
        return infoBuilder.build();
    }
}
