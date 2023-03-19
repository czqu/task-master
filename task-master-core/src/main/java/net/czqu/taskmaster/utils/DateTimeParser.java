package net.czqu.taskmaster.utils;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
/**
 * @program: task-master
 * @description:
 * @author: Paul Chen
 * @create: 2023-03-15 22:39
 **/
public class DateTimeParser {
    public static LocalDateTime parseDateTime(String dateTimeString, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(dateTimeString, formatter);
    }

    public static LocalDate parseDate(String dateString, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(dateString, formatter);
    }

    public static LocalTime parseTime(String timeString, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalTime.parse(timeString, formatter);
    }
}
