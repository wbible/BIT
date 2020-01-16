package class_2;

import java.util.StringTokenizer;

public class Token {
	public static void main(String[] args) {
		String str = "학원,집,,게임방";
		StringTokenizer st = new StringTokenizer(str, ",");
		System.out.println("토큰 개수 = " + st.countTokens());
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
		
		String[] ar = str.split(",");
		System.out.println("배열 개수 = " + ar.length);
		for(String data : ar) {
			System.out.println(data);
		}

	}
}
