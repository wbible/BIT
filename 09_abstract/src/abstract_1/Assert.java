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
		System.out.print("x값 입력 : ");
		x = scanner.nextInt();
		System.out.print("y값 입력 : ");
		y = scanner.nextInt();
		scanner.close();
	}
	
	public void output() {
		assert y >= 0 : "y는 0보다 크거나 같아야 한다";
		
		int result = 1;
		for(int i = 0; i < y; i++) {
			result *= x;
		}
		System.out.printf("%d의 %d승은 %d", x, y, result);
	}

}
