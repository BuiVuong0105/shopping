package vn.com.vuong.utils;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger("Daily");

	private static String completeMessage(String str) {
		StringBuilder sb = new StringBuilder("At ");
		sb.append(DateUtils.format_DD_MM_YYYY_HH_MM_SS(new Date()));
		sb.append(" : ");
		sb.append(str);
		return sb.toString();
	}

	public static void debug(String message) {
		String inforMessage = completeMessage(message);
		LOGGER.debug(inforMessage);
	}

	public static void error(Throwable t) {
		LOGGER.error("At " + DateUtils.format_DD_MM_YYYY_HH_MM_SS(new Date()), t);
	}

	public static void info(String message) {
		String inforMessage = completeMessage(message);
		LOGGER.info(inforMessage);
	}

	public static void main(String[] args) {
		debug("aaaa");
	}
}
