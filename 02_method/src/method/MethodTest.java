package method;

public class MethodTest {
	public static void main(String[] args) {
		int big = Math.max(25, 36);
		System.out.println("ū �� = " + big);

		int small = Math.min(25, 36);
		System.out.println("���� �� = " + small);

		int power = (int) Math.pow(2, 5);
		System.out.println("2�� 5������ " + power);

		int a = (int) (Math.random() * ('Z' - 'A' + 1)) + 'A'; // 65 ~ 90
		System.out.println((char) a);
		System.out.println(Integer.parseInt("2") - 48);
		
		System.out.println(Integer.parseInt("2") + Double.parseDouble("5.7"));
	}
}
