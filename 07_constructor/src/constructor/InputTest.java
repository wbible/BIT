package constructor;

import java.util.Scanner;

public class InputTest {
	private int a;
	private double b;
	
	public InputTest() {
		Scanner scan = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		a = scan.nextInt();
		System.out.print("실수 입력 : ");
		b = scan.nextDouble();
		scan.close();
	}
	
	public static void main(String[] args) {
		InputTest it = new InputTest();
		it.display();
		
	}
	
	public void display() {
		System.out.println(a + " + " + b + " = " + (a + b));
	}
}
