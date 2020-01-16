package abstract_1;

public class AbstractMain extends AbstractTest{

	public static void main(String[] args) {
		//AbstractTest at = new AbstractTest(); // 추상 클래스는 객체화할 수 없다.
		AbstractTest at = new AbstractMain();
		at.setName("홍길동");
		System.out.println("이름 = " + at.getName());

	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

}
