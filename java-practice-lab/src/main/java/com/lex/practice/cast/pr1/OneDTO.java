package com.lex.practice.cast.pr1;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class OneDTO extends BaseDTO {

    @JsonProperty("push")
    private PUSH push;
    @JsonProperty("pnp")
    private PNP pnp;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PUSH {
        @JsonProperty("stage")
        private String stage;
        @JsonProperty("c_name")
        private String cName;
        @JsonProperty("o_id")
        private String oId;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PNP {
        @JsonProperty("or_id")
        private String oId;
        @JsonProperty("c_info")
        private String c_info;
        @JsonProperty("url")
        private String url;
    }
}
