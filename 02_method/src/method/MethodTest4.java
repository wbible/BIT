package method;

// 이름, 주민번호를 입력 받아 성별을 출력하시오.
// 성별을 구별하는 comp() 메소드와 나이를 계산하는 calcAge() 메소드를 작성하시오.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MethodTest4 {
	public static void main(String[] args) throws IOException {
		// 사용자로부터 입력을 받기 위해 BufferedReader 객체 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 함수를 사용하기 위해 클래스 객체 생성
		MethodTest4 c = new MethodTest4();
		System.out.print("이름을 입력하세요: ");
		String name = br.readLine();
		String id = c.readId(br);

		int age = c.calcAge(id);
		String gender = c.comp(id);
		// age = c.calcAgeByCal(id);
		System.out.printf("%s님은 %s이고 %d살입니다.\n", name, gender, age);

	}

	public String comp(String id) {
		// 주민등록번호를 확인하여 남자이면 true, 여자이면 false를 리턴
		return Integer.parseInt(id.substring(7,8)) % 2 == 1 ? "남자" : "여자";
	}

	public String readId(BufferedReader br) throws IOException {
		// 유효한 값이 입력될 때까지 사용자로부터 주민등록번호를 입력받음
		String id;
		// 정규식을 이용하기 위해 객체 생성
		String pStr = "^[0-9]{6}-[0-9]{7}$";
		Pattern p = Pattern.compile(pStr);
		Matcher m;
		while (true) {
			System.out.print("주민등록번호를 입력하세요(000000-0000000): ");
			id = br.readLine();
			m = p.matcher(id);
			if (!m.find()) {
				// 입력값이 올바르지 않을 경우 경고 메시지 출력
				System.out.println("입력값이 올바르지 않습니다. 다시 입력해주세요.");
			} else {
				// 올바른 값이 입력되면 반복문 탈출하고 결과를 반환
				return id;
			}
		}
	}

	public int calcAge(String id) {
		// 주민등록번호의 처음 두 자리 문자를 getFirstTwo() 메소드로 얻어와서 나이를 계산하여 정수로 리턴
		int thisYear = 2019;
		int year = Integer.parseInt(id.substring(0,2));
		year += Integer.parseInt(id.substring(7,8)) <= 2 ? 1900 : 2000;
		return thisYear - year + 1;
	}

	public int calcAgeByCal(String id) {
		// calcAge() 메소드와 같으나 thisYear 값을 Calendar 클래스를 통해 얻어 와서 계산함
		Calendar cal = Calendar.getInstance();
		int thisYear = cal.get(Calendar.YEAR);
		int year = Integer.parseInt(id.substring(0,2));
		year += Integer.parseInt(id.substring(7,8)) <= 2 ? 1900 : 2000;
		return thisYear - year + 1;
	}
}
