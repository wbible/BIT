package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//10진수를 입력하여 2진수로 변환하시오
//0이 입력되면 프로그램을 종료하세요
//음수가 입력되면 재입력하세요
//4개씩 끊어서 보여주기
//Integer.toBinaryString() 쓰지마삼
public class Practice2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputString;
		int input;
		int count, count2;
		int[] binary; 

		while(true) {
			count = count2 = 0;
			binary = new int[32];
			
			System.out.print("10진수 입력 : ");
			inputString = br.readLine();
			if (inputString.split("[!0-9]").length != 0) System.out.println("양의 정수만 입력 가능합니다. 다시 입력해주세요.");
			else if (inputString.equals("0")) break;
			input = Integer.parseInt(inputString);
			
			while(input > 0) {
				binary[count++] = input % 2 ;
				input /= 2;
			}
			
			for (int i = count-1; i >= 0; i--) {
				System.out.print(binary[i]);
				count2++;
				if (count2 % 4 == 0) System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println("프로그램을 종료합니다.");
	}
	
}
