package class_1;

class This{
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}


// --------------------
public class ThisTest {
	
	public static void main(String[] args) {
		
		This aa = new This();
		aa.setName("ȫ�浿");
		aa.setAge(30);
		System.out.println("��ü tt = " + aa);
		System.out.println("�̸�="+aa.getName() + "\t ����=" + aa.getAge());
	}
	
}
