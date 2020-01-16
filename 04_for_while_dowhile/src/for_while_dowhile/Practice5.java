package for_while_dowhile;
//중간고사, 기말고사, 레포트, 출석점수를 입력받아서 계산하시오
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice5 {
	public static void main(String[] args) throws IOException {
		// 변수와 instance 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Practice5 p = new Practice5(); // -> 메소드를 실행하기 위한 클래스 instance
		int mid, fin, report, attendance;
		String eval;
		
		System.out.print("중간고사를 입력하시오 : ");
		mid = p.getNumber(br);
		System.out.print("기말고사를 입력하시오 : ");
		fin = p.getNumber(br);
		System.out.print("과제점수를 입력하시오 : ");
		report = p.getNumber(br);
		System.out.print("출석점수를 입력하시오 : ");
		attendance = p.getNumber(br);
		
		double total = (mid+fin)/2.0 * 0.6 + report *0.2 + attendance * 0.2;
		if(p.getScore(total) <= 'B' ) {
			eval = "excellent";
		}else if(p.getScore(total) <= 'D' ) {
			eval = "good";
		}else {
			eval = "poor";
		}
		
		System.out.printf("성적=%.2f\n", total);
		System.out.println("학점=" + p.getScore(total));
		System.out.println("평가="+eval);
		
	}
	
	public int getNumber(BufferedReader br) throws IOException {
		String tmp = br.readLine();
		// 숫자가 아닌 값이 입력된 경우 에러 메시지를 출력하고 프로그램 재실행
		while(tmp.split("[!0-9]").length > 0 || Integer.parseInt(tmp) > 100) {
			System.out.println("입력값이 잘못되었습니다. 다시 입력해주세요.");
			tmp = br.readLine();
		}
		// 숫자만 입력된 경우 그 값을 int 형으로 반환
		return Integer.parseInt(tmp);
	}
	
	public char getScore(double total) {
		// 조건 2 - if
		if(total >= 90) {
			return 'A';
		}else if (total >= 80) {
			return 'B';
		}else if (total >= 70) {
			return 'C';
		}else if (total >= 60) {
			return 'D';
		}
		return 'F';
	}
}
