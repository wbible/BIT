package method;
/*
 * �ֻ����� 2�� ������ ���� ���� ���� ���Ͻÿ�
 * �ֻ����� input()���� 1~6������ ������ �߻��Ͽ� �����Ѵ�
 * ���� add()���� ���Ͽ� ���� �޴´�
 * 
 * [������]
 * ù��° �ֻ��� �� : 3
 * �ι�° �ֻ��� �� : 6
 * ���� 9 �̴�
 */
public class Practice2 {
	public static void main(String[] args) {
		Practice2 c = new Practice2();
		
		int num1 = c.input();
		int num2 = c.input();
		
		System.out.println("ù ��° �ֻ��� �� : " + num1);
		System.out.println("�� ��° �ֻ��� �� : " + num2);
		System.out.println("���� " + c.add(num1, num2) + "�̴�.");
		
	}
	public int input() {
		return (int) (Math.random() * 6) + 1; 
	}
	
	public int add(int a, int b) {
		return a + b;
	}
}
