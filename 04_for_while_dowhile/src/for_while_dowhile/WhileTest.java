package for_while_dowhile;

public class WhileTest {
	public static void main(String[] args) {
		// 1 2 3 4 5 6 7 8 9 10
		int a = 0;
//		while (a < 10) {
//			System.out.print(++a + " ");
//		}
		while (true) {
			System.out.print(++a + " ");
			if (a == 10)
				break;
		}
	}
}
