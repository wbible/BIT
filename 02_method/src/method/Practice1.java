package method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ����(dec)�� �Է¹޾Ƽ� 2����(binary), 8����(octor), 16����(hexa) ��ȯ�Ͻÿ�
 * IntegerŬ���� �޼ҵ带 �̿��Ͻÿ�
 * 
 * [������]
 * 10������ �Է��ϼ��� : 250
 * 2���� = 11111010
 * 8���� = 372
 * 16���� = fa
 */
public class Practice1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("10������ �Է��ϼ��� : ");
		int num = Integer.parseInt(br.readLine());
		
		System.out.println("2���� = " + Integer.toBinaryString(num));
		System.out.println("8���� = " + Integer.toOctalString(num));
		System.out.println("16���� = " + Integer.toHexString(num));
		
		// System.out.println("2���� = " + Integer.toString(num, 2));
		// System.out.println("8���� = " + Integer.toString(num, 8));
		// System.out.println("16���� = " + Integer.toString(num, 16));
		
	}
}
