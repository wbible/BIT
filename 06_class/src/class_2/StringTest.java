package class_2;

import java.util.stream.Collectors;

public class StringTest {
	public static void main(String[] args) {
		String a = "aa"; // ���ͷ� ����
		String e = "a���� ��¥�� " + 2019+12+30;
		
		e = e.replace('a', 'b');
		System.out.println("���ڿ� ũ�� = ");
		for(int i = 0; i < e.length(); i++) {
			System.out.println(i + " : \t" + e.charAt(i));
		}
		
		System.out.println("�κ� ���ڿ� ���� = " + e.substring(7));
		System.out.println("�κ� ���ڿ� ���� = " + e.substring(7, 11));
		
		System.out.println("�빮�� ���� = " + "Hello".toUpperCase());
		System.out.println("�ҹ��� ���� = " + "Hello".toLowerCase());
		
		System.out.println("���ڿ� �˻� = " + e.indexOf("¥"));
		System.out.println("���ڿ� �˻� = " + e.indexOf("��¥"));
		System.out.println("���ڿ� �˻� = " + e.indexOf("������"));
		System.out.println(e);
		
		

		
	}
	
}
