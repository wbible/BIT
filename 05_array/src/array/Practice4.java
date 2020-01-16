package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// �߱�����
public class Practice4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] answer, user;
		String input;
		int strike, ball;
		
		while (true) {
			System.out.print("������ �����Ͻðڽ��ϱ�?(Y/N) : ");
			input = br.readLine();
			if(input.equalsIgnoreCase("n")) break;
			else if(input.equalsIgnoreCase("y")){
			}else {
				System.out.println("Y �Ǵ� N�� �Է� �����մϴ�.");
				continue;
			}
			
			// ���� �ʱ�ȭ 
			System.out.println("������ �����մϴ�.");
			answer = new int[3];
			user = new int[3];
			strike = ball = 0;
			
			for (int i = 0; i < 3; i++) {
				answer[i] = (int) (Math.random() * 10);
				for (int j = 0; j < i; j++) {
					if(answer[i] == answer[j]) {i--; break;}
				}
			} 
			
			GET: while(strike < 3) {
				// �Է� �� �Է°� ��ȿ�� Ȯ��
				System.out.print("���� �Է� : ");
				input = br.readLine();
				if (input.split("[!0-9]").length != 0 || input.length() !=3) {
					System.out.println("�Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
					continue;
				}
				for (int i = 0; i < input.length(); i++) {
					user[i] = input.charAt(i) - '0';
					for(int j = 0; j < i; j++) {
						if(user[i] == user[j]) {
							System.out.println("�ߺ��� ���� �ֽ��ϴ�. �ٽ� �Է����ּ���.");
							continue GET;
						}
					}
				}
//				for(int n:answer)System.out.print(n);
//				System.out.println();
				
				// ��� Ȯ��
				strike = 0;
				ball = 0;
				for (int i = 0; i < user.length; i++) {
					for (int j = 0; j < answer.length; j++) {
						if (user[i] == answer[j] && i == j) {strike++;}
						else if (user[i] == answer[j]) {ball++;}
					}
				}
				System.out.printf("%d��Ʈ����ũ %d��\n", strike, ball);
			}
			System.out.println("�����Դϴ�!");
			
		}
		
		
		
	}
}
