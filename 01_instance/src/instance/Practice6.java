package instance;

public class Practice6 {
	public static void main(String[] args) {
		char ch = 'a';
		changeCase(ch);
		ch = 'e';
		changeCase(ch);

	}

	public static void changeCase(char ch) {
		char changedCh = (char) (ch >= 'A' && ch <= 'Z' ? ch + 32 : ch - 32);
		System.out.printf("%s -> %s\n", ch, changedCh);
	}
}
