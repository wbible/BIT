package class_2;

import java.util.StringTokenizer;

public class Token {
	public static void main(String[] args) {
		String str = "�п�,��,,���ӹ�";
		StringTokenizer st = new StringTokenizer(str, ",");
		System.out.println("��ū ���� = " + st.countTokens());
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
		
		String[] ar = str.split(",");
		System.out.println("�迭 ���� = " + ar.length);
		for(String data : ar) {
			System.out.println(data);
		}

	}
}
