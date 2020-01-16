package for_while_dowhile;
//A~Z 중 무작위로 100개를 출력하시오.

public class ForTest_Random {
	public static void main(String[] args) {
		int randomNumber;
		int count = 0;
		for (int i = 1; i < 101; i++) {
			randomNumber = (int) (Math.random() * ('Z' - 'A' + 1) + 'A');
			System.out.printf("%s ", (char) randomNumber);
			if(i%10==0) System.out.println();
			if(randomNumber == 'A') count++;
		}
		System.out.printf("A는 %d개입니다.", count);
	}
}
