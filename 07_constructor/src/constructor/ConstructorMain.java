package constructor;

class ConstructorTest{
	private String name;
	private int age;
	
	public ConstructorTest() {
		System.out.println("기본생성자");
	}
	public ConstructorTest(String name) {
		this.name = name;
	}
	public ConstructorTest(int age) {
		this("코난");
		this.age = age;
	}
	
	public String getName() {return name;}
	public int getAge() {return age;}
}

public class ConstructorMain {
	public static void main(String[] args) {
		ConstructorTest aa = new ConstructorTest();
		System.out.println("이름="+aa.getName()+"\t나이 ="+aa.getAge());
		
		ConstructorTest bb = new ConstructorTest("홍길동");
		System.out.println("이름="+bb.getName()+"\t나이 ="+bb.getAge());
		
		ConstructorTest cc = new ConstructorTest(25);
		System.out.println("이름="+cc.getName()+"\t나이 ="+cc.getAge());
	}
}
