package for_while_dowhile;

public class DoWhileTest {
	public static void main(String[] args) {
		// 1 2 3 4 5 6 7 8 9 10
		int a = 0;
		do {
			System.out.print(++a + " ");
		} while (a < 10);
		System.out.println("\n");
		
		// A~Z���� ����ϵ� 1�ٿ� 7���� ���
		char ch = 'A';
		do {
			System.out.print(ch++ + " ");
			if ((ch - 'A') % 7 == 0)
				System.out.println();
		}while (ch <= 'Z');
	}
}
