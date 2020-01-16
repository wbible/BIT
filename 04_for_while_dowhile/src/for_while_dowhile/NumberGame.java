package for_while_dowhile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberGame {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int com = (int)(Math.random() * 100);
		int user = -1;
		int count = 0;
		String yn;
		
		while(com != user) {
			System.out.print("���� �Է�: ");
			user = Integer.parseInt(br.readLine());
			count++;
			if(com == user) { // ����ڰ� ������ ���� ���
				System.out.printf("������ %d������ ���߼̽��ϴ�.\n", count);
				
				System.out.print("�� �ҷ�?(Y/N) : ");
				// ����ڷκ��� �Է��� �޾� ������ �ٽ� ������ �� ���θ� Ȯ����, ���� y �Ǵ� n�� �ƴ� ��� ���� �޽����� ����ϰ� �ٽ� �Է��� ����
				do { 
					yn = br.readLine();
					if(yn.equalsIgnoreCase("y") || yn.equalsIgnoreCase("n")) break;
					System.out.print("Y �Ǵ� N�� �Է� �����մϴ�. �ٽ� �Է����ּ��� : ");
				}while(true); 
				
				// �Էµ� ���� n �� ��� ���α׷� ����
				if (yn.equalsIgnoreCase("N")) {
					break;
				}else {
					// �Էµ� ���� y �� ��� ���� �ʱ�ȭ �� ����� 
					com = (int)(Math.random() * 100);
					user = -1;
					count = 0;
				}
			}else if (com > user) {
				System.out.println(user + "���� Ů�ϴ�.");
			}else  {
				System.out.println(user + "���� �۽��ϴ�.");
			}
		}
		System.out.println("���α׷��� �����մϴ�.");
	}
}
