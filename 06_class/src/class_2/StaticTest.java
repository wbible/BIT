package class_2;

public class StaticTest {
	private int a;
	private static int b;
	
	public StaticTest() {
		System.out.println("기본생성자");
		a = 3;
		//b = 3;
	}
	
	static {
		System.out.println("static 초기화 영역");
	}
	
	public void calc() {
		a++;
		b++;
	}
	
	public void disp() {
		System.out.println("a=" + a + "\t b="+b);
	}
	
	public static void output() {
		System.out.println("static method..");
		//System.out.println("a=" + a + "\t b="+b); - error
	}
	
	public static void main(String[] args) {
		StaticTest st = new StaticTest();
		st.calc();
		st.disp();
		System.out.println();
		
		StaticTest st2 = new StaticTest();
		st2.calc();
		st2.disp();
		System.out.println();
		
		StaticTest st3 = new StaticTest();
		st3.calc();
		st3.disp();
		System.out.println();
		
		output();
		st.output();
		
		
	}
}
