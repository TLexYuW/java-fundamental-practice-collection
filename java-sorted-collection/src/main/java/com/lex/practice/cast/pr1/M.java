package com.lex.practice.cast.pr1;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class M<T extends BaseDTO> {

    @JsonProperty("setting_id")
    private String settingId;
    private T data;

}
