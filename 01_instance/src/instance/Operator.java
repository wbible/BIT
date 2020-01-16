package instance;

public class Operator {
	public static void main(String[] args) {
		int a = 5;
		a += 2;
		a *= 3;
		System.out.println("a = " + a); // 21

		a++;
		System.out.println("a = " + a); // 22
		
		int b = a++; // 22
		System.out.println("a = " + a + "\t b = " + b); // a = 24, b = 21, c = 2
		
		int c = ++a - b--;
		System.out.println(c);
		
		
	}
}
