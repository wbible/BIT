package class_2;

import java.util.Scanner;

public class Practice {
	public static void main(String[] args) {
		String str_old, str_new;
		int index = -1;
		int count = 0;

		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		System.out.print("���ڿ� �Է� : ");
		sb.append(sc.nextLine().toLowerCase());
		System.out.print("���� ���ڿ� �Է� : ");
		str_old = sc.nextLine();
		
		while (true) {
			System.out.print("�ٲ� ���ڿ� �Է� : ");
			str_new = sc.nextLine();
			if (str_new.equals(str_old)) {
				System.out.println("���� ���ڿ��� �ٲ� ���ڿ��� �����մϴ�. �ٽ� �Է����ּ���.");
			}else if (sb.length() < str_new.length()) {
				System.out.println("�Է��� ���ڿ��� ũ�Ⱑ �۽��ϴ�.");
			}else break;
		}
		index = sb.indexOf(str_old);
		while(index != -1) {
		sb.replace(index, index + str_old.length(), str_new);
		count++;
		index = sb.indexOf(str_old);
		}
		System.out.println(sb);
		System.out.println(count + "�� ġȯ");
		sc.close();
	}
}
