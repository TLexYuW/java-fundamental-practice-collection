package com.lex.practice.spi;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

/**
 * @author : Lex Yu
 */
public class LexLoggerService {
	private static final LexLoggerService SERVICE = new LexLoggerService();

	private final LexLogger lexLogger;

	private final List<LexLogger> loggerList;

	private LexLoggerService() {
		ServiceLoader<LexLogger> loader = ServiceLoader.load(LexLogger.class);
		List<LexLogger> list = new ArrayList<>();
		for (LexLogger log : loader) {
			list.add(log);
		}
		// LoggerList 是所有 ServiceProvider
		loggerList = list;
		if (!list.isEmpty()) {
			lexLogger = list.get(0);
		} else {
			lexLogger = null;
		}
	}

	public static LexLoggerService getService() {
		return SERVICE;
	}

	public void info(String msg) {
		if (lexLogger == null) {
			System.out.println("No LexLogger Service Provider in Info");
		} else {
			lexLogger.info(msg);
		}
	}

	public void debug(String msg) {
		if (loggerList.isEmpty()) {
			System.out.println("No LexLogger Service Provider in Debug");
		}
		loggerList.forEach(log -> log.debug(msg));
	}
}
