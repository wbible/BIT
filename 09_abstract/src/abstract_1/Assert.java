package abstract_1;

import java.util.Scanner;

public class Assert {
	private int x, y;
	
	public static void main(String[] args) {
		Assert as = new Assert();
		as.input();
		as.output();

	}
	
	public void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("x�� �Է� : ");
		x = scanner.nextInt();
		System.out.print("y�� �Է� : ");
		y = scanner.nextInt();
		scanner.close();
	}
	
	public void output() {
		assert y >= 0 : "y�� 0���� ũ�ų� ���ƾ� �Ѵ�";
		
		int result = 1;
		for(int i = 0; i < y; i++) {
			result *= x;
		}
		System.out.printf("%d�� %d���� %d", x, y, result);
	}

}
