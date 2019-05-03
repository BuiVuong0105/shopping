package vn.com.vuong.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import vn.com.vuong.constant.Constant.FormateDate;

public class DateUtils {

	public static Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));

	public static Date currentDateTime() {
		long timeMi = new Date().getTime() - TimeZone.getDefault().getRawOffset();
		return new Date(timeMi);
	}
	
	public static Calendar getDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}

	public static Date addDays(Date date, int days) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		return cal.getTime();
	}

	public static Date increaseDay(Date date, int numOfDay) {
		calendar.setTime(date);
		calendar.add(Calendar.DATE, numOfDay);
		return calendar.getTime();
	}

	public static Date decreaseDay(Date date, int numOfDay) {
		calendar.setTime(date);
		calendar.add(Calendar.DATE, -numOfDay);
		return calendar.getTime();
	}

	public static Date addMonth(Date date, int month) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.MONTH, month);
		return cal.getTime();
	}

	public static Date firstDayOfMonth(Date dateOfMonth) {
		calendar.setTime(dateOfMonth);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return calendar.getTime();
	}

	public static Date endDayOfMonth(Date dateOfMonth) {
		calendar.setTime(dateOfMonth);
		int lastDate = calendar.getActualMaximum(Calendar.DATE);
		calendar.set(Calendar.DATE, lastDate);
		return calendar.getTime();
	}

	public static int getDayOfYear(Date date) {
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_YEAR);
	}

	public static int getDayOfWeek(Date date) {
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_WEEK);
	}

	public static String format_DD_MM_YYYY(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(FormateDate.DD_MM_YYYY);
		return dateFormat.format(date);
	}

	public static Date parse_DD_MM_YYYY(String dateStr) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(FormateDate.DD_MM_YYYY);
		Date date = null;
		try {
			date = dateFormat.parse(dateStr);
		} catch (ParseException e) {
			LogUtil.error(e);
		}
		return date;
	}

	public static String format_DD_MM_YYYY_HH_MM_SS(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(FormateDate.DD_MM_YYYY_HH_MM_SS);
		return dateFormat.format(date);
	}

	public static Date parse_DD_MM_YYYY_HH_MM_SS(String dateStr) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(FormateDate.DD_MM_YYYY_HH_MM_SS);
		Date date = null;
		try {
			date = dateFormat.parse(dateStr);
		} catch (ParseException e) {
			LogUtil.error(e);
		}
		return date;
	}
	
	public static Date now() {
		return new Date();
	}

	// public static String distanceDateBetweenDate(Date d1, Date d2) {
	// LocalDate date1 =
	// d1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	// LocalDate date2 =
	// d2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	// ZoneId defaultZoneId = ZoneId.systemDefault();
	// System.out.println("System Default TimeZone : " + defaultZoneId);
	// Period diff = Period.between(date1, date2);
	// String x = diff.getYears() + " năm " + diff.getMonths() + " tháng " +
	// diff.getDays() + " ngày ";
	// return x;
	// }

	// public static void testTimeJava8() {
	// LocalTime localTime = LocalTime.now();
	// System.out.println(localTime.toString());
	// System.out.println(localTime.getHour());
	// System.out.println(localTime.getMinute());
	// System.out.println(localTime.getSecond());
	// Time time = Time.valueOf(localTime);
	// System.out.println(time);
	// }

	// public static void testLocalTime() {
	// LocalTime localTime = LocalTime.now();
	// System.out.println("Add Date: " + localTime);
	// LocalDateTime localDateTime = localTime.atDate(LocalDate.now());
	// System.out.println("Before Add Date: " + localDateTime);
	// LocalTime localTime2 = LocalTime.parse("20:12:20");
	// System.out.println(localTime.compareTo(localTime));
	// }
	//
	// public static void caculateTime() {
	// LocalTime localTimeStart = LocalTime.parse("08:30:59");
	// long startTime = localTimeStart.getNano();
	// LocalTime localTimeEnd = LocalTime.parse("10:00:20");
	// long endTime = localTimeEnd.getNano();
	// System.out.println(endTime - startTime);
	// long minutes = Duration.between(localTimeStart, localTimeEnd).toMinutes();
	// System.out.println("Until: " + localTimeStart.until(localTimeEnd,
	// ChronoUnit.MINUTES));
	// System.out.println("Duration Between: " + minutes);
	// System.out.println(localTimeEnd.minus(100, ChronoUnit.MINUTES));
	// }
	//
	// public static void compareTime() {
	// LocalTime localTime = LocalTime.parse("15:20:40",
	// DateTimeFormatter.ofPattern("HH:mm:ss"));
	// System.out.println(localTime.toString());
	// LocalTime localTimeStart = LocalTime.parse("12:00:00");
	// LocalTime localTimeEnd = LocalTime.parse("12:01:00");
	// System.out.println(localTimeStart.compareTo(localTimeEnd));
	// }

	public static void main(String[] args) {
		System.out.println(currentDateTime());
		System.out.println(new Date(calendar.getTimeInMillis()));
		System.out.println(new Date(System.currentTimeMillis()));
		// testTimeJava8();
		// testLocalTime();
		// caculateTime();
		// compareTime();
	}
}
