package com.lex.practice.casual._1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    private Integer imgId;
    private Integer carId;
    private String url;
}
