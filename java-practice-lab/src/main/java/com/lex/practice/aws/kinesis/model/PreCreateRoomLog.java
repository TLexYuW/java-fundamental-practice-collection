package com.lex.practice.aws.kinesis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Lex Yu
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PreCreateRoomLog {
	private String room_id;
	private String org_id;
	private String uid; // uuid
	private String room_pw;
	private boolean enable_pw;
	private String turn_server_url;
	private String signaling_server_url;
	private int room_user_max;
	private int room_user_current;
	private String expiration;
	private boolean room_mode;
	private boolean media_recording_enable;
	private String protocol_version;
	private String media_server_url;
}
