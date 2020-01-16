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
		System.out.println("객체 aa = " + aa);
		aa.setName("홍길동");
		aa.setAge(25);
		System.out.println("이름=" + aa.getName() + "\t나이=" + aa.getAge());
		
		Person bb;
		bb = new Person();
		System.out.println("객체 bb = " + bb);
		bb.setName("코난");
		bb.setAge(16);
		System.out.println("이름=" + bb.getName() + "\t나이=" + bb.getAge());
		
		Person cc;
		cc = new Person();
		System.out.println("객체 cc = " + cc);
		cc.setData("또치", 30);
		System.out.println("이름=" + cc.getName() + "\t나이=" + cc.getAge());
		
		Person dd;
		dd = new Person();
		System.out.println("객체 dd = " + dd);
		dd.setData();
		System.out.println("이름=" + dd.getName() + "\t나이=" + dd.getAge());
	}
}
