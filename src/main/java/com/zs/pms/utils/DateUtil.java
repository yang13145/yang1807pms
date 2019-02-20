package com.zs.pms.utils;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;



/**
 * @author Administrator 时间工具类
 */

public class DateUtil {

	public static String getStrDate(Date date) {
		// 获得日历对象
		Calendar cal = Calendar.getInstance();
		// 获得当前的年
		int y = cal.get(Calendar.YEAR);
		// 获得当前的月(月份从0开始)
		int m = cal.get(Calendar.MONTH) + 1;
		// 获得当前的日
		int d = cal.get(Calendar.DAY_OF_MONTH);
		//小时
		int hh = cal.get(Calendar.HOUR_OF_DAY);
		//通过变量来判断时上午。中午。还是下午
		String str = "";
		if (hh > 6 && hh <= 11) {
			str = "上午好";
		} else if (hh > 11 && hh <= 14) {
			str = "中午好";
		} else if (hh > 14 && hh <= 18) {
			str = "下午好";
		} else if (hh > 18 && hh <= 24) {
			str = "晚上好";
		} else {
			str = "滚去睡";
		}
		return y + "年" + m + "月" + d + "日" + hh + "时"+str;
		
	}

	/**
	 * 字符转Date方法
	 * 
	 * @param time字符串
	 * @param pattern输入字符串的时间格式
	 * @return date的时间
	 * @throws ParseException
	 */
	public static Date getStrToDate(String s, String format)
			throws ParseException {
		// 获得格式化对象
		DateFormat sdf = new SimpleDateFormat(format);

		// 返回格式化好的时间
		return sdf.parse(s);

	}

	/**
	 * Date转String时间的方法
	 * 
	 * @param time
	 *            Date类的时间
	 * @param patten
	 *            把时间格式化是什么样
	 * @return字符串类的时间
	 */
	public static String getDateToStr(Date date) {
		// 获得格式化时间
		DateFormat aformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 返回格式化好的时间
		return aformat.format(date);

	}
}