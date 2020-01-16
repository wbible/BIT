package instance;

public class Practice3 {
	public final static double TAX_RATE = 0.033; 
	
	public static void main(String[] args) {
		String name = "L";
		int basePay = 2500000;
		int tax = (int) (basePay * TAX_RATE);
		int salary = basePay - tax;
		
		System.out.printf("*** %s의 월급 ***\n", name);
		System.out.printf("기본급: \t%d원\n", basePay);
		System.out.printf("세금: \t%d원\n", tax);
		System.out.printf("월급: \t%d원\n", salary);
	}
}
