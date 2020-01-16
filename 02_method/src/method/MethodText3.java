package method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MethodText3 {

	public static void main(String[] args) throws IOException {
		// �̸�, ����, ����, ������ �Է� �޾Ƽ� ����, ����� ���Ͻÿ�.
		// *** ���� - BufferedReader, InputStreamReader(Ű���带 ���� ������ ������Ÿ���� InputStream),
		// FileReader
		// *** ���� - Exception(����ó��): ������, ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		/*
		 * System.out.print("���ڿ��� �Է����ּ���: "); String str = br.readLine();
		 * System.out.println(str);
		 * 
		 * System.out.print("������ �Է����ּ���: "); int num1 = Integer.parseInt(br.readLine());
		 * System.out.println(num1);
		 * 
		 * System.out.print("�Ǽ��� �Է����ּ���: "); double num2 =
		 * Double.parseDouble(br.readLine()); System.out.println(num2);
		 */

		// Ŭ���� ���� �޼ҵ带 ����ϱ� ���� ��ü ����
		MethodText3 c = new MethodText3();

		// ����ڷκ��� �̸��� �Է� �޾� name ������ ����
		System.out.print("�̸��� �Է����ּ���: ");
		String name = br.readLine();

		// ����ڷκ��� �� ���� ������ �Է� �޾� score �迭�� ����
		// --> ���ڷ� ���۵Ǵ� ���� �Էµ� ��� ���� �޽��� ��� �� �ٽ� �Է��� �޴´�.
		String subject[] = { "����", "����", "����" };
		int score[] = new int[subject.length];
		for (int i = 0; i < subject.length; i++) {
			score[i] = -1;
			while(score[i] == -1) {
				System.out.printf("%s ������ �Է����ּ���: ", subject[i]);
				// score[i] = Integer.parseInt(br.readLine());
				score[i] = c.getInt((br.readLine()));
				if (score[i] < 0 || score[i] > 100) {
					System.out.println("�Է°��� �߸��Ǿ����ϴ�.");
					score[i] = -1;
				}
			}
		}

		// ȭ�鿡 ���
		System.out.printf("*** %s ����ǥ ***\n����\t����\t����\t����\t���\n", name);
		System.out.printf("%d\t%d\t%d\t%d\t%.2f\n", score[0], score[1], score[2], c.calcTot(score), c.calcAvg(score));

	}

	public int calcTot(int list[]) { // ������ ���
		int sum = 0;
		for (int i = 0; i < list.length; i++) {
			sum += list[i];
		}
		return sum;
	}

	public double calcAvg(int[] list) { // ��� ���� ���
		int sum = calcTot(list);
		return (double) (sum / list.length);
	}

	public int getInt(String str) {
		String tmp = "";
		for (int i = 0; i < str.length(); i++) {
			tmp = tmp + ((str.charAt(i) >= '0' && str.charAt(i) <= '9') || str.charAt(i) == '.' ? Character.toString(str.charAt(i)): "");
		}
		return tmp.length() > 0 ? (int) Double.parseDouble(tmp) : -1;
	}

}
