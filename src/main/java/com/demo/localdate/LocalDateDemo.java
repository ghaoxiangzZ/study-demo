package com.demo.localdate;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

/**
 * java8 时间api
 */
public class LocalDateDemo {
    public static void main(String[] args) {
        // 获取当日(日期精确到天)
        LocalDate today = LocalDate.now();
        System.out.println("今天的日期:" + today);
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        System.out.println("year:" + year);
        System.out.println("month:" + month);
        System.out.println("day:" + day);

        // 自定义日期(日期精确到天)
        LocalDate date = LocalDate.of(2020, 2, 6);
        System.out.println("自定义日期:" + date);

        // 判断日期是否相等
        if (Objects.equals(today, date)) {
            System.out.println("时间相等");
        } else {
            System.out.println("时间不等");
        }

        // 周期性的检查日期(以生日为例)
        LocalDate birthLocalDate = LocalDate.of(1994, 8, 10);
        LocalDate now = LocalDate.of(2020, 8, 10);
        MonthDay birthday = MonthDay.of(birthLocalDate.getMonth(), birthLocalDate.getDayOfMonth());
        MonthDay currentMonthDay = MonthDay.from(now);
        if (Objects.equals(currentMonthDay, birthday)) {
            System.out.println("是你的生日");
        } else {
            System.out.println("你的生日还没有到");
        }

        // 获取当日(日期精确到毫秒)
        LocalTime time = LocalTime.now();
        System.out.println("获取当前的时间,不含有日期:" + time);

        // 增加小时
        LocalTime newTime = LocalTime.now().plusHours(3);
        System.out.println("三个小时后的时间为:" + newTime);

        // 增加周
        LocalDate nextWeek = LocalDate.now().plus(1, ChronoUnit.WEEKS);
        System.out.println("一周后的日期为:" + nextWeek);

        // 增加/减少 年
        LocalDate previousYear = LocalDate.now().minus(1, ChronoUnit.YEARS);
        System.out.println("一年前的日期 : " + previousYear);
        LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
        System.out.println("一年后的日期:" + nextYear);

        // java8时钟类获取时间戳(可替代java8之前的System.currentTimeMillis())
        Clock clock = Clock.systemUTC();
        System.out.println("Clock : " + clock.millis());
        Clock defaultClock = Clock.systemDefaultZone();
        System.out.println("Clock : " + defaultClock.millis());
        // java8取时间戳
        Instant timestamp = Instant.now();
        System.out.println("What is value of this instant " + timestamp.toEpochMilli());

        // 判断日期先后
        LocalDate dateNow = LocalDate.now();
        LocalDate dateAfter = dateNow.plus(1, ChronoUnit.DAYS);
        LocalDate dateBefore = today.minus(1, ChronoUnit.DAYS);
        if (dateAfter.isAfter(dateNow)) {
            System.out.println("之后的日期:" + dateAfter);
        }
        if (dateBefore.isBefore(dateNow)) {
            System.out.println("之前的日期:" + dateBefore);
        }

        // 时区转换
        ZoneId parisTimeZone = ZoneId.of("Europe/Paris");
        LocalDateTime localtDateAndTime = LocalDateTime.now();
        ZonedDateTime dateAndTimeInNewYork = ZonedDateTime.of(localtDateAndTime, parisTimeZone);
        System.out.println("Current date and time in a particular timezone : " + dateAndTimeInNewYork);

        // 年月
        YearMonth currentYearMonth = YearMonth.now();
        System.out.printf("Days in month year %s: %d%n", currentYearMonth, currentYearMonth.lengthOfMonth());
        YearMonth creditCardExpiry = YearMonth.of(2019, Month.FEBRUARY);
        System.out.printf("Your credit card expires on %s %n", creditCardExpiry);

        // 闰年
        if (LocalDate.now().isLeapYear()) {
            System.out.println("This year is Leap year");
        } else {
            System.out.println("this is not a Leap year");
        }

        // 计算两个日期之间的年月日
        LocalDate java8Release = LocalDate.of(2018, 12, 14);
        Period periodToNextJavaRelease = Period.between(java8Release, today);
        System.out.println("Months left between today and Java 8 release : "
                + periodToNextJavaRelease.getMonths());
        System.out.println("2018-12-14到当前日期" + LocalDate.now());
        System.out.println("距离当前多少年：" + periodToNextJavaRelease.getYears());
        System.out.println("距离当前多少月：" + periodToNextJavaRelease.getMonths());
        System.out.println("距离当前多少日：" + periodToNextJavaRelease.getDays());

        // 日期格式化
        String dateStr = "20200206";
        LocalDate formatted = LocalDate.parse(dateStr, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(dateStr + "  格式化后的日期为:  " + formatted);

        // 字符串和时间互相转换
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //日期转字符串
        String str = LocalDateTime.now().format(format);
        System.out.println("日期转换为字符串:" + str);
        //字符串转日期
        LocalDate date2 = LocalDate.parse(str, format);
        System.out.println("LocalDate: " + date2);
        LocalDateTime date3 = LocalDateTime.parse(str, format);
        System.out.println("LocalDateTime: " + date3);
    }
}
