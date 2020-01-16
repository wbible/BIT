package thread;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATMTest implements Runnable{
	private long depositeMoney = 100000; // �ܾ�
	private long balance; // ã���� �ϴ� �ݾ�

	@Override
	public void run() {
//	public synchronized void run() {
//		synchronized (ATMTest.class) {	
		synchronized (this) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(Thread.currentThread().getName()+"�� �ȳ��ϼ���.");
			
			System.out.print("ã���� �ϴ� �ݾ� �Է�: ");
			try {
				balance = Long.parseLong(br.readLine());
			} catch (Exception e) {
				e.printStackTrace();
			} 
			withDraw();
		}
		
	}
	
	public void withDraw() {
		
		if (balance % 10000 > 0) System.out.println("���� ������ �Է��ϼ���.");
		else if (balance > depositeMoney) {
			System.out.println("�ܾ� �ʰ�");
			System.out.println("�ܾ��� " + depositeMoney + "�Դϴ�.");
		}else {
			depositeMoney -= balance;
			System.out.println("�ܾ��� " + depositeMoney + "�Դϴ�.");
		}
	}

	public static void main(String[] args) {
		ATMTest atm = new ATMTest();
		Thread mom = new Thread(atm, "����");
		Thread son = new Thread(atm, "�Ƶ�");
		
		mom.start();
		son.start();
		
	}
}