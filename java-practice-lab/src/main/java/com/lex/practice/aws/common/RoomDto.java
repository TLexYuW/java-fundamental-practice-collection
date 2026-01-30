package com.lex.practice.aws.common;

import lombok.*;

/**
 * @author Lex_Yu
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {

    private String id;
    private String org_id;
    private String master;
    private boolean enable_pw;
    private String room_pw;
    private String turn;
    private String signaling;
    private String expiration;
    private Integer mode;
    private Boolean recording_enable;
    private String version;
}
