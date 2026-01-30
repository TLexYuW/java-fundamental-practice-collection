package com.lex.practice.util.time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author : Lex Yu
 */
public class Main {

	public static void main(String[] args) {
//		getISOTimestamp();
//		getYYYYMMDD();
		System.out.println(toDate(1723617219000L));

	}

	public static String toDate(long unix){
		Instant instant = Instant.ofEpochSecond(unix);
		ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("UTC+8"));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return zonedDateTime.format(formatter);
	}

	static LocalDateTime getISOTimestamp() {
		Instant now = Instant.now();
		String iso8601Timestamp = DateTimeFormatter.ISO_INSTANT.format(now);
		System.out.println("ISO 8601 Timestamp: " + iso8601Timestamp);
		LocalDateTime iso8601LocalDateTime = LocalDateTime.parse(iso8601Timestamp, DateTimeFormatter.ISO_DATE_TIME);
		return iso8601LocalDateTime;
	}

	static void getYYYYMMDD(){
		LocalDateTime isoTimestamp = getISOTimestamp();
		DateTimeFormatter desiredFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String yyyyMMdd = isoTimestamp.format(desiredFormatter);
		System.out.println(yyyyMMdd);
	}
	/**
	 * Timer
	 * > A facility for threads to schedule tasks for future execution in a background thread
	 * TimerTask
	 * >  A task that can be scheduled for one-time or repeated execution by a Timer
	 */
	static void playTimerTask() {
		Timer timer = new Timer();

		TimerTask task = new TimerTask() {
			int counter = 10;

			@Override
			public void run() {
				if (counter > 0) {
					System.out.println("Task is done. counter :" + counter);
					counter--;
				} else {
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					System.out.println("End");
					timer.cancel();
				}
			}
		};

		Calendar date = Calendar.getInstance();
		date.set(Calendar.YEAR, 2024);
		date.set(Calendar.MONTH, Calendar.JANUARY);
		date.set(Calendar.DAY_OF_MONTH, 18);
		date.set(Calendar.HOUR_OF_DAY, 20);
		date.set(Calendar.MINUTE, 39);
		date.set(Calendar.SECOND, 30);
		date.set(Calendar.MILLISECOND, 0);

		Calendar date2 = Calendar.getInstance();
		date2.set(Calendar.YEAR, 2024);
		date2.set(Calendar.MONTH, Calendar.JANUARY);
		date2.set(Calendar.DAY_OF_MONTH, 18);
		date2.set(Calendar.HOUR_OF_DAY, 20);
		date2.set(Calendar.MINUTE, 45);
		date2.set(Calendar.SECOND, 45);
		date2.set(Calendar.MILLISECOND, 0);

		// timer.scheduleAtFixedRate(task, date.getTime(), 1000L);
		timer.scheduleAtFixedRate(task, date2.getTime(), 1000L);
		// timer.schedule(task, date.getTime());
		// timer.schedule(task, 3000L);
	}
}
