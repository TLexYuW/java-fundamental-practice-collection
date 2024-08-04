package com.lex.practice.reflection.demos._1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : LEX_YU
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Driver {
    private int seq;
    private int id;
    public String name;
    public long loginId;
    public String phone;
    public String birthday;
    public String email;
    public String addr;
}
