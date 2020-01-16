package if_switch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SwitchTest {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("a값 입력 : ");
		int month = Integer.parseInt(br.readLine());
		int days = 1;

		switch (month) {
		case 2:
			days = 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			days = 30;
			break;
		default:
			days = 31;
		}
		
		System.out.println(month + "월은  "+days + "일입니다.");
	}
}
