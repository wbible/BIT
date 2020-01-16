package for_while_dowhile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ForTest_Sosu {
	public static void main(String[] args) throws IOException {
		// 변수와 instance 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int user;
		String tmp; // -> 입력받은 값이 유효한지 확인하기 위한 임시 변수
		ForTest_Sosu p = new ForTest_Sosu(); // -> sosu_check 메소드를 실행하기 위한 클래스 instance
		
		while(true) {
			// 사용자로부터 문자열 입력을 받아 tmp에 저장
			System.out.print("숫자 입력 : ");
			tmp = br.readLine();
			
			// 숫자가 아닌 값이 입력된 경우 에러 메시지를 출력하고 프로그램 재실행
			if (tmp.split("[!0-9]").length > 0) {
				System.out.println("양의 정수만 입력 가능합니다. 다시 입력해주세요.");
				continue;
			}
			// 숫자만 입력된 경우 그 값을 int 형으로 user 변수에 저장
			user = Integer.parseInt(tmp);
			
			// 입력된 값이 0인 경우 반복문을 빠져나감 -> 프로그램 종료
			if(user == 0) break;
			
			// sosu_check 메소드를 통해 입력받은 수가 소수인지 판별
			if(p.sosu_check(user)) {
				System.out.println(user + "은(는) 소수입니다.");
			}else {
				System.out.println(user + "은(는) 소수가 아닙니다.");
			}
		}
		System.out.println("프로그램을 종료합니다.");
	}
	
	// int 인수를 받아서 소수인지 확인하여 소수이면 true를 반환하는 메소드
	public boolean sosu_check(int user) {
		// 1은 소수가 아님
		if(user == 1) return false; 
			
		// 2 이상이 입력된 경우 2부터 입력받은 숫자의 제곱근까지의 수로 나누어 나머지가 0이면 false를 반환 
		for(int i = 2; i<= (int)Math.sqrt(user); i++) 
			if (user % i == 0) return false;
		
		// 나누어 떨어지지 않으면 소수이므로 true를 반환
		return true;
	}
}
