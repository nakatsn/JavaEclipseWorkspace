package nntest.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import net.sourceforge.sizeof.SizeOf;

public class NNUtil {
	static {
		SizeOf.skipFinalField(false);
		SizeOf.skipStaticField(true);
		SizeOf.setMinSizeToLog(0);
	}
	public static long getObjectSize(Object obj) {
		long sSize = SizeOf.deepSizeOf(obj);
		return sSize;
	}
	public static void log(String s) {
		System.out.printf("%1$tY/%1$tm/%1$td %1$tH:%1$tM:%1$tS.%1$tL : %2$s%n", new Date(), s);
	}
	public static void log(String strMessage, String... args) {
		
	}
	
	public static long start() {
		String[] strNames = getClassMethodName();
		log(String.format("start[%s][%s]", strNames[0], strNames[1]));
		return System.currentTimeMillis();
	}
	public static void end() {
		String[] strNames = getClassMethodName();
		log(String.format("end[%s][%s]", strNames[0], strNames[1]));
	}
	public static void end(long lngStartTime) {
		String[] strNames = getClassMethodName();
		long lngEndTime = System.currentTimeMillis();
		log(String.format("end[%s][%s]:elapsedtime=%.3f sec", strNames[0], strNames[1], ((double)(lngEndTime - lngStartTime)) / 1000));
	}
	private static String[] getClassMethodName() {
		String[] strs= {"unknown", "unknown" };
		StackTraceElement[] se = Thread.currentThread().getStackTrace();
		if (se.length >= 3) {
			// Because of '3'
			// se[0] : getStackTrace()
			// se[1] : This.getClassMethodName()
			// se[2] : This.start() or This.end()
			// se[3] : Caller Method 
			strs[0] = se[3].getClassName();
			strs[1] = se[3].getMethodName();
		}
		return strs;
	}
}
