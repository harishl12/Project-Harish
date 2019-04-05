package utils;

import java.time.Clock;
import java.time.LocalDate;
import java.util.Date;

public class DateExample {
	public static void main(String[] args) {
//		Date oldDate = Date.parse("1987-05-31");
		LocalDate date = LocalDate.now();
		LocalDate dateOld = LocalDate.of(1987, 5, 31);
		Clock clock = Clock.systemUTC();
		System.out.println(date.now(clock));
		System.out.println(date.compareTo(dateOld));
	}
}
