package class_2;


import static java.lang.Math.*;
import static java.lang.String.format;
import static java.lang.System.out;


public class ImportStatic {
	public static void main(String[] args) {
		out.println("���� = " + random());
		out.println("����  = " + pow(2, 5));
		out.println("�Ҽ� ���� 2° �ڸ� = " + format("%.2f", 12.34567));
	}
}
