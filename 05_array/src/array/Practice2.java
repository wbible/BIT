package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//10������ �Է��Ͽ� 2������ ��ȯ�Ͻÿ�
//0�� �ԷµǸ� ���α׷��� �����ϼ���
//������ �ԷµǸ� ���Է��ϼ���
//4���� ��� �����ֱ�
//Integer.toBinaryString() ��������
public class Practice2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputString;
		int input;
		int count, count2;
		int[] binary; 

		while(true) {
			count = count2 = 0;
			binary = new int[32];
			
			System.out.print("10���� �Է� : ");
			inputString = br.readLine();
			if (inputString.split("[!0-9]").length != 0) System.out.println("���� ������ �Է� �����մϴ�. �ٽ� �Է����ּ���.");
			else if (inputString.equals("0")) break;
			input = Integer.parseInt(inputString);
			
			while(input > 0) {
				binary[count++] = input % 2 ;
				input /= 2;
			}
			
			for (int i = count-1; i >= 0; i--) {
				System.out.print(binary[i]);
				count2++;
				if (count2 % 4 == 0) System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println("���α׷��� �����մϴ�.");
	}
	
}
