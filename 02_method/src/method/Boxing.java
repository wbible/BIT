package method;

public class Boxing {
	public static void main(String[] args) {
		int a = 25;
		double b = (double) a / 3; // cast ���� - ����ȯ

		int c = 5;
		Integer d = c; // AutoBoxing �⺻�� -> ��ü��
		// Integer d = new Integer(c); JDK 5.0  ����
		
		Integer e = 5;
		int f = e; // unAutoBoxing ��ü�� -> �⺻��
		// int f = e.intValue(); JDK 5.0 ����
		
	}
}
