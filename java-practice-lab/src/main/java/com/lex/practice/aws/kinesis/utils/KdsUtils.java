package com.lex.practice.aws.kinesis.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lex.practice.aws.kinesis.model.PreCreateRoomLog;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.kinesis.KinesisAsyncClient;
import software.amazon.awssdk.services.kinesis.KinesisClient;
import software.amazon.awssdk.services.kinesis.model.PutRecordRequest;
import software.amazon.awssdk.services.kinesis.model.PutRecordResponse;
import software.amazon.awssdk.services.kinesis.model.PutRecordsRequest;

import java.nio.ByteBuffer;

/**
 * @author : Lex Yu
 */
public class KdsUtils {
	private static ObjectMapper mapper = new ObjectMapper();

	public static void putRecord(KinesisClient kinesisClient, String ThreadNum, Integer uid) throws JsonProcessingException {

		PreCreateRoomLog preCreateRoomLog =
				PreCreateRoomLog.builder()
						.uid(ThreadNum + "-" + uid)
						.room_id("12345678")
						.room_pw("abc")
						.org_id("arplanet_test")
						.enable_pw(true)
						.turn_server_url("turn_server_url")
						.signaling_server_url("signaling_server_url")
						.room_user_max(10)
						.room_user_current(0)
						.expiration("2023-09-20 11:20:00")
						.room_mode(true)
						.media_recording_enable(true)
						.protocol_version("2.0")
						.media_server_url("media_server_url")
						.build();

		PutRecordRequest putRecordRequest = PutRecordRequest.builder()
				.partitionKey("2")
				.streamName("kds-test")
				.data(SdkBytes.fromByteBuffer(ByteBuffer.wrap(mapper.writeValueAsString(preCreateRoomLog).getBytes())))
				.build();

		PutRecordResponse putRecordResponse = kinesisClient.putRecord(putRecordRequest);
		System.out.println(putRecordResponse.toString());
	}

	public static void putRecords(KinesisClient kinesisClient, String streamName,
	                              PutRecordsRequest putRecordsRequest) {

	}

	public static void putRecord(KinesisAsyncClient kinesisAsyncClient, String streamName,
	                             PutRecordRequest putRecordRequest) {

	}

	public static void putRecords(KinesisAsyncClient kinesisAsyncClient, String streamName,
	                              PutRecordsRequest putRecordsRequest) {

	}

}
