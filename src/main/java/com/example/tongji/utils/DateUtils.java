package com.example.tongji.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author duPH
 * @date 2021/5/11 15:14
 */
public class DateUtils {
    /**
     * 获取当前日期时间
     *
     * @return 当前日期时间
     */
    public static long localTime() {
        return Long.parseLong(String.valueOf(now("yyyyMMddHHmmss")));
    }

    /**
     * 获取当前日期时间
     *
     * @param pattern 格式
     * @return 当前日期时间
     */
    private static String now(String pattern) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 获取当前日期时间
     *
     * @return 当前日期时间
     */
    public static long dayEndTime() {
        String str = now("yyyyMMddHHmmss");
        return Long.parseLong(String.valueOf(str.substring(0, str.length() - 6) + "235959"));
    }

    /**
     * 获取当前日期时间
     *
     * @return 当前日期时间
     */
    public static long dayStartTime() {
        String str = now("yyyyMMddHHmmss");
        return Long.parseLong(String.valueOf(str.substring(0, str.length() - 6) + "000000"));
    }

    /**
     * 修改当前日期时间为
     *
     * @return 当前日期时间
     */
    public static long updateDayTime(String str) {
        return Long.parseLong(String.valueOf(str + "235959"));
    }

    /**
     * 修改当前日期时间为
     *
     * @return 当前日期时间
     */
    public static long toDayStartTime(String str) {
        return Long.parseLong(String.valueOf(str + "000000"));
    }
}
