package nested;

public class Outer {
	private String name;
	class Inner {
		private int age;
		public void disp() {
			System.out.println("이름 = " + Outer.this.name + "\t나이 = " + age);
		}
	}
	
	public static void main(String[] args) {
		Outer outer = new Outer();
		outer.name = "홍길동";
		System.out.println("이름 = " + outer.name);
		
		Outer.Inner inner = outer.new Inner();
		inner.age = 25;
		inner.disp();
		
		Outer.Inner inner2 = outer.new Inner();
		inner2.age = 30;
		inner2.disp();
		
		Outer.Inner inner3 = new Outer().new Inner();
//		inner3.name = "코난";
		inner3.age = 35;
		inner3.disp();
	}
	
	public void output() {
		System.out.println("이름 = " + name + "\t나이 = " + new Inner().age);
	}
}
