package instance;

public class Practice7 {
	public static void main(String[] args) {
		String name = "ȫ�浿";
		char gender = 'M';
		p(name, gender);
		
		gender = 'F';
		p(name, gender);
	}
	
	public static void p(String name, char gender) {
		String genderStr = gender == 'M' ? "����": "����";
		System.out.printf("%s�� %s�̴�.\n", name, genderStr);
	}
}
