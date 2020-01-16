package inheritance;

public class SubTest extends SuperTest {
	private String name;
	private int age;
	
	public SubTest() {
		System.out.println("SubTest 기본생성자");
	}
	
	public SubTest(String name, int age, double weight, double height) {
		System.out.println("SubTest 생성자");
//		super(weight, height);
		this.name = name;
		this.age = age;
		
		this.weight = weight;
		this.height = height;
		
		super.weight = weight;
		super.height = height;
	}
	
	public void output() {
		System.out.println("이름 = " + name);
		System.out.println("나이 = " + age);
		System.out.println("몸무게 = " + weight);
		System.out.println("키 = " + height);
	}
	
	public static void main(String[] args) {
		SubTest aa = new SubTest("홍길동", 25, 79.5, 185.3);
		aa.output();
		aa.disp();
		System.out.println();
		
		SuperTest bb = new SubTest("또치", 16, 52.6, 162.3);
//		bb.output();
		bb.disp();
	}
}
