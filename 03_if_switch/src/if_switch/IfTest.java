package if_switch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IfTest {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("a : ");
		int a = Integer.parseInt(br.readLine());
		if (a >= 50)
			System.out.println(a + "�� 50���� ũ�ų� ����.");
		else
			System.out.println(a + "�� 50���� �۴�.");
		System.out.println();

		if (false) // C
			if (true)
				System.out.println("A");
			else
				System.out.println("B");
		System.out.println("C");
		System.out.println();

		// a�� Ȧ���̸�
		if (a % 2 == 1)
			System.out.println(a + "��(��) Ȧ��");
		else
			System.out.println(a + "��(��) ¦��");
		
		System.out.print("ASCII '" + a + "'�� ");
		if(a>='A' && a <= 'Z') System.out.println("�빮�� " + (char)a);
		else if (a>= 'a' && a<='z') System.out.println("�ҹ��� " + (char)a);
		else System.out.println((char)a+"�� �����̰ų� Ư������");
	}
}
