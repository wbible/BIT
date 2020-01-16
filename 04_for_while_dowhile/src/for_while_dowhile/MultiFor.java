package for_while_dowhile;

public class MultiFor {
	public static void main(String[] args) {

		for (int dan = 2; dan < 10; dan++) {
			for (int i = 1; i < 10; i++) {
				System.out.printf("%d*%d=%d\n", dan, i, dan*i);
			}
			System.out.println();
		}
	}
}
