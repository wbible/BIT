package abstract_1;

import java.util.Calendar;
import java.util.Scanner;

class CalendarTest{
	private int year, month, start, end;
	StringBuffer sb = new StringBuffer();
	
	public CalendarTest() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("년도 입력 : ");
		year = scanner.nextInt();
		System.out.print("월 입력 : ");
		month = scanner.nextInt() - 1;
		scanner.close();
	}
	
	public void calculator() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, 1);
		start = calendar.get(Calendar.DAY_OF_WEEK);
		end = calendar.getActualMaximum(Calendar.DATE) + start;
		
		for(int i = 1; i < end; i++) {
			if(i>=start) {
				sb.append(String.format("%2d",i-start +1));
				if(i % 7 == 0) sb.append("\n");
				else sb.append("\t");
			}else sb.append("\t");
		}
		calendar.add(Calendar.DATE, 31);
		System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
	}
	
	public void display() {
		System.out.println("--------------------------------------------------");
		System.out.println("일	월	화	수	목	금	토");
		System.out.println("--------------------------------------------------");
		System.out.println(sb.toString());
	}
}

//-------------------------
public class CanlendarMain { // 숙제
	public static void main(String[] args) {
		CalendarTest ct = new CalendarTest();
		ct.calculator();
		ct.display();
	}
}
