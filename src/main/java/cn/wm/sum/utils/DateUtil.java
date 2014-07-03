package cn.wm.sum.utils;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class DateUtil
{
	/**
	 * wsm 将日期转化为string格式
	 * @param time 
	 * @return
	 */
    public static String getDateF(Date time){
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");
    	try{
    	   return sdf.format(time);
    	}catch (Exception e) {
    		e.printStackTrace();
    		return null;
		}
    }
	
	/**
	 * @author 获取日期
	 * @param days
	 *           几天前
	 * @return Map<String,String> 现在和几天前
	 */
	public static Map<String, String> getBeforeDateAndNow(Integer days)
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmm");
		Map<String, String> dates = new HashMap<String, String>();
		dates.put("now", format.format(new Date()));
		dates.put("ago", format.format(getBeforeDate(days)));
		return dates;
	}
	
	
	
	public static String getBeforeHour(Integer hours)
	{
		Date date = null;
		Long curr = System.currentTimeMillis();
		Long before = curr - hours * DateUtil.getHourInMillis();
		date = new Date(before);
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmm");
		String time = format.format(date);
		return time;
	}
	/**
	 * 
	 * 作者:wsm 时间:5:13:10 PMApr 1, 2013
	 * 方法描述:
	 * @version
	 */
	public static Long getHourInMillis()
	{
		Calendar cal = Calendar.getInstance();
		Long now = cal.getTimeInMillis();
		cal.add(Calendar.HOUR, 1);
		Long tom = cal.getTimeInMillis();
		return (tom - now);
	}
	/**
	 * 
	 * 作者:wsm 时间:5:14:33 PMApr 1, 2013
	 * 方法描述:获取一分钟有几毫秒
	 * @version
	 */
	public static Long getMinuteInMillis()
	{
		Calendar cal = Calendar.getInstance();
		Long now = cal.getTimeInMillis();
		cal.add(Calendar.MINUTE, 1);
		Long tom = cal.getTimeInMillis();
		return (tom - now);
	}
	/**
	 * 
	 * 作者:wsm 时间:5:16:03 PMApr 1, 2013
	 * 方法描述: 获取30分钟后的date 
	 * @version
	 */
	public static Date getAfterDate()
	{
		Date date = null;
		Long curr = System.currentTimeMillis();
		Long after = curr + 30 * DateUtil.getMinuteInMillis();
		date = new Date(after);
		return date;
	}
	
	public static Date getBeforeDate(Integer days)
	{
		Date date = null;
		Long curr = System.currentTimeMillis();
		Long before = curr - days * DateUtil.getDayInMillis();
		date = new Date(before);
		return date;
	}
	
	/**
	 * 取得一天的毫秒数
	 * 
	 * @return 毫秒数
	 */
	public static Long getDayInMillis()
	{
		Calendar cal = Calendar.getInstance();
		Long now = cal.getTimeInMillis();
		cal.add(Calendar.DATE, 1);
		Long tom = cal.getTimeInMillis();
		return (tom - now);
	}
	
	public static long before(Date before, Date after)
	{
		long beforeTime = before.getTime();
		long afterTime = after.getTime();
		return (beforeTime - afterTime);
	}
	
	/**
	 * 格式化具体时间
	 * 
	 * @param pattern
	 * @param date
	 * @return
	 */
	public static String formate(String pattern, Date date)
	{
		return DateUtil.getSimpleDateFormat(pattern).format(date);
	}
	
	/**
	 * 获得格式化的实例
	 * 
	 * @param pattern
	 * @return
	 */
	public static SimpleDateFormat getSimpleDateFormat(String pattern)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf;
	}
	
	/**
    * 
    * @param date
    * @return
    */
   public static String getDateh(Date date) {
   	return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(date);
   }
	
	/**
	 * 转换时间
	 * 
	 * @param source
	 *           时间字符串
	 * @param pattern
	 *           匹配模式
	 * @return
	 * @throws ParseException
	 */
	public static Date parseTime(String source, String pattern) throws ParseException
	{
		SimpleDateFormat sdf = DateUtil.getSimpleDateFormat(pattern);
		return sdf.parse(source);
	}

	/**
	 * @intention 时间验证
	 * @author zhengry	
	 * @email zhengry@soqi.cn
	 * @createDate Oct 17, 2011
	 * @return
	 */
	public static boolean verificationTime()
	{
		Calendar cal = Calendar.getInstance();
		//获取今天星期几
		int week = cal.get(Calendar.DAY_OF_WEEK) - 1;
		Date curDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
		long lDate = Long.valueOf(sdf.format(curDate));
		//周末 或 不是8点至17点间
		if(week == 0 || week == 6 || lDate < 80000 || lDate > 170000)
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	
	
	/**
	* 方法名称:      formatInNews  
	* 方法描述:      新闻日期格式转换
	* @param date
	* @return
	* @throws ParseException        
	* @Author:      linch
	* @Create Date: 2011-10-29 上午11:21:04
	*/ 
	 
	public static String formatInNews(Date date) throws ParseException
	{
		String dateStr=formate("yyyyMMdd", date);
		String today=formate("yyyyMMdd", new Date());
		String yesterday=formate("yyyyMMdd",getBeforeDate(1));
		if(today.equals(dateStr)){
			return "今日";
		}
		else if(yesterday.equals(dateStr)){
			return "昨日";
		}
		else{
			return formate("dd", date)+"日";
		}
		
	}
	/**
	 * 获取本周一
	 * @return String
	 * @author luis
	 */
	public static String getMonday(){
		Calendar calendar = new GregorianCalendar();
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return formate("yyyy-MM-dd",calendar.getTime());
	}
	
	
	/**
	 * 用于返回指定日期格式的日期增加指定天数的日期
	 * @author zhengry
	 * @param appDate
	 *           指定日期
	 * @param format
	 *           指定日期格式
	 * @param days
	 *           指定天数
	 * @return 指定日期格式的日期增加指定天数的日期
	 */
	public static String getFutureDay(Date date, String format, int days)
	{
		String future = "";
		try
		{
			Calendar calendar = GregorianCalendar.getInstance();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
			calendar.setTime(date);
			calendar.add(Calendar.DATE, days);
			date = calendar.getTime();
			future = simpleDateFormat.format(date);
		} catch (Exception e)
		{

		}

		return future;
	}
	
	public static Timestamp getFutureTimestamp(Date date, String format, int days)
	{
		Timestamp future = null;
		try
		{
			Calendar calendar = GregorianCalendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.DATE, days);
			date = calendar.getTime();
			future = new Timestamp(date.getTime());
		} catch (Exception e){

		}
		return future;
	}
}
