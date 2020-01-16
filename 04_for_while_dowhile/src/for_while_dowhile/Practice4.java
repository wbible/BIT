package for_while_dowhile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//[문제4] 덧셈 공부
//10~99 사이의 난수를 2개(a,b) 발생하여 합을 맞추는 게임
//문제수는 총 5문제를 제공한다
//1문제당 점수 20점씩 계산
//만약 틀리면 기회를 1번 더 제공한다
public class Practice4 {
	public static void main(String[] args) throws IOException {
		// 변수와 instance 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int user, num1, num2, count;
		String tmp;
		Practice4 p = new Practice4(); // -> 메소드를 실행하기 위한 클래스 instance
		
		while(true) {
			count = 0; // 점수 초기화
			for (int i = 1; i < 6; i++) {
				// 난수 발생 및 출력
				num1 = (int) (Math.random() * 90 + 10);
				num2 = (int) (Math.random() * 90 + 10);
				
				System.out.printf("[%d] %d + %d = ", i, num1, num2);
				user = p.getNumber(br);
				if (user == num1 + num2) {
					System.out.println("딩동뎅");
					count++;
				} else {
					System.out.println("틀렸다");
					System.out.printf("[%d] %d + %d = ", i, num1, num2);
					user = p.getNumber(br);
					if (user == num1 + num2) {
						System.out.println("딩동뎅");
						count++;
					} else {
						System.out.printf("틀렸다... 정답: %d\n", num1 + num2);
					}
				} 
			}
			System.out.printf("당신은 총 %d문제를 맞추어서 %d점입니다.\n", count, count * 20);
			
			while(true) {
				System.out.print("continue(y/n) : ");
				tmp = br.readLine();
				if (tmp.equalsIgnoreCase("n") || tmp.equalsIgnoreCase("y")) break;
				System.out.println("Y 또는 N만 입력 가능합니다.");
			}
			if (tmp.equalsIgnoreCase("n")) break;
		}
		System.out.println("프로그램을 종료합니다.");
	}
	
	public int getNumber(BufferedReader br) throws IOException {
		String tmp = br.readLine();
		// 숫자가 아닌 값이 입력된 경우 에러 메시지를 출력하고 프로그램 재실행
		while(tmp.split("[!0-9]").length > 0) {
			System.out.println("양의 정수만 입력 가능합니다. 다시 입력해주세요.");
			tmp = br.readLine();
		}
		// 숫자만 입력된 경우 그 값을 int 형으로 반환
		return Integer.parseInt(tmp);
	}
}
