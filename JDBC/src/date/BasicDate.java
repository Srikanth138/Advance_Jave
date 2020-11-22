package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class BasicDate {

	public static void main(String[] args) {
		/*simple date convert to util date we use the -> sdf.parse(sc.next());  eg:-int a=d1.charAt(0);
		 * 
		*/
		try {
		java.util.Date d=new java.util.Date();
		System.out.println("CURRENT DATE :: "+d);
		
		String d1="19-11-1996";
		SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date ud1=sdf.parse(d1);
		System.out.println("UTIL DATE::"+ud1);
		
		//converting java.util.Date class obj to java.sql.Date class obj
		
		long ms=ud1.getTime(); //gives no.of millisecondsthat are elasped b/w jan 1st 1970 midnight 00:00 hours(epoch standard) and ud1 obj's date,time 
		System.out.println("MILLI SECONDS:"+ms);
	
		java.sql.Date sd1=new java.sql.Date(ms);
		System.out.println("sql date1::"+sd1);
		
//		if string date value pattern is yyyy-mm-dd then it can be converted directly to java.util.Date class obj with out converting to java.util.Date class object.
		String d2="1995-11-30"; //convert valueOf() method
		java.sql.Date sd2=java.sql.Date.valueOf(d2);
		System.out.println("sql date2::"+sd2);
		
		SimpleDateFormat sdf2=new SimpleDateFormat("dd-MM-yyyy");
		String d3=sdf2.format(sd2);
		System.out.println("String date value ::"+d3);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
