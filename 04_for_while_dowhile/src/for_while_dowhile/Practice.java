package for_while_dowhile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//���������� ���� - if��
public class Practice {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Practice p = new Practice();
		
		int user;
		int com;
		String tmp;
		
		while (true) {
			System.out.print("����(1), ����(2), ���ڱ�(3) �� ��ȣ �Է� : ");
			user = Integer.parseInt(br.readLine());
			com = (int) (Math.random() * 3 + 1);
			// ������ ������ ���ڿ� �������� ���ڷ� �Է¹��� ���� ���ڿ��� ȭ�鿡 ������
			System.out.printf("��ǻ�� : %s\t\t�� : %s", p.change(com), p.change(user));
			
			if (user == com) {
				//����� ��
				System.out.println("You Draw!!");
			}else if ((user == 1 && com ==3) || (user == 2 && com ==1) || (user == 3 && com ==2)) {
				//������ �̰��� ��
				System.out.println("You Win!!");
			}else {
				//������ ���� ��
				System.out.println("You Lose!!");
			}
			
			while(true) {
				System.out.print("�� �ҷ�(Y/N) : ");
				tmp = br.readLine();
				if (tmp.equalsIgnoreCase("n") || tmp.equalsIgnoreCase("y")) break;
				System.out.println("Y �Ǵ� N�� �Է� �����մϴ�.");
			}
			if (tmp.equalsIgnoreCase("n")) break;
			
		}
		System.out.println("���α׷��� �����մϴ�.");
		
	}
	public String change(int num) {
		//���� 1~3�� ���ڿ� "����, ����, ���ڱ�"�� �������ִ� �޼ҵ�
		if(num == 1) return "����";
		else if (num == 2) return "����";
		else return "���ڱ�";
	}
}
