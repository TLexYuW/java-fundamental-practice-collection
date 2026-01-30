package com.lex.practice.cast.pr1;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BaseDTO {

    private String phone;
    private String templateId;
    private SMS sms;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SMS {
        @JsonProperty("content")
        private String content;
    }
}

