package com.zzsoftware.utils.date;
import java.util.Calendar;

public class CalendarUtils {
//	获取当前时间,此处可能有BUG
	public static Integer getCurrentTime() {
		Calendar cal = Calendar.getInstance();
		String y = String.valueOf(cal.get(Calendar.YEAR)) ;
		System.out.println( Calendar.MONTH );
		String m = String.valueOf (cal.get(Calendar.MONTH)+1);
		String d =  String.valueOf (cal.get(Calendar.DATE));
//		int h = cal.get(Calendar.HOUR_OF_DAY);
//		int mi = cal.get(Calendar.MINUTE);
//		int s = cal.get(Calendar.SECOND);
		return Integer.valueOf( y+m+d);

	}
	
}
