package class_1;

class Person{
	private String name;
	private int age;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setData(String name, int age) {
		setName(name);
		setAge(age);
	}
	public void setData() {
//		setName("");
//		setAge(0);
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
}

public class PersonMain {
	public static void main(String[] args) {
		Person aa;
		aa = new Person();
		System.out.println("��ü aa = " + aa);
		aa.setName("ȫ�浿");
		aa.setAge(25);
		System.out.println("�̸�=" + aa.getName() + "\t����=" + aa.getAge());
		
		Person bb;
		bb = new Person();
		System.out.println("��ü bb = " + bb);
		bb.setName("�ڳ�");
		bb.setAge(16);
		System.out.println("�̸�=" + bb.getName() + "\t����=" + bb.getAge());
		
		Person cc;
		cc = new Person();
		System.out.println("��ü cc = " + cc);
		cc.setData("��ġ", 30);
		System.out.println("�̸�=" + cc.getName() + "\t����=" + cc.getAge());
		
		Person dd;
		dd = new Person();
		System.out.println("��ü dd = " + dd);
		dd.setData();
		System.out.println("�̸�=" + dd.getName() + "\t����=" + dd.getAge());
	}
}
