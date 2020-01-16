package method;

// �̸�, �ֹι�ȣ�� �Է� �޾� ������ ����Ͻÿ�.
// ������ �����ϴ� comp() �޼ҵ�� ���̸� ����ϴ� calcAge() �޼ҵ带 �ۼ��Ͻÿ�.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MethodTest4 {
	public static void main(String[] args) throws IOException {
		// ����ڷκ��� �Է��� �ޱ� ���� BufferedReader ��ü ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// �Լ��� ����ϱ� ���� Ŭ���� ��ü ����
		MethodTest4 c = new MethodTest4();
		System.out.print("�̸��� �Է��ϼ���: ");
		String name = br.readLine();
		String id = c.readId(br);

		int age = c.calcAge(id);
		String gender = c.comp(id);
		// age = c.calcAgeByCal(id);
		System.out.printf("%s���� %s�̰� %d���Դϴ�.\n", name, gender, age);

	}

	public String comp(String id) {
		// �ֹε�Ϲ�ȣ�� Ȯ���Ͽ� �����̸� true, �����̸� false�� ����
		return Integer.parseInt(id.substring(7,8)) % 2 == 1 ? "����" : "����";
	}

	public String readId(BufferedReader br) throws IOException {
		// ��ȿ�� ���� �Էµ� ������ ����ڷκ��� �ֹε�Ϲ�ȣ�� �Է¹���
		String id;
		// ���Խ��� �̿��ϱ� ���� ��ü ����
		String pStr = "^[0-9]{6}-[0-9]{7}$";
		Pattern p = Pattern.compile(pStr);
		Matcher m;
		while (true) {
			System.out.print("�ֹε�Ϲ�ȣ�� �Է��ϼ���(000000-0000000): ");
			id = br.readLine();
			m = p.matcher(id);
			if (!m.find()) {
				// �Է°��� �ùٸ��� ���� ��� ��� �޽��� ���
				System.out.println("�Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
			} else {
				// �ùٸ� ���� �ԷµǸ� �ݺ��� Ż���ϰ� ����� ��ȯ
				return id;
			}
		}
	}

	public int calcAge(String id) {
		// �ֹε�Ϲ�ȣ�� ó�� �� �ڸ� ���ڸ� getFirstTwo() �޼ҵ�� ���ͼ� ���̸� ����Ͽ� ������ ����
		int thisYear = 2019;
		int year = Integer.parseInt(id.substring(0,2));
		year += Integer.parseInt(id.substring(7,8)) <= 2 ? 1900 : 2000;
		return thisYear - year + 1;
	}

	public int calcAgeByCal(String id) {
		// calcAge() �޼ҵ�� ������ thisYear ���� Calendar Ŭ������ ���� ��� �ͼ� �����
		Calendar cal = Calendar.getInstance();
		int thisYear = cal.get(Calendar.YEAR);
		int year = Integer.parseInt(id.substring(0,2));
		year += Integer.parseInt(id.substring(7,8)) <= 2 ? 1900 : 2000;
		return thisYear - year + 1;
	}
}
