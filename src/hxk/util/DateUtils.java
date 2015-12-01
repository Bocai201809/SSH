package hxk.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.apache.commons.lang3.StringUtils;

/**
 * @author HXK
 * @description
 *2014-1-24  上午11:37:52
 */
public class DateUtils {
    /*******************时间的上下计算*************************************/
    public static Date afterMilliseconds(long time, long milliseconds)
    {
        return new Date(time + milliseconds);
    }

    public static Date afterSeconds(long time, long seconds)
    {
        return new Date(time + 1000L * seconds);
    }

    public static Date afterSeconds(long seconds)
    {
        return new Date(System.currentTimeMillis() + 1000L * seconds);
    }

    public static Date afterMinutes(long time, long minutes)
    {
        return new Date(time + 60000L * minutes);
    }

    public static Date afterMinutes(long minutes)
    {
        return new Date(System.currentTimeMillis() + 60000L * minutes);
    }

    public static Date afterHours(long time, long hours)
    {
        return new Date(time + 3600000L * hours);
    }

    public static Date afterHours(long hours)
    {
        return new Date(System.currentTimeMillis() + 3600000L * hours);
    }

    public static Date afterDays(long time, long days)
    {
        return new Date(time + 86400000L * days);
    }

    public static Date afterDays(long days)
    {
        return new Date(System.currentTimeMillis() + 86400000L * days);
    }

    public static Date afterYears(long time, long years)
    {
        return new Date(time + 31536000000L * years);
    }

    public static Date afterYears(long years)
    {
        return new Date(System.currentTimeMillis() + 31536000000L * years);
    }
    
    
    /***********************根据时间转换为字符串*************************************/
    public static String formatTime(Date date)
    {
        return formatDate(date, "yyyy-MM-dd HH:mm:ss");
    }
    
    public static String formatDate(Date date)
    {
        return formatDate(date, "yyyy-MM-dd");
    }
    
    public static String formatDate(Date date, TimeZone zone)
    {
        return formatDate(date, zone, "yyyy-MM-dd HH:mm:ss");
    }

    public static String formatDate(Date date, String dateFormatPattern)
    {
        return formatDate(date, null, dateFormatPattern);
    }

    public static String formatDate(Date date, TimeZone zone, String dateFormatPattern)
    {
        DateFormat dateFormat = null;
        try
        {
            dateFormat = new SimpleDateFormat(dateFormatPattern);
        }
        catch(Exception ignore)
        {
            dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        if(zone != null)
            dateFormat.setTimeZone(zone);
        return formatDate(date, dateFormat);
    }

    public static String formatDate(Date date, DateFormat dateFormat)
    {
        if(date == null)
            throw new IllegalArgumentException("date can not be null");
        if(dateFormat == null)
            throw new IllegalArgumentException("dateFormat can not be null");
        else
            return dateFormat.format(date);
    }

    /***************************关于根据字符串转换为日期的*************************************/
    public static Date parseDate(String text,String pattern){
	if (text == null) {
	    throw new IllegalArgumentException("text can not be null");
	}
	if (pattern == null) {
	    throw new IllegalArgumentException("pattern can not be null");
	}
	Date date = null;
	SimpleDateFormat sdf = new SimpleDateFormat(pattern);
	try {
	    date = sdf.parse(text);
	} catch (ParseException e) {
	    e.printStackTrace();
	}
	return date;
    }
    
    public static Date parseDate(String text){
	return parseDate(text, "yyyy-MM-dd");
    }
    
    public static Date parseDateTime(String text){
	return parseDate(text, "yyyy-MM-dd HH:mm:ss");
    }
    
    
    /********************************************************/
    /**
     * @description 将日期与时间拼起来返回一个带时间的日期	
     * @param date 日期 yyyy-MM-dd格式的
     * @param time 字符串 格式为"HH:mm:ss"
     * @return
     *2014-1-24  下午12:17:37
     *返回类型:Date
     */
    public static Date contact(Date date, String time)
    {
        if(StringUtils.isEmpty(time))
            return date;
        time = time.replace(":", "");
        String hour = null;
        String minute = null;
        String second = null;
        int len = time.length();
        if(len >= 2)
            hour = time.substring(0, 2);
        if(len >= 4)
            minute = time.substring(2, 4);
        if(len >= 6)
            second = time.substring(4, 6);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(11, Integer.parseInt(hour));
        calendar.set(12, Integer.parseInt(minute));
        calendar.set(13, Integer.parseInt(second));
        return calendar.getTime();
    }
    
    public static int getDayOfWeek(Date date)
    {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar.get(7);
    }
    
    public static int getDayOfWeek(String date)
    {
        int year;
        int month;
        int day;
        if(StringUtils.isEmpty(date))
            return -1;
        String input = date.replace("-", "");
        int len = input.length();
        if(len != 4 && len != 8)
            return -1;
        year = 0;
        month = 0;
        day = 0;
        if(len == 8)
        {
            year = Integer.parseInt(input.substring(0, 4));
            input = input.substring(4);
        }
        month = Integer.parseInt(input.substring(0, 2));
        day = Integer.parseInt(input.substring(2, 4));
        int week;
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        if(year > 0)
            calendar.set(1, year);
        if(month > 0)
            calendar.set(2, month - 1);
        if(day > 0)
            calendar.set(5, day);
        week = calendar.get(7);
        return week;
    }
}
