package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AutoNumberUtil {
	public static long autoID() {
		DateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmss");
		Calendar cal = Calendar.getInstance();
		String a = String.valueOf(dateFormat.format(cal.getTime()));
		long accountNumber = Long.parseLong(a);
		return accountNumber;
	}
	
	public static long autoCardID() {
		DateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmss");
		Calendar cal = Calendar.getInstance();
		String a = String.valueOf(dateFormat.format(cal.getTime()));
		long autoCardID = Long.parseLong(a);
		return autoCardID;
	}
}
