package db.hotel.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;

public final class Util {

	public static String HashPassword(String p){
		return DigestUtils.sha1Hex(p);
	}
	
	public static Date toDate(String d) throws ParseException{
		return new SimpleDateFormat("d/M/yyyy").parse(d);
	}
	
	public static Date toDate(String d, String fmt) throws ParseException{
		return new SimpleDateFormat(fmt).parse(d);
	}
	
	public static String toString(Date d) throws ParseException{
		return DateFormat.getDateInstance().format(d);
	}
}
