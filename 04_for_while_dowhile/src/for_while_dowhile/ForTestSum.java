package for_while_dowhile;

//[실행결과]
// -1 + 2 -3 +4 ... = 5
public class ForTestSum {
	public static void main(String[] args) {
		int sum = 0;

		for (int i = 1; i < 11; i++) {
			if(i%2==0) {
				sum += i;
				System.out.print("+" + i);
			}else {
				sum -= i;
				System.out.print("-" + i);
			}
		}
		System.out.println(" = "+sum);
	}
}
