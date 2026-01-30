package com.lex.practice.cast.pr1;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class TwoDTO extends BaseDTO {

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
        @JsonProperty("r_amount")
        private String rAmount;
    }

    public static class PNP {

    }
}
