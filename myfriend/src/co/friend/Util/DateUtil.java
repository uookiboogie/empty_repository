package co.friend.Util;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

public class DateUtil {
	static String format = "yyyy-MM-dd";

	// Date -> String
	public static String dateToStr(Date date) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		String s = df.format(date);
		return s;
	}

	public static String dateToStr(Date date, String format) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		String s = df.format(date);
		return s;
	}

	// 두 날짜 사이의 일수 계산
	public static long durationDay(Date d1, Date d2) {
		long result = 0;
		result = d1.getTime() - d2.getTime();
		result = result / 1000 / 60 / 60 / 24;
		return result;

	}

	public static long durationDay(String s1, String s2) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		long result = 0;
		try {
			Date d1 = df.parse(s1);
			Date d2 = df.parse(s2);
			result = d1.getTime() - d2.getTime();
			result = result / 1000 / 60 / 60 / 24;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;

	}
	public static int lastDayOfMonth(int year, int mouth) {
		int result=0;
		Calendar cal =Calendar.getInstance();
		cal.set(year,mouth-1,1);
		result = cal.getActualMaximum(Calendar.DATE);
		//다른방법
		LocalDate localDate = LocalDate.of(year, mouth, 1);
		localDate.lengthOfMonth();

		return result;
	}
}
