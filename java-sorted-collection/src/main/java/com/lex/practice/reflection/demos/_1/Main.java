package com.lex.practice.reflection.demos._1;

import com.alibaba.excel.EasyExcel;
import net.datafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author : LEX_YU
 */
public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();
        Key key = Key.builder().key("123").build();
        Info.InfoBuilder infoBuilder = Info.builder().key("123");
        List<Info> infoList = new ArrayList<>();
        List<Driver> drivers = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Driver driver = Driver.builder().seq(i)
                    .id(100 + (i + 1))
                    .name(faker.name().name())
                    .loginId(faker.random().nextLong(1, 100_000_000))
                    .phone(faker.phoneNumber().cellPhone())
                    .birthday(faker.date().birthday("yyyy-MM-dd"))
                    .email(faker.internet().emailAddress())
                    .addr(faker.address().fullAddress())
                    .build();
            drivers.add(driver);
        }
        System.out.println(drivers);
        Map<String, List<Driver>> keyDrivers = Map.of("123", drivers);

        Info info = Info.buildInfoWithDrivers(key.getKey(), keyDrivers.get(key.getKey()));
        infoList.add(info);

//        keyDrivers.get(key.getKey()).forEach(driver -> {
//            Info.setDriverFields(infoBuilder, driver);
//            for (int seq = 0; seq < drivers.size(); seq++) {
//                if (driver.getSeq() == 0) {
//                    infoBuilder.driver1Id(Math.toIntExact(driver.getId()))
//                            .driver1Name(driver.getName())
//                            .driver1LoginId(driver.getId())
//                            .driver1Phone(driver.getPhone())
//                            .driver1Birthday(String.valueOf(driver.getBirthday()))
//                            .driver1Email(driver.getEmail())
//                            .driver1Addr(driver.getAddr());
//                }
//                if (driver.getSeq() == 1) {
//                    infoBuilder.driver2Id(Math.toIntExact(driver.getId()))
//                            .driver2Name(driver.getName())
//                            .driver2LoginId(driver.getId())
//                            .driver2Phone(driver.getPhone())
//                            .driver2Birthday(String.valueOf(driver.getBirthday()))
//                            .driver2Email(driver.getEmail())
//                            .driver2Addr(driver.getAddr());
//                    }
//                }
//        });
//        infoList.add(infoBuilder.build());

        System.out.println(infoList);
        String file = "D:/Random/excel/infolist.xlsx";

        EasyExcel.write(file, Info.class)
                .sheet()
                .doWrite(infoList);
    }
}
