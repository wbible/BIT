package for_while_dowhile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ForTest_gugudan {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("���ϴ� ���� �Է� : ");
		int dan = Integer.parseInt(br.readLine());
		int i;
		
		for (i=1;i<10;i++) {
			System.out.printf("%d*%d=%d\n", dan, i, dan*i);
		}
	}
}
