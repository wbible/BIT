package if_switch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 3���� ����(a, b, c)�� �Է¹޾Ƽ� ������� ����Ͻÿ�
public class IfTest2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		IfTest2 ifTest = new IfTest2();

		System.out.print("a�� �Է� : ");
		int a = Integer.parseInt(br.readLine());

		System.out.print("b�� �Է� : ");
		int b = Integer.parseInt(br.readLine());

		System.out.print("c�� �Է� : ");
		int c = Integer.parseInt(br.readLine());

//		if (a > b && a > c) // a�� ���� ũ�ٸ�
//			if (b > c)
//				System.out.println(c + "\t" + b + "\t" + a);
//			else
//				System.out.println(b + "\t" + c + "\t" + a);
//		else if (b > a && b > c) // b�� ���� ũ�ٸ�
//			if (a > c)
//				System.out.println(c + "\t" + a + "\t" + b);
//			else
//				System.out.println(a + "\t" + c + "\t" + b);
//		else // c�� ���� ũ�ٸ�
//		if (a > b)
//			System.out.println(b + "\t" + a + "\t" + c);
//		else
//			System.out.println(a + "\t" + c + "\t" + c);

		// a�� ���� �۴ٸ�
		if (a < b && a < c) {
			ifTest.sort(a, b, c);
		} else if (b < a && b < c) {// b�� ���� �۴ٸ�
			ifTest.sort(b, a, c);
		} else {// c�� ���� �۴ٸ�
			ifTest.sort(c, a, b);
		}

	}

	public void sort(int min, int a, int b) {
		// ���� ���� ���� min �μ��� �ް� �� �������� ũ�⸦ ���� �� ���� a, b �μ��� �޾� ���� ������ ���
		System.out.println(a < b ? min + "\t" + a + "\t" + b : min + "\t" + b + "\t" + a);
	}
}
