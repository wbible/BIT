package for_while_dowhile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice6 {
	public static void main(String[] args) throws IOException {
		// ������ instance ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Practice6 p = new Practice6(); // -> �޼ҵ带 �����ϱ� ���� Ŭ���� instance
		int mid, fin, report, attendance;
		String eval;
		
		System.out.print("�߰���縦 �Է��Ͻÿ� : ");
		mid = p.getNumber(br);
		System.out.print("�⸻��縦 �Է��Ͻÿ� : ");
		fin = p.getNumber(br);
		System.out.print("���������� �Է��Ͻÿ� : ");
		report = p.getNumber(br);
		System.out.print("�⼮������ �Է��Ͻÿ� : ");
		attendance = p.getNumber(br);
		
		double total = (mid+fin)/2.0 * 0.6 + report *0.2 + attendance * 0.2;
		// ���� 3 - switch
		switch(p.getScore(total)) {
		case 'A':
		case 'B':
			eval = "excellent";
			break;
		case 'C':
		case 'D':
			eval = "good";
			break;
		default:
			eval = "poor";
		}
		
		System.out.printf("����=%.2f\n", total);
		System.out.println("����=" + p.getScore(total));
		System.out.println("��="+eval);
		
	}
	
	public int getNumber(BufferedReader br) throws IOException {
		String tmp = br.readLine();
		// ���ڰ� �ƴ� ���� �Էµ� ��� ���� �޽����� ����ϰ� ���α׷� �����
		while(tmp.split("[!0-9]").length > 0 || Integer.parseInt(tmp) > 100) {
			System.out.println("�Է°��� �߸��Ǿ����ϴ�. �ٽ� �Է����ּ���.");
			tmp = br.readLine();
		}
		// ���ڸ� �Էµ� ��� �� ���� int ������ ��ȯ
		return Integer.parseInt(tmp);
	}
	
	public char getScore(double total) {
		// ���� 2 - switch
		switch((int)total / 10) {
		case 10: 
		case 9:return 'A';
		case 8:return 'B';
		case 7:return 'C';
		case 6:return 'D';
		}
		return 'F';
	}
}
