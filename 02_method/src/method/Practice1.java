package method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 정수(dec)를 입력받아서 2진수(binary), 8진수(octor), 16진수(hexa) 변환하시오
 * Integer클래스 메소드를 이용하시오
 * 
 * [실행결과]
 * 10진수를 입력하세요 : 250
 * 2진수 = 11111010
 * 8진수 = 372
 * 16진수 = fa
 */
public class Practice1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("10진수를 입력하세요 : ");
		int num = Integer.parseInt(br.readLine());
		
		System.out.println("2진수 = " + Integer.toBinaryString(num));
		System.out.println("8진수 = " + Integer.toOctalString(num));
		System.out.println("16진수 = " + Integer.toHexString(num));
		
		// System.out.println("2진수 = " + Integer.toString(num, 2));
		// System.out.println("8진수 = " + Integer.toString(num, 8));
		// System.out.println("16진수 = " + Integer.toString(num, 16));
		
	}
}
