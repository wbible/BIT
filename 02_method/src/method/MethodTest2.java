package method;

public class MethodTest2 {
	public static void disp() { // method ����
		System.out.println("static method");
	}

	public void output() {
		System.out.println("non-static method");
	}

	public static void main(String[] args) {
		disp();
		// new MethodTest2().output();
		MethodTest2 aa = new MethodTest2();
		aa.output();
		
		System.out.println("aa = " + aa); // ��Ű����.Ŭ������@16����
		System.out.println("aa = " + aa.toString());
		System.out.println("aa = " + aa.hashCode()); // �ּҰ��� 10������
		System.out.println("aa = " + aa); 
		
		int sum = aa.plus(25, 36);
		System.out.println("25 + 36 = " + sum);
		int sub = aa.minus(25, 36);
		System.out.println("25 - 36 = " + sub);
		int mul = aa.multiply(25, 36);
		System.out.println("25 * 36 = " + mul);
		double div = aa.divide(25, 36);
		System.out.println("25 / 36 = " + div);
	}

	public int plus(int i, int j) {
		return i + j;
	}
	public int minus(int i, int j) {
		return i - j;
	}
	public int multiply(int i, int j) {
		return i * j;
	}
	public double divide(int i, int j) {
		return (double)(i / j);
	}
}
