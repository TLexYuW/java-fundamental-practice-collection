package com.lex.practice.cast.pr1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    }

    public static void main(String[] args) throws JsonProcessingException {
        OneDTO.PUSH onePush = OneDTO.PUSH.builder()
                .stage("one_stage")
                .cName("one_c")
                .oId("one_oId")
                .build();
        OneDTO.PNP onePNP = OneDTO.PNP.builder()
                .oId("one_oId")
                .c_info("one_c_info")
                .url("one_url")
                .build();
        BaseDTO.SMS sms = BaseDTO.SMS.builder().content("Something...").build();
        OneDTO one = OneDTO.builder()
                .phone("one_phone")
                .templateId("one_template_id")
                .push(onePush)
                .pnp(onePNP)
                .sms(sms)
                .build();
        M<BaseDTO> mOneId = M.builder().settingId("M_one_id").data(one).build();
        String str = mapper.writeValueAsString(mOneId);
        System.out.println(str);

        M1(str, DtoType.ONE);
    }

    public static void M1(String content, DtoType dtoType) throws JsonProcessingException {
        JavaType type = mapper.getTypeFactory().constructParametricType(M.class, dtoType.getDtoClass());
        M m = mapper.readValue(content, type);
        System.out.println(m);
    }
}
