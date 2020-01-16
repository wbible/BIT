package for_while_dowhile;

public class ForTest_LCM {
	public static void main(String[] args) {
		
		int randomNumber;
		int sum = 0;
		int count = 0;
		
		for(int i = 0; i < 500; i++) {
			randomNumber = (int) (Math.random() * 500 + 1);
			if (randomNumber % 6 == 0) {
				System.out.printf("%5d", randomNumber);
				count++;
				sum += randomNumber;
				if (count % 8 == 0) System.out.println();
			}
			
		}
		System.out.println();
		System.out.println("2와 3의 공배수 개수 = " + count);
		System.out.println("2와 3의 공배수 합 = " + sum);
	}
}
