package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayTest2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int size = (int) (Math.random() * 4 + 2);
		String[] ar = new String[size];
		System.out.println("배열명 ar = " + ar);
		System.out.println("배열 크기 = " + ar.length);
		
		for (int i = 0; i < ar.length; i++) {
			System.out.print("과일명 입력: ");
			ar[i] = br.readLine();
		}
		
		for(String data : ar) {
			System.out.println(data);
			System.out.println("첫 번째 문자 = " + data.charAt(0));
			System.out.println("문자열 크기 = " + data.length());
			
		}
	}
}
