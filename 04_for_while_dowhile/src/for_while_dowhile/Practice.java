package for_while_dowhile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//가위바위보 게임 - if문
public class Practice {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Practice p = new Practice();
		
		int user;
		int com;
		String tmp;
		
		while (true) {
			System.out.print("가위(1), 바위(2), 보자기(3) 중 번호 입력 : ");
			user = Integer.parseInt(br.readLine());
			com = (int) (Math.random() * 3 + 1);
			// 난수로 생성된 숫자와 유저에게 숫자로 입력받은 값을 문자열로 화면에 보여줌
			System.out.printf("컴퓨터 : %s\t\t나 : %s", p.change(com), p.change(user));
			
			if (user == com) {
				//비겼을 때
				System.out.println("You Draw!!");
			}else if ((user == 1 && com ==3) || (user == 2 && com ==1) || (user == 3 && com ==2)) {
				//유저가 이겼을 때
				System.out.println("You Win!!");
			}else {
				//유저가 졌을 때
				System.out.println("You Lose!!");
			}
			
			while(true) {
				System.out.print("또 할래(Y/N) : ");
				tmp = br.readLine();
				if (tmp.equalsIgnoreCase("n") || tmp.equalsIgnoreCase("y")) break;
				System.out.println("Y 또는 N만 입력 가능합니다.");
			}
			if (tmp.equalsIgnoreCase("n")) break;
			
		}
		System.out.println("프로그램을 종료합니다.");
		
	}
	public String change(int num) {
		//숫자 1~3을 문자열 "가위, 바위, 보자기"로 변경해주는 메소드
		if(num == 1) return "가위";
		else if (num == 2) return "바위";
		else return "보자기";
	}
}
