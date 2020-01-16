package collection;

public class GenericTest2<T> {
	private T a;
	
	public GenericTest2(T a) {
		this.a =a;
	}
	public void setA(T a) {
		this.a = a;
	}
	public T getA() {
		return a;
	}	
	
	public static void main(String[] args) {
		GenericTest2<?> aa = new GenericTest2<String>("ȫ�浿");
//		aa.setA("ȫ�浿"); - �����ڸ� ���ؼ��� �Է� ����
		
		String name = (String) aa.getA();
		System.out.println("�̸� = " + name);
		
		GenericTest2<?> bb = new GenericTest2<Integer>(25);
		int age = (Integer) bb.getA(); // unAutoBoxing
		System.out.println("���� = " + age);
	}

}
