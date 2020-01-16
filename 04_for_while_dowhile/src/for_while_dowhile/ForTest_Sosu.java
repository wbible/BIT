package for_while_dowhile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ForTest_Sosu {
	public static void main(String[] args) throws IOException {
		// ������ instance ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int user;
		String tmp; // -> �Է¹��� ���� ��ȿ���� Ȯ���ϱ� ���� �ӽ� ����
		ForTest_Sosu p = new ForTest_Sosu(); // -> sosu_check �޼ҵ带 �����ϱ� ���� Ŭ���� instance
		
		while(true) {
			// ����ڷκ��� ���ڿ� �Է��� �޾� tmp�� ����
			System.out.print("���� �Է� : ");
			tmp = br.readLine();
			
			// ���ڰ� �ƴ� ���� �Էµ� ��� ���� �޽����� ����ϰ� ���α׷� �����
			if (tmp.split("[!0-9]").length > 0) {
				System.out.println("���� ������ �Է� �����մϴ�. �ٽ� �Է����ּ���.");
				continue;
			}
			// ���ڸ� �Էµ� ��� �� ���� int ������ user ������ ����
			user = Integer.parseInt(tmp);
			
			// �Էµ� ���� 0�� ��� �ݺ����� �������� -> ���α׷� ����
			if(user == 0) break;
			
			// sosu_check �޼ҵ带 ���� �Է¹��� ���� �Ҽ����� �Ǻ�
			if(p.sosu_check(user)) {
				System.out.println(user + "��(��) �Ҽ��Դϴ�.");
			}else {
				System.out.println(user + "��(��) �Ҽ��� �ƴմϴ�.");
			}
		}
		System.out.println("���α׷��� �����մϴ�.");
	}
	
	// int �μ��� �޾Ƽ� �Ҽ����� Ȯ���Ͽ� �Ҽ��̸� true�� ��ȯ�ϴ� �޼ҵ�
	public boolean sosu_check(int user) {
		// 1�� �Ҽ��� �ƴ�
		if(user == 1) return false; 
			
		// 2 �̻��� �Էµ� ��� 2���� �Է¹��� ������ �����ٱ����� ���� ������ �������� 0�̸� false�� ��ȯ 
		for(int i = 2; i<= (int)Math.sqrt(user); i++) 
			if (user % i == 0) return false;
		
		// ������ �������� ������ �Ҽ��̹Ƿ� true�� ��ȯ
		return true;
	}
}
