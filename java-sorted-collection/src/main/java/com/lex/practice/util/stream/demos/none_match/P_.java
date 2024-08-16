package com.lex.practice.util.stream.demos.none_match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class P_ {
    private String name;
    private List<String> tags;
}
