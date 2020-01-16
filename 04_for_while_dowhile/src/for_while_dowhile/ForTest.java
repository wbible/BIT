package for_while_dowhile;

public class ForTest {
	public static void main(String[] args) {
		int i;
		for(i = 1 ; i <= 10; i++) {
			System.out.println("hello " +i);
		}
		System.out.println("Å»Ãâ ÈÄ i = " + i);
		
		System.out.println();
		
		for (i = 10; i > 0; i--) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		for(i='A'; i <= 'Z'; i++) {
			System.out.print((char)i + " ");
		}
	}
}
