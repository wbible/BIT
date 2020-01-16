package if_switch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IfTest {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("a : ");
		int a = Integer.parseInt(br.readLine());
		if (a >= 50)
			System.out.println(a + "는 50보다 크거나 같다.");
		else
			System.out.println(a + "는 50보다 작다.");
		System.out.println();

		if (false) // C
			if (true)
				System.out.println("A");
			else
				System.out.println("B");
		System.out.println("C");
		System.out.println();

		// a가 홀수이면
		if (a % 2 == 1)
			System.out.println(a + "은(는) 홀수");
		else
			System.out.println(a + "은(는) 짝수");
		
		System.out.print("ASCII '" + a + "'는 ");
		if(a>='A' && a <= 'Z') System.out.println("대문자 " + (char)a);
		else if (a>= 'a' && a<='z') System.out.println("소문자 " + (char)a);
		else System.out.println((char)a+"는 숫자이거나 특수문자");
	}
}
