package class_2;

import java.util.Scanner;

public class Practice {
	public static void main(String[] args) {
		String str_old, str_new;
		int index = -1;
		int count = 0;

		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		System.out.print("문자열 입력 : ");
		sb.append(sc.nextLine().toLowerCase());
		System.out.print("현재 문자열 입력 : ");
		str_old = sc.nextLine();
		
		while (true) {
			System.out.print("바꿀 문자열 입력 : ");
			str_new = sc.nextLine();
			if (str_new.equals(str_old)) {
				System.out.println("현재 문자열과 바꿀 문자열이 동일합니다. 다시 입력해주세요.");
			}else if (sb.length() < str_new.length()) {
				System.out.println("입력한 문자열의 크기가 작습니다.");
			}else break;
		}
		index = sb.indexOf(str_old);
		while(index != -1) {
		sb.replace(index, index + str_old.length(), str_new);
		count++;
		index = sb.indexOf(str_old);
		}
		System.out.println(sb);
		System.out.println(count + "번 치환");
		sc.close();
	}
}
