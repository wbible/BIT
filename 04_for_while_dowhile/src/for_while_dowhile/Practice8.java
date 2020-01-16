package for_while_dowhile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//[����8] ���°��� ���α׷�
//����, ���, �ܰ�, ���� ����� �����ϴ� ���� ���°��� ���α׷��� �ۼ��Ͻÿ�.
public class Practice8 {
	private int user;
	private int money = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Practice8 p = new Practice8(); 
		
		while(true) {
			p.setUser(-1);
			System.out.println("****************");
			System.out.println(" 1. ����");
			System.out.println(" 2. ���");
			System.out.println(" 3. �ܾ�");
			System.out.println(" 4. ����");
			System.out.println("****************");
			System.out.print("��ȣ ���� : ");
			
			p.setUser(p.getNumber(br));
			if(p.getUser() == 1) {
				p.input(br);
			}else if(p.getUser() == 2) {
				p.output(br);
			}else if(p.getUser() == 3) {
				System.out.printf("����� �ܾ��� %d���Դϴ�.\n", p.getMoney());
			}else {
				break;
			}
			
		}
		System.out.println("���α׷� ����");
		
	}
	
	public void input(BufferedReader br) throws IOException {
		int tmp;
		while(true){
			System.out.print("���ݾ� : ");
			tmp = getMoney(br);
			if(tmp % 10000 == 0) break;
			System.out.println("���� ������ �Է��ϼ���");
		}
		setMoney(getMoney() + tmp);
		System.out.printf("����� �ܾ��� %d���Դϴ�.\n", getMoney());
	}
	
	public void output(BufferedReader br) throws IOException {
		System.out.print("��ݾ� : ");
		int tmp = getMoney(br);
		if(tmp > getMoney()) {
			System.out.printf("�ܾ��� �����մϴ�.\n");
		}else {
			setMoney(getMoney() - tmp);
		}
		System.out.printf("����� �ܾ��� %d���Դϴ�.\n", getMoney());
	}
	
	public int getNumber(BufferedReader br) throws IOException {
		String tmp = br.readLine();
		// ���ڰ� �ƴ� ���� �Էµ� ��� ���� �޽����� ����ϰ� ���α׷� �����
		while(tmp.split("[!0-9]").length > 0 || Integer.parseInt(tmp) > 4 || Integer.parseInt(tmp) == 0) {
			System.out.println("�Է°��� �߸��Ǿ����ϴ�. �ٽ� �Է����ּ���.");
			tmp = br.readLine();
		}
		// ���ڸ� �Էµ� ��� �� ���� int ������ ��ȯ
		return Integer.parseInt(tmp);
	}
	
	public int getMoney(BufferedReader br) throws IOException {
		String tmp = br.readLine();
		// ���ڰ� �ƴ� ���� �Էµ� ��� ���� �޽����� ����ϰ� ���α׷� �����
		while(tmp.split("[!0-9]").length > 0) {
			System.out.println("�Է°��� �߸��Ǿ����ϴ�. �ٽ� �Է����ּ���.");
			tmp = br.readLine();
		}
		// ���ڸ� �Էµ� ��� �� ���� int ������ ��ȯ
		return Integer.parseInt(tmp);
	}
	
	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
}
