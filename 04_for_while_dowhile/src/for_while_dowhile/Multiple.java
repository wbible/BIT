package for_while_dowhile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Multiple {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num;
		
		while(true) {
			System.out.print("숫자 입력 : ");
			num = Integer.parseInt(br.readLine());
			
			if (num < 0) {
				System.out.println("양의 정수만 입력 가능합니다. 다시 입력해주세요.");
				continue;
			}else if(num == 0) break;
			
			for(int i = 1; i < 8; i++) {
				System.out.print(num*i + " ");
			}
			System.out.println();
		}
		System.out.println("프로그램 종료");
		
	
		
		
		
		
	}
}
