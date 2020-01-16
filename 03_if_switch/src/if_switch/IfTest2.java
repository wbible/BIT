package if_switch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 3개의 숫자(a, b, c)를 입력받아서 순서대로 출력하시오
public class IfTest2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		IfTest2 ifTest = new IfTest2();

		System.out.print("a값 입력 : ");
		int a = Integer.parseInt(br.readLine());

		System.out.print("b값 입력 : ");
		int b = Integer.parseInt(br.readLine());

		System.out.print("c값 입력 : ");
		int c = Integer.parseInt(br.readLine());

//		if (a > b && a > c) // a가 가장 크다면
//			if (b > c)
//				System.out.println(c + "\t" + b + "\t" + a);
//			else
//				System.out.println(b + "\t" + c + "\t" + a);
//		else if (b > a && b > c) // b가 가장 크다면
//			if (a > c)
//				System.out.println(c + "\t" + a + "\t" + b);
//			else
//				System.out.println(a + "\t" + c + "\t" + b);
//		else // c가 가장 크다면
//		if (a > b)
//			System.out.println(b + "\t" + a + "\t" + c);
//		else
//			System.out.println(a + "\t" + c + "\t" + c);

		// a가 가장 작다면
		if (a < b && a < c) {
			ifTest.sort(a, b, c);
		} else if (b < a && b < c) {// b가 가장 작다면
			ifTest.sort(b, a, c);
		} else {// c가 가장 작다면
			ifTest.sort(c, a, b);
		}

	}

	public void sort(int min, int a, int b) {
		// 가장 작은 값을 min 인수로 받고 그 다음으로 크기를 비교할 두 수를 a, b 인수로 받아 작은 수부터 출력
		System.out.println(a < b ? min + "\t" + a + "\t" + b : min + "\t" + b + "\t" + a);
	}
}
