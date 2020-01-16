package if_switch;
//a값 입력: 25

//b값 입력: 36

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class SwitchTest2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("a값 입력 : ");
		int a = Integer.parseInt(br.readLine());

		System.out.print("b값 입력 : ");
		int b = Integer.parseInt(br.readLine());

		System.out.print("연산자(+,-*,/) 입력 : ");
		String c = br.readLine();

		switch (c) {
		case "+":
			System.out.printf("%d %s %d = %d", a, c, b, a + b);
			break;
		case "-":
			System.out.printf("%d %s %d = %d", a, c, b, a - b);
		case "*":
			System.out.printf("%d %s %d = %d", a, c, b, a * b);
			break;
		case "/":
			//System.out.printf("%d %s %d = %.3f", a, c, b, (double)a / b);
			DecimalFormat df = new DecimalFormat("#.###");
			System.out.printf("%d %s %d = %s", a, c, b, df.format((double)a / b));
			break;
		default:
			System.out.println("연산자가 잘못 입력되었습니다.");
		}
	}
}
