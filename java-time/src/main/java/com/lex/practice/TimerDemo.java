package com.lex.practice;

import java.time.Duration;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author : Lex Yu
 */
public class TimerDemo {
	public static void main(String[] args) {
		// Timer :
		// A facility for threads to schedule tasks
		// for future execution in a background thread
		// TimerTask :
		// A task that can be scheduled for one-time or repeated execution by a Timer

		Timer timer = new Timer();

		TimerTask task = new TimerTask() {
			int counter = 10;

			@Override
			public void run() {
				if (counter > 0) {
					System.out.println("Task is done. counter :" + counter);
					counter--;
				} else {
					System.out.println("End");
					timer.cancel();
				}
			}
		};

		Calendar date = Calendar.getInstance();
		date.set(Calendar.YEAR, 2023);
		date.set(Calendar.MONTH, Calendar.DECEMBER);
		date.set(Calendar.DAY_OF_MONTH, 27);
		date.set(Calendar.HOUR_OF_DAY, 18);
		date.set(Calendar.MINUTE, 22);
		date.set(Calendar.SECOND, 10);
		date.set(Calendar.MILLISECOND, 0);

		Calendar date2 = Calendar.getInstance();
		date.set(Calendar.YEAR, 2023);
		date.set(Calendar.MONTH, Calendar.DECEMBER);
		date.set(Calendar.DAY_OF_MONTH, 27);
		date.set(Calendar.HOUR_OF_DAY, 18);
		date.set(Calendar.MINUTE, 29);
		date.set(Calendar.SECOND, 30);
		date.set(Calendar.MILLISECOND, 0);

		timer.scheduleAtFixedRate(task, date2.getTime(), 1000L);
//		timer.scheduleAtFixedRate(task, 0, 1000L);
//		timer.schedule(task, date.getTime());
//		timer.schedule(task, 3000L);

	}
}
