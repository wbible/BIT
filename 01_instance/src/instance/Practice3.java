package instance;

public class Practice3 {
	public final static double TAX_RATE = 0.033; 
	
	public static void main(String[] args) {
		String name = "L";
		int basePay = 2500000;
		int tax = (int) (basePay * TAX_RATE);
		int salary = basePay - tax;
		
		System.out.printf("*** %s�� ���� ***\n", name);
		System.out.printf("�⺻��: \t%d��\n", basePay);
		System.out.printf("����: \t%d��\n", tax);
		System.out.printf("����: \t%d��\n", salary);
	}
}
