package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapTest{

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("book101", "�鼳����");
		map.put("book201", "�ξ����");
		map.put("book102", "�鼳����"); // value �ߺ����
		map.put("book301", "�ǿ���");
		map.put("book101", "��������"); // key �ߺ����
		
		System.out.println(map.get("book101"));
		
		Scanner sc = new Scanner(System.in);
		System.out.print("�ڵ� �Է�: ");
		String input = sc.nextLine();
		System.out.println(map.get(input)!=null ? map.get(input) : "���� Key�Դϴ�.");
		
		sc.close();
//		if(map.containsKey(input)) {}
	}

}
