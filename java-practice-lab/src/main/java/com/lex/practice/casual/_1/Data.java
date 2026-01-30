package com.lex.practice.casual._1;

import com.lex.practice.cast.pr1.M;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@lombok.Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Data {
    private List<MockDto> imageList;
}
