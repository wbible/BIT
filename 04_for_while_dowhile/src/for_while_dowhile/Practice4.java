package for_while_dowhile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//[����4] ���� ����
//10~99 ������ ������ 2��(a,b) �߻��Ͽ� ���� ���ߴ� ����
//�������� �� 5������ �����Ѵ�
//1������ ���� 20���� ���
//���� Ʋ���� ��ȸ�� 1�� �� �����Ѵ�
public class Practice4 {
	public static void main(String[] args) throws IOException {
		// ������ instance ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int user, num1, num2, count;
		String tmp;
		Practice4 p = new Practice4(); // -> �޼ҵ带 �����ϱ� ���� Ŭ���� instance
		
		while(true) {
			count = 0; // ���� �ʱ�ȭ
			for (int i = 1; i < 6; i++) {
				// ���� �߻� �� ���
				num1 = (int) (Math.random() * 90 + 10);
				num2 = (int) (Math.random() * 90 + 10);
				
				System.out.printf("[%d] %d + %d = ", i, num1, num2);
				user = p.getNumber(br);
				if (user == num1 + num2) {
					System.out.println("������");
					count++;
				} else {
					System.out.println("Ʋ�ȴ�");
					System.out.printf("[%d] %d + %d = ", i, num1, num2);
					user = p.getNumber(br);
					if (user == num1 + num2) {
						System.out.println("������");
						count++;
					} else {
						System.out.printf("Ʋ�ȴ�... ����: %d\n", num1 + num2);
					}
				} 
			}
			System.out.printf("����� �� %d������ ���߾ %d���Դϴ�.\n", count, count * 20);
			
			while(true) {
				System.out.print("continue(y/n) : ");
				tmp = br.readLine();
				if (tmp.equalsIgnoreCase("n") || tmp.equalsIgnoreCase("y")) break;
				System.out.println("Y �Ǵ� N�� �Է� �����մϴ�.");
			}
			if (tmp.equalsIgnoreCase("n")) break;
		}
		System.out.println("���α׷��� �����մϴ�.");
	}
	
	public int getNumber(BufferedReader br) throws IOException {
		String tmp = br.readLine();
		// ���ڰ� �ƴ� ���� �Էµ� ��� ���� �޽����� ����ϰ� ���α׷� �����
		while(tmp.split("[!0-9]").length > 0) {
			System.out.println("���� ������ �Է� �����մϴ�. �ٽ� �Է����ּ���.");
			tmp = br.readLine();
		}
		// ���ڸ� �Էµ� ��� �� ���� int ������ ��ȯ
		return Integer.parseInt(tmp);
	}
}
