package instance;

public class Operator2 {
	public static void main(String[] args) {
		boolean a = 25 > 36;
		System.out.println(a);

		String b = "apple"; // ���ڿ� literal - heap ������ ��ġ�� �޶���
		// heap ���������� �޸𸮿� �̸��� ���� �� ���� ��ġ �ּҸ� �������ش�.
		String c = new String("apple");
		System.out.println("b == c " + (b == c ? "����." : "�ٸ���."));
		System.out.println("b != c " + (b != c ? "��" : "����"));
		
		System.out.println("b.equals(c) : " + (b.equals(c) ? "����" : "�ٸ���"));
		System.out.println("!b.equals(c) : " + (!b.equals(c) ? "��" : "����"));
	}
}
