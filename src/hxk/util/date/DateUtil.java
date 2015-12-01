package hxk.util.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import hxk.util.DateUtils;

/**
 * @author HXK
 * @description
 *2014-1-11  下午3:42:59
 */
public class DateUtil {
    private static final String TIME_END = " 23:59:59";
    private static final String TIME_BEGIN = " 00:00:00";

    private static Date fromStringToDate(String date) throws ParseException{
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	return format.parse(date);
    }
    
    private static String getTodayDateString(){
	return new DateThis().today();
    }
    
    private static String getTomorrow(){
	Calendar cal = Calendar.getInstance();
	cal.add(Calendar.DATE, +1);
	return  new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
    }
    
    public static Date getTodayDateTimeBegin(){
	return DateUtils.parseDateTime(getTodayDateString()+TIME_BEGIN);
    }
    
    public static Date getTodayDateTimeEnd(){
	return DateUtils.parseDateTime(getTodayDateString()+TIME_END);
    }
    
    public static List<Date> getMonthBeginAndEnd() throws ParseException{
	List<Date> dates = new ArrayList<Date>();
	DateThis dt = new DateThis();
	String begin = dt.thisMonth();
	String end = dt.thisMonthEnd();
	dates.add(fromStringToDate(begin));
	dates.add(fromStringToDate(end));
	return dates;
    }
    
    public static List<Date> getNextMonthBeginAndEnd() throws ParseException{
	List<Date> dates = new ArrayList<Date>();
	DateThis dt = new DateThis();
	String begin = dt.nextMonth();
	String end = dt.nextMonthEnd();
	dates.add(fromStringToDate(begin));
	dates.add(fromStringToDate(end));
	return dates;
    }
    
    public static List<Date> getTodayDateBeginAndEnd() throws ParseException{
	List<Date> dates = new ArrayList<Date>();
	dates.add(getTodayDateTimeBegin());
	dates.add(getTodayDateTimeEnd());
	return dates;
    }
    
    public static List<String> getTodayStringBeginAndEnd() throws ParseException{
	List<String> dates = new ArrayList<String>();
	String today = getTodayDateString();
	dates.add((today+TIME_BEGIN));
	dates.add((today+TIME_END));
	return dates;
    }
    
    public static List<String> getTheseTwoDaysStringBeginAndEnd(){
	List<String> dates = new ArrayList<String>();
	String today = getTodayDateString();
	dates.add((today+TIME_BEGIN));
	dates.add(getTomorrow()+TIME_END);
	return dates;
    }
    
    /**
     * @description 比较两个时间的先后..如果第一个时间在前则返回真
     * @param date1
     * @param date2
     * @return
     *2014-2-19  下午5:36:09
     *返回类型:boolean
     */
    public static boolean compare(Date date1 , Date date2){
	return date1.getTime() < date2.getTime();
    }
    
    /**
     * @description 比较该日期与今天0点的先后..如果该日期在先,则返回真	
     * @param date
     * @return
     *2014-2-19  下午5:38:14
     *返回类型:boolean
     */
    public static boolean compare(Date date){
	return compare(date, getTodayDateTimeBegin());
    }
    
    /** @description 根据月份取得一个月有多少天	
     * @param begins
     *2014-3-14  下午12:27:44
     *返回类型:void	
     */
    public static String getDaysOfMonth(String month,String year) {
	int y = Integer.parseInt(month);
	if (y == 1 || y == 3 || y == 5 || y == 7 || y == 8 || y == 10 || y == 12) {
	     return "31";
	}
	if (y == 4 || y == 6 || y == 9 || y == 11) {
	    return "30";
	}
	else {
	    boolean leap = new DateThis().leapYear(Integer.parseInt(year));
	    if (leap) {
		return "29";
	     }
	     else {
		 return  "28";
	     }
	}
    }
}
