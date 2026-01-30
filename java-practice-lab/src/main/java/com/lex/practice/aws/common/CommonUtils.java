package com.lex.practice.aws.common;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author : Lex Yu
 */
public class CommonUtils {

	public static void writeJsonLog() throws IOException {
		try (FileWriter fw = new FileWriter("app.log", true);
		     BufferedWriter bw = new BufferedWriter(fw)) {

			RoomDto roomDto = RoomDto.builder()
					.id("54507d7")
					.org_id("test")
					.master("google_12345678912345679")
					.turn("test_coturn")
					.signaling("test_signaling")
					.expiration("2023-06-08 03:37:45")
					.mode(1)
					.recording_enable(false)
					.version("2.0")
					.enable_pw(true)
					.room_pw("12345")
					.build();
			String room_json = new ObjectMapper().writeValueAsString(roomDto);

			bw.write(room_json + "\n");
			bw.flush();

		} catch (Exception ex) {
			throw new IOException("IO store log error");
		}
	}
}
