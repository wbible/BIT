package thread;

public class RoseTest extends Thread {
	private String name;
	public RoseTest(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		for(int i = 1; i <= 5; i++) {
			System.out.println(name + "\t" + Thread.currentThread() + "\ti = " + i);
		}
		System.out.println(name + " ����");
	}
	
	public static void main(String[] args) {
		RoseTest aa = new RoseTest("�ȶ�");
		RoseTest bb = new RoseTest("�ູ");
		RoseTest cc = new RoseTest("���");
		
		aa.setName("�ȶ�");
		bb.setName("�ູ");
		cc.setName("���");
		
		// �켱���� 1~10, default�� 5
//		aa.setPriority(10);
//		bb.setPriority(5);
//		cc.setPriority(1);
		
		aa.start(); // ������ ����  - ������ ���� (�ü��)
		try {
			aa.join(); // aa�� ���� ������ �ٸ� ������� ��ٸ���.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		bb.start();
		cc.start();
	}

}
