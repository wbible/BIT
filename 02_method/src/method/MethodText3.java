package method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MethodText3 {

	public static void main(String[] args) throws IOException {
		// 이름, 국어, 영어, 수학을 입력 받아서 총점, 평균을 구하시오.
		// *** 참고 - BufferedReader, InputStreamReader(키보드를 통해 들어오는 데이터타입은 InputStream),
		// FileReader
		// *** 참고 - Exception(예외처리): 컴파일, 실행
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		/*
		 * System.out.print("문자열을 입력해주세요: "); String str = br.readLine();
		 * System.out.println(str);
		 * 
		 * System.out.print("정수를 입력해주세요: "); int num1 = Integer.parseInt(br.readLine());
		 * System.out.println(num1);
		 * 
		 * System.out.print("실수를 입력해주세요: "); double num2 =
		 * Double.parseDouble(br.readLine()); System.out.println(num2);
		 */

		// 클래스 내부 메소드를 사용하기 위해 객체 생성
		MethodText3 c = new MethodText3();

		// 사용자로부터 이름을 입력 받아 name 변수에 저장
		System.out.print("이름을 입력해주세요: ");
		String name = br.readLine();

		// 사용자로부터 각 과목별 점수를 입력 받아 score 배열에 저장
		// --> 문자로 시작되는 값이 입력된 경우 오류 메시지 출력 후 다시 입력을 받는다.
		String subject[] = { "국어", "영어", "수학" };
		int score[] = new int[subject.length];
		for (int i = 0; i < subject.length; i++) {
			score[i] = -1;
			while(score[i] == -1) {
				System.out.printf("%s 점수를 입력해주세요: ", subject[i]);
				// score[i] = Integer.parseInt(br.readLine());
				score[i] = c.getInt((br.readLine()));
				if (score[i] < 0 || score[i] > 100) {
					System.out.println("입력값이 잘못되었습니다.");
					score[i] = -1;
				}
			}
		}

		// 화면에 출력
		System.out.printf("*** %s 성적표 ***\n국어\t영어\t수학\t총점\t평균\n", name);
		System.out.printf("%d\t%d\t%d\t%d\t%.2f\n", score[0], score[1], score[2], c.calcTot(score), c.calcAvg(score));

	}

	public int calcTot(int list[]) { // 총점을 계산
		int sum = 0;
		for (int i = 0; i < list.length; i++) {
			sum += list[i];
		}
		return sum;
	}

	public double calcAvg(int[] list) { // 평균 점수 계산
		int sum = calcTot(list);
		return (double) (sum / list.length);
	}

	public int getInt(String str) {
		String tmp = "";
		for (int i = 0; i < str.length(); i++) {
			tmp = tmp + ((str.charAt(i) >= '0' && str.charAt(i) <= '9') || str.charAt(i) == '.' ? Character.toString(str.charAt(i)): "");
		}
		return tmp.length() > 0 ? (int) Double.parseDouble(tmp) : -1;
	}

}
