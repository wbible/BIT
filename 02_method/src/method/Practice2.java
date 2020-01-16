package method;
/*
 * 주사위를 2번 던져서 나온 값의 합을 구하시오
 * 주사위는 input()에서 1~6사이의 난수를 발생하여 리턴한다
 * 합은 add()에서 구하여 리턴 받는다
 * 
 * [실행결과]
 * 첫번째 주사위 값 : 3
 * 두번째 주사위 값 : 6
 * 합은 9 이다
 */
public class Practice2 {
	public static void main(String[] args) {
		Practice2 c = new Practice2();
		
		int num1 = c.input();
		int num2 = c.input();
		
		System.out.println("첫 번째 주사위 값 : " + num1);
		System.out.println("두 번째 주사위 값 : " + num2);
		System.out.println("합은 " + c.add(num1, num2) + "이다.");
		
	}
	public int input() {
		return (int) (Math.random() * 6) + 1; 
	}
	
	public int add(int a, int b) {
		return a + b;
	}
}
