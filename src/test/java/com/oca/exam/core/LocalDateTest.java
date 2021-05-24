package com.oca.exam.core;

import org.junit.Test;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;

public class LocalDateTest {

    @Test
    public void localDateTest() {
        /* LocalDate */
        LocalDate specificDate = LocalDate.of(2016, 2, 15);
        System.out.printf("Specific date[2016-02-15]: year[%d], month[%s], day[%s]," +
                        " length of month[%d], leap year[%b]%n",
                specificDate.getYear(),
                specificDate.getMonth(),
                specificDate.getDayOfWeek(),
                specificDate.lengthOfMonth(),
                specificDate.isLeapYear());

        LocalDate todayDate = LocalDate.now();
        System.out.printf("Today date: year[%d], month[%d], day[%d]%n",
                todayDate.get(ChronoField.YEAR),
                todayDate.get(ChronoField.MONTH_OF_YEAR),
                todayDate.get(ChronoField.DAY_OF_MONTH));
    }

    @Test
    public void localTimeTest() {

        /* LocalTime */
        LocalTime specificTime = LocalTime.of(21, 16, 59);
        System.out.printf("Specific time[21:16:59]: hour[%d], minute[%d], second[%d]%n",
                specificTime.getHour(),
                specificTime.getMinute(),
                specificTime.getSecond());

        LocalTime nowTime = LocalTime.now();
        System.out.printf("Now time: hour[%d], minute[%d], second[%d]%n",
                nowTime.get(ChronoField.HOUR_OF_DAY),
                nowTime.get(ChronoField.MINUTE_OF_HOUR),
                nowTime.get(ChronoField.SECOND_OF_MINUTE));
    }

    @Test
    public void localDateTimeTest() {

        LocalDate specificDate = LocalDate.of(2016, 2, 15);
        LocalTime specificTime = LocalTime.of(21, 16, 59);

        /* LocalDateTime */
        System.out.printf("Parsing specific date[2015-02-24]: %s %n", LocalDate.parse("2015-02-24"));
        System.out.printf("Parsing specific time[23:54:08]: %s %n", LocalTime.parse("23:54:08"));

        LocalDateTime nowDateTime = LocalDateTime.now();
        System.out.printf("Now date/time: %s %n", nowDateTime);

        LocalDateTime specificDateTime = LocalDateTime.of(1940, Month.JANUARY, 20, 0, 0, 1);
        System.out.printf("Specific date/time 1: %s %n", specificDateTime);
        System.out.printf("Specific date/time 2: %s %n", LocalDateTime.of(specificDate, specificTime));
        System.out.printf("Specific date/time 3: %s %n", specificDate.atTime(specificTime));
        System.out.printf("Specific date/time 4: %s %n", specificTime.atDate(specificDate));
    }

    @Test
    public void instantTest() {

        /* Instant */
        Instant oneBlnInstant = Instant.ofEpochSecond(1_000_000_000);
        System.out.printf("1 Billion seconds since the Unix epoch time," +
                " midnight of January 1 1970 UTC: %s %n", oneBlnInstant);
        Instant nowInstant = Instant.now();
        System.out.printf("%s seconds since the Unix epoch time to now %n",
                nowInstant.getEpochSecond());
    }

    @Test
    public void durationTest() {

        /* Duration */
        LocalTime specificTime = LocalTime.of(21, 16, 59);
        LocalTime nowTime = LocalTime.now();
        System.out.printf("Time duration between %s and %s: %s %n",
                specificTime, nowTime, Duration.between(specificTime, nowTime));

        LocalDateTime nowDateTime = LocalDateTime.now();
        LocalDateTime specificDateTime = LocalDateTime.of(1940, Month.JANUARY, 20, 0, 0, 1);
        System.out.printf("Date/Time duration between %s and %s: %s %n",
                specificDateTime, nowDateTime,
                Duration.between(specificDateTime, nowDateTime));

        Instant oneBlnInstant = Instant.ofEpochSecond(1_000_000_000);
        Instant nowInstant = Instant.now();
        System.out.printf("Instant duration between %s and %s: %s %n",
                oneBlnInstant, nowInstant, Duration.between(oneBlnInstant, nowInstant));

        // Duration cannot be applied to LocalDate instances
        // (throws java.time.temporal.UnsupportedTemporalTypeExceptionUnsupported unit: Seconds),
        // use Period instead
        // Duration.between(specificDate, todayDate);
    }

    @Test
    public void periodTest() {

        /* Period */
        LocalDate specificDate = LocalDate.of(2016, 2, 15),
                  todayDate = LocalDate.now();
        System.out.printf("Period between %s and %s: %s %n", specificDate, todayDate, Period.between(specificDate, todayDate));
        System.out.printf("Specific period (3 weeks): %s %n", Period.ofWeeks(3));

        LocalDate start = LocalDate.of(2015, Month.JANUARY, 1);
        LocalDate end = LocalDate.of(2015, Month.MARCH, 30);
        Period period = Period.ofMonths(1); // ofWeeks, ofDays, of
        while(start.isBefore(end)) {
            System.out.println("Give toy: " + start);
            start = start.plus(period);
        }

        Period wrong = Period.ofYears(1); // It is redundant
        System.out.println(wrong);
        wrong = Period.ofWeeks(7);
        System.out.println(wrong);
    }

    @Test
    public void toEpochtest() {

        System.out.printf("Number of days since January 1, 1970: %s %n", LocalDate.now().toEpochDay());
        System.out.printf("Number of seconds since January 1, 1970: %s %n",
                LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));
    }

    @Test(expected = DateTimeException.class)
    public void ch03q30() {
        LocalDate date = LocalDate.of(2018, Month.APRIL, 40);
        System.out.println(date.getYear() + " " + date.getMonth() + " " + date.getDayOfMonth());
    }

    @Test
    public void ch03q31() {

        LocalDate date = LocalDate.of(2018, Month.APRIL, 30);
        date.plusDays(2);
        date.plusYears(3);
        System.out.println(date.getYear() + " " + date.getMonth() + " " + date.getDayOfMonth());
    }

    @Test
    public void test06_Q52() {

        System.out.println(LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.TUESDAY)));
        System.out.println(LocalDate.now().with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY)));
//        System.out.println(new LocalDate().with(TemporalAdjusters.next(DayOfWeek.TUESDAY)));
//        System.out.println(new LocalDate().adjust(TemporalAdjusters.next(DayOfWeek.TUESDAY)));
        System.out.println(TemporalAdjusters.next(DayOfWeek.TUESDAY).adjustInto(LocalDate.now()));
    }
}
