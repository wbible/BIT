package instance;

/* ���� 80~100 �հ� or ���հ�
 * 
 */
public class Variable2 {
	int a; // field - �ν��Ͻ� ����
	static int b; // field - Ŭ���� ����
	String str;

	public static void main(String[] args) {
		int a = 10; // local variable(���� ����), �����Ⱚ(�ݵ�� �ʱ�ȭ)
		
		Variable2 v = new Variable2();
		
		System.out.println("���� a = " + a);
		System.out.println("�ʵ� a = " + v.a);
		System.out.println("�ʵ� b = " + b);
		System.out.println("�ʵ� str = " + v.str);
		
		if(a < 10 && ++a < 11) {
		}
		System.out.println(a);
	}
}
