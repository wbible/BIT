package abstract_1;

public class AbstractMain extends AbstractTest{

	public static void main(String[] args) {
		//AbstractTest at = new AbstractTest(); // �߻� Ŭ������ ��üȭ�� �� ����.
		AbstractTest at = new AbstractMain();
		at.setName("ȫ�浿");
		System.out.println("�̸� = " + at.getName());

	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

}
