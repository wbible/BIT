package instance;

public class Practice5 {
	public static void main(String[] args) {
		int score = 25;
		p(score);
		
		score = 12;
		p(score);
	}

	public static boolean common_mul(int num) {
		return num % 2 == 0 && num % 3 == 0 ? true : false;
	}
	
	public static void p(int num) {
		String result = common_mul(num) == true ? "는 2와 3의 공배수이다." : "는 2와 3의 공배수가 아니다.";
		System.out.println(num + result);
	}
}
