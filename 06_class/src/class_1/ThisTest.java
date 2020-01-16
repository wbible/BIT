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
		aa.setName("È«±æµ¿");
		aa.setAge(30);
		System.out.println("°´Ã¼ tt = " + aa);
		System.out.println("ÀÌ¸§="+aa.getName() + "\t ³ªÀÌ=" + aa.getAge());
	}
	
}
