package abstract_1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Today {
	public static void main(String[] args) throws ParseException {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("y년 MM월 dd일 E요일 HH:mm:ss");
		
		System.out.println("오늘 날짜 : " + simpleDateFormat.format(date));
		System.out.println();
		
		//내 생일 
		SimpleDateFormat input = new SimpleDateFormat("yyyyMMddHHmmss");
		Date birth = input.parse("19910716103515");
		
		System.out.println("내 생일 : " + birth);
		System.out.println("내 생일 : " + simpleDateFormat.format(birth));
		
		// Calendar cal = new Calendar(); // 추상클래스라 직접 생성 불가능
		//Calendar cal = new GregorianCalendar(); // Sub Class 를 이용한 생성
		
		Calendar cal = Calendar.getInstance(); // 메소드를 이용한 생성
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int week = cal.get(Calendar.DAY_OF_WEEK);
		String dayOfWeek= null;
		switch(week) {
		case 1: dayOfWeek = "일요일"; break;
		case 2: dayOfWeek = "월요일"; break;
		case 3: dayOfWeek = "화요일"; break;
		case 4: dayOfWeek = "수요일"; break;
		case 5: dayOfWeek = "목요일"; break;
		case 6: dayOfWeek = "금요일"; break;
		case 7: dayOfWeek = "토요일"; break;
		}
		
		System.out.println("오늘 날짜 : " + year + "년 " + month + "월 " + day + "일 " + dayOfWeek);
		
	}
}
