package com.cst.stream.common;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Johnney.chiu
 * create on 2017/11/24 16:11
 * @Description 日期时间工具类
 */
public class DateTimeUtil {

    public final static String DEFAULT_DATE_HOUR = "yyyyMMddHH";
    public final static String DEFAULT_DATE_DAY = "yyyyMMdd";
    public final static String DEFAULT_DATE_DEFULT = "yyyy-MM-dd HH:mm:ss";
    public final static String DEFAULT_SHORT_DATE_DEFULT = "yyyy-MM-dd";

    public final static long ONE_HOUR = 60 * 60 * 1000;
    public final static long ONE_DAY = 24 * 60 * 60 * 1000;





    public static String toLongTimeString(Date dt,String fmt) {
        SimpleDateFormat myFmt = new SimpleDateFormat(fmt);
        return myFmt.format(dt);
    }

    public static String toLongTimeString(long timestamp,String fmt) {
        SimpleDateFormat myFmt = new SimpleDateFormat(fmt);
        Timestamp ts = new Timestamp(timestamp);
        return myFmt.format(ts);

    }

    public static Long strToTimestamp(String str,String fmt) throws ParseException {
        SimpleDateFormat myFmt = new SimpleDateFormat(fmt);
        Date date=myFmt.parse(str);
        return date.getTime();
    }

    /**
     * 获取单位秒数
     * @param timestamp
     * @return
     * @throws ParseException
     */
    public static Long getHourBase(long timestamp){
        return (timestamp / ONE_HOUR)*ONE_HOUR;
    }

    public static Long getDayBase(long timestamp){
        return (timestamp / ONE_DAY)*ONE_DAY;
    }

    /**
     * 当前月的第一天
     * @param timestamp
     * @return
     */
    public static long getMonthBase(long timestamp){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(timestamp));
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTimeInMillis();
    }


    public static String getNow(String format){
        return toLongTimeString(new Date(), format);
    }



    public static List<String> calcLongTimeHourBetween(long timestamp1, long timestamp2,String fmt,long interval) {
        List<String> list = new ArrayList<>();
        long temp = timestamp1+ interval;
        while (temp<timestamp2) {
            list.add(new SimpleDateFormat(fmt).format(new Timestamp(temp)));
            temp +=interval;
        }
        return list;
    }

    public static boolean hourBetween(long timestamp1, long timestamp2,String fmt) {
        return toLongTimeString(timestamp1,fmt).equals(timestamp2);
    }


    public static void main(String... args) throws ParseException {
        //System.out.println(DateTimeUtil.toLongTimeString(new Date()));
        long cur = System.currentTimeMillis();
        System.out.println(DateTimeUtil.toLongTimeString(cur,DateTimeUtil.DEFAULT_DATE_HOUR));
        long cur2 = cur - 1 * ONE_HOUR;
        System.out.println(DateTimeUtil.toLongTimeString(cur2,DateTimeUtil.DEFAULT_DATE_HOUR));
        List<String> list = calcLongTimeHourBetween(cur2, cur,DateTimeUtil.DEFAULT_DATE_HOUR,DateTimeUtil.ONE_DAY);
        for (String str: list) {
            System.out.println(str);
        }

        System.out.println(DateTimeUtil.strToTimestamp(DateTimeUtil.toLongTimeString(cur,DateTimeUtil.DEFAULT_DATE_HOUR),DateTimeUtil.DEFAULT_DATE_HOUR));
        System.out.println(DateTimeUtil.toLongTimeString(DateTimeUtil.strToTimestamp(DateTimeUtil.toLongTimeString(cur,DateTimeUtil.DEFAULT_DATE_HOUR),DateTimeUtil.DEFAULT_DATE_HOUR),DateTimeUtil.DEFAULT_DATE_HOUR));
    }

}
