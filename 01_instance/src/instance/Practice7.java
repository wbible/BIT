package instance;

public class Practice7 {
	public static void main(String[] args) {
		String name = "홍길동";
		char gender = 'M';
		p(name, gender);
		
		gender = 'F';
		p(name, gender);
	}
	
	public static void p(String name, char gender) {
		String genderStr = gender == 'M' ? "남자": "여자";
		System.out.printf("%s은 %s이다.\n", name, genderStr);
	}
}
