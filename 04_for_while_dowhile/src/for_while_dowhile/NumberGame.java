package for_while_dowhile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberGame {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int com = (int)(Math.random() * 100);
		int user = -1;
		int count = 0;
		String yn;
		
		while(com != user) {
			System.out.print("숫자 입력: ");
			user = Integer.parseInt(br.readLine());
			count++;
			if(com == user) { // 사용자가 정답을 맞춘 경우
				System.out.printf("딩동댕 %d번만에 맞추셨습니다.\n", count);
				
				System.out.print("또 할래?(Y/N) : ");
				// 사용자로부터 입력을 받아 게임을 다시 진행할 지 여부를 확인함, 값이 y 또는 n이 아닐 경우 오류 메시지를 출력하고 다시 입력을 받음
				do { 
					yn = br.readLine();
					if(yn.equalsIgnoreCase("y") || yn.equalsIgnoreCase("n")) break;
					System.out.print("Y 또는 N만 입력 가능합니다. 다시 입력해주세요 : ");
				}while(true); 
				
				// 입력된 값이 n 일 경우 프로그램 종료
				if (yn.equalsIgnoreCase("N")) {
					break;
				}else {
					// 입력된 값이 y 일 경우 변수 초기화 및 재시작 
					com = (int)(Math.random() * 100);
					user = -1;
					count = 0;
				}
			}else if (com > user) {
				System.out.println(user + "보다 큽니다.");
			}else  {
				System.out.println(user + "보다 작습니다.");
			}
		}
		System.out.println("프로그램을 종료합니다.");
	}
}
