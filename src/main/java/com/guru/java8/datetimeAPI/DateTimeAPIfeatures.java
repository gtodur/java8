/**
 * 
 */
package com.guru.java8.datetimeAPI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * @author Guruprasad.Todur
 *
 */
public class DateTimeAPIfeatures {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Instant – represents a point in time (timestamp)
		// LocalDate – represents a date (year, month, day)
		// LocalDateTime – same as LocalDate, but includes time with nanosecond
		// precision
		// OffsetDateTime – same as LocalDateTime, but with time zone offset
		// LocalTime – time with nanosecond precision and without date information
		// ZonedDateTime – same as OffsetDateTime, but includes a time zone ID
		// OffsetLocalTime – same as LocalTime, but with time zone offset
		// MonthDay – month and day, without year or time
		// YearMonth – month and year, without day or time
		// Duration – amount of time represented in seconds, minutes and hours. Has
		// nanosecond precision
		// Period – amount of time represented in days, months and years

		// **************************************************************************//
		// *******GETTING CURRENT TIME*********//
		// **************************************************************************//
		// Old
		Date date = new Date();
		// Java 8
		ZonedDateTime now = ZonedDateTime.now();
		// **************************************************************************//

		// **************************************************************************//
		// *******REPRESENTING SPECIFIC TIME*********//
		// **************************************************************************//
		// Old
		Date birthDay = new GregorianCalendar(1990, Calendar.DECEMBER, 15).getTime();

		// New
		LocalDate birthDay8 = LocalDate.of(1990, Month.DECEMBER, 15);
		// **************************************************************************//

		// **************************************************************************//
		// *******EXTRACTING SPECIFIC FIELDS*********//
		// **************************************************************************//
		// Old
		int month = new GregorianCalendar().get(Calendar.MONTH);

		// New
		Month month8 = LocalDateTime.now().getMonth();
		// **************************************************************************//

		// **************************************************************************//
		// *******ADDING AND SUBTRACTING TIME*********//
		// **************************************************************************//
		// Old
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.add(Calendar.HOUR_OF_DAY, -5);
		Date fiveHoursBefore = calendar.getTime();

		// New
		LocalDateTime fiveHoursBefore8 = LocalDateTime.now().minusHours(5);
		// **************************************************************************//

		// **************************************************************************//
		// *******ALTERING SPECIFIC FIELDS*********//
		// **************************************************************************//
		// Old
		GregorianCalendar calendarAlter = new GregorianCalendar();
		calendarAlter.set(Calendar.MONTH, Calendar.JUNE);
		Date inJune = calendar.getTime();

		// New
		LocalDateTime inJune8 = LocalDateTime.now().withMonth(Month.JUNE.getValue());
		// **************************************************************************//

		// **************************************************************************//
		// *******TRUNCATE - SET ALL TIME ELEMENTS BELOW INPUT VALUE TO ZERO*********//
		// **************************************************************************//
		// Old
		Calendar nowTruncate = Calendar.getInstance();
		nowTruncate.set(Calendar.MINUTE, 0);
		nowTruncate.set(Calendar.SECOND, 0);
		nowTruncate.set(Calendar.MILLISECOND, 0);
		Date truncated = nowTruncate.getTime();

		// New all below hours, like min sec and msec will be set to 0
		LocalTime truncated8 = LocalTime.now().truncatedTo(ChronoUnit.HOURS);
		// **************************************************************************//

		// **************************************************************************//
		// *******TIMEZONE CONVERSION*********//
		// **************************************************************************//
		// Old
		GregorianCalendar calendarTZ = new GregorianCalendar();
		calendarTZ.setTimeZone(TimeZone.getTimeZone("CET"));
		Date centralEastern = calendarTZ.getTime();

		// New
		ZonedDateTime centralEastern8 = LocalDateTime.now().atZone(ZoneId.of("CET"));
		// **************************************************************************//

		// **************************************************************************//
		// *******GETTING SPAN BETWEEN 2 POINTS IN TIME*********//
		// **************************************************************************//
		// Old
		GregorianCalendar calendarDiff = new GregorianCalendar();
		Date nowDiff = new Date();
		calendarDiff.add(Calendar.HOUR, 1);
		Date hourLater = calendarDiff.getTime();
		long elapsed = hourLater.getTime() - nowDiff.getTime();

		// New
		LocalDateTime now8 = LocalDateTime.now();
		LocalDateTime hourLater8 = LocalDateTime.now().plusHours(1);
		Duration span = Duration.between(now8, hourLater8);
		// **************************************************************************//

		// **************************************************************************//
		// *******TIME FORMATTING AND PARSING*********//
		// **************************************************************************//
		// DateTimeFormatter is a replacement for the old SimpleDateFormat
		// that is thread-safe and provides additional functionality
		// Old
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date nowSdf = new Date();
		String formattedDate = dateFormat.format(nowSdf);
		try {
			Date parsedDate = dateFormat.parse(formattedDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// New
		LocalDate nowSdf8 = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate8 = nowSdf8.format(formatter);
		LocalDate parsedDate8 = LocalDate.parse(formattedDate, formatter);
		// **************************************************************************//

		// **************************************************************************//
		// *******NUMBER OF DAYS IN A MONTH*********//
		// **************************************************************************//
		// Old
		Calendar calendarNo = new GregorianCalendar(1990, Calendar.FEBRUARY, 20);
		int daysInMonth = calendarNo.getActualMaximum(Calendar.DAY_OF_MONTH);

		// New
		int daysInMonth8 = YearMonth.of(1990, 2).lengthOfMonth();
		// **************************************************************************//

		// **************************************************************************//
		// *******INTERACTING WITH LEGACY CODE*********//
		// **************************************************************************//
		Instant instantFromCalendar = GregorianCalendar.getInstance().toInstant();
		ZonedDateTime zonedDateTimeFromCalendar = new GregorianCalendar().toZonedDateTime();
		Date dateFromInstant = Date.from(Instant.now());
		GregorianCalendar calendarFromZonedDateTime = GregorianCalendar.from(ZonedDateTime.now());
		Instant instantFromDate = new Date().toInstant();
		ZoneId zoneIdFromTimeZone = TimeZone.getTimeZone("PST").toZoneId();
		// **************************************************************************//
	}

}
