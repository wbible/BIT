package instance;

/* ����: 320, 258�� ������ �����Ͽ� ���� ���Ͻÿ�. 
 * [������]
 * 320 + 258 = xxx
 * 320 - 258 = xxx
 * 320 * 258 = xxx
 * 320 / 258 = 1.24~~
 */
public class NumberTest {
	public static void main(String[] args) {
		int num1 = 320;
		int num2 = 258;

		int sum = num1 + num2;
		int sub = num1 - num2;
		int mul = num1 * num2;
		double div = (double) num1 / num2;

		System.out.println("[���� ���]");
		System.out.printf("%d + %d = %d\n", num1, num2, sum);
		System.out.printf("%d - %d = %d\n", num1, num2, sub);
		System.out.printf("%d * %d = %d\n", num1, num2, mul);
		System.out.printf("%d / %d = %f\n", num1, num2, div);

		System.out.printf("%d / %d = %.2f\n", num1, num2, div);

	}
}
