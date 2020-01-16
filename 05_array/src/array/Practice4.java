package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 야구게임
public class Practice4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] answer, user;
		String input;
		int strike, ball;
		
		while (true) {
			System.out.print("게임을 실행하시겠습니까?(Y/N) : ");
			input = br.readLine();
			if(input.equalsIgnoreCase("n")) break;
			else if(input.equalsIgnoreCase("y")){
			}else {
				System.out.println("Y 또는 N만 입력 가능합니다.");
				continue;
			}
			
			// 변수 초기화 
			System.out.println("게임을 시작합니다.");
			answer = new int[3];
			user = new int[3];
			strike = ball = 0;
			
			for (int i = 0; i < 3; i++) {
				answer[i] = (int) (Math.random() * 10);
				for (int j = 0; j < i; j++) {
					if(answer[i] == answer[j]) {i--; break;}
				}
			} 
			
			GET: while(strike < 3) {
				// 입력 및 입력값 유효성 확인
				System.out.print("숫자 입력 : ");
				input = br.readLine();
				if (input.split("[!0-9]").length != 0 || input.length() !=3) {
					System.out.println("입력값이 올바르지 않습니다. 다시 입력해주세요.");
					continue;
				}
				for (int i = 0; i < input.length(); i++) {
					user[i] = input.charAt(i) - '0';
					for(int j = 0; j < i; j++) {
						if(user[i] == user[j]) {
							System.out.println("중복된 값이 있습니다. 다시 입력해주세요.");
							continue GET;
						}
					}
				}
//				for(int n:answer)System.out.print(n);
//				System.out.println();
				
				// 결과 확인
				strike = 0;
				ball = 0;
				for (int i = 0; i < user.length; i++) {
					for (int j = 0; j < answer.length; j++) {
						if (user[i] == answer[j] && i == j) {strike++;}
						else if (user[i] == answer[j]) {ball++;}
					}
				}
				System.out.printf("%d스트라이크 %d볼\n", strike, ball);
			}
			System.out.println("정답입니다!");
			
		}
		
		
		
	}
}
