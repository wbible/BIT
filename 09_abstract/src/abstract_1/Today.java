package abstract_1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Today {
	public static void main(String[] args) throws ParseException {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("y�� MM�� dd�� E���� HH:mm:ss");
		
		System.out.println("���� ��¥ : " + simpleDateFormat.format(date));
		System.out.println();
		
		//�� ���� 
		SimpleDateFormat input = new SimpleDateFormat("yyyyMMddHHmmss");
		Date birth = input.parse("19910716103515");
		
		System.out.println("�� ���� : " + birth);
		System.out.println("�� ���� : " + simpleDateFormat.format(birth));
		
		// Calendar cal = new Calendar(); // �߻�Ŭ������ ���� ���� �Ұ���
		//Calendar cal = new GregorianCalendar(); // Sub Class �� �̿��� ����
		
		Calendar cal = Calendar.getInstance(); // �޼ҵ带 �̿��� ����
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int week = cal.get(Calendar.DAY_OF_WEEK);
		String dayOfWeek= null;
		switch(week) {
		case 1: dayOfWeek = "�Ͽ���"; break;
		case 2: dayOfWeek = "������"; break;
		case 3: dayOfWeek = "ȭ����"; break;
		case 4: dayOfWeek = "������"; break;
		case 5: dayOfWeek = "�����"; break;
		case 6: dayOfWeek = "�ݿ���"; break;
		case 7: dayOfWeek = "�����"; break;
		}
		
		System.out.println("���� ��¥ : " + year + "�� " + month + "�� " + day + "�� " + dayOfWeek);
		
	}
}
