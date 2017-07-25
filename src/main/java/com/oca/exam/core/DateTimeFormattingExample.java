package com.oca.exam.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DateTimeFormattingExample {

    public static void main(String... args) {

        usingDateTimeFormatter();

        formattingDatesAndTimes();

        ofLocalizedMethods();

        parsingDatesAndTimes();
    }

    private static void usingDateTimeFormatter() {
        LocalDate nowLocalDate = LocalDate.now();
        System.out.printf("Now date in ISO date format: %s %n",
                nowLocalDate.format(DateTimeFormatter.ISO_DATE));
        System.out.printf("Now date/time in ISO date/time format: %s %n",
                LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));

        String ddMMyyyyPattern = "dd/MM/yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(ddMMyyyyPattern);
        String formattedDate = nowLocalDate.format(formatter);
        System.out.printf("Now date in [%s] format: %s %n", ddMMyyyyPattern, formattedDate);
        System.out.printf("Parsed formatted now date[%s]: %s %n", formattedDate,
                LocalDate.parse(formattedDate, formatter));

        // http://www.localeplanet.com/java/fr-CA/
        String dMMMMyyyyPattern = "d MMMM yyyy";
        DateTimeFormatter canadianFrenchFormatter =
                DateTimeFormatter.ofPattern(dMMMMyyyyPattern, Locale.CANADA_FRENCH);
        System.out.printf("Now date in [%s] format and [%s] locale: %s %n",
                dMMMMyyyyPattern, Locale.CANADA_FRENCH,
                nowLocalDate.format(canadianFrenchFormatter));
    }

    private static void formattingDatesAndTimes() {

        LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
        LocalTime time = LocalTime.of(11,12,34);
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME));
        System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        DateTimeFormatter shortDateTime = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        System.out.println(shortDateTime.format(dateTime));
        System.out.println(shortDateTime.format(date));
//        System.out.println(shortDateTime.format(time)); // UnsupportedTemporalTypeException

        // Print same as the previous code
        System.out.println(dateTime.format(shortDateTime));
        System.out.println(date.format(shortDateTime));
//        System.out.println(time.format(shortDateTime)); // UnsupportedTemporalTypeException
    }

    private static void ofLocalizedMethods() {
        LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
        LocalTime time = LocalTime.of(11,12,34);
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        DateTimeFormatter shortFormat = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        DateTimeFormatter mediumFormat = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        DateTimeFormatter customFormat = DateTimeFormatter.ofPattern("MMMM dd, yyyy, hh:mm");

        System.out.printf("shortFormat = %s%n", shortFormat.format(dateTime));
        System.out.printf("mediumFormat = %s%n", mediumFormat.format(dateTime));
        System.out.printf("customFormat = %s%n", customFormat.format(dateTime));

        DateTimeFormatter customFormatPattern = DateTimeFormatter.ofPattern("hh:mm");
        System.out.printf("customFormatPattern = %s%n", customFormatPattern.format(dateTime));
//        System.out.printf("customFormatPattern = %s%n", customFormatPattern.format(date)); // UnsupportedTemporalTypeException
        System.out.printf("customFormatPattern = %s%n", customFormatPattern.format(time));
    }

    private static void parsingDatesAndTimes() {

        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("MM dd yyyy");
        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH mm");

        LocalDate date = LocalDate.parse("01 02 2015", formatDate);
        LocalTime time = LocalTime.parse("10 15", formatTime);

        System.out.printf("date = %s%n", date);
        System.out.printf("time = %s%n", time);
    }
}
