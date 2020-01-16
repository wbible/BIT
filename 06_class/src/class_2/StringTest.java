package class_2;

import java.util.stream.Collectors;

public class StringTest {
	public static void main(String[] args) {
		String a = "aa"; // 리터럴 생성
		String e = "a오늘 날짜는 " + 2019+12+30;
		
		e = e.replace('a', 'b');
		System.out.println("문자열 크기 = ");
		for(int i = 0; i < e.length(); i++) {
			System.out.println(i + " : \t" + e.charAt(i));
		}
		
		System.out.println("부분 문자열 추출 = " + e.substring(7));
		System.out.println("부분 문자열 추출 = " + e.substring(7, 11));
		
		System.out.println("대문자 변경 = " + "Hello".toUpperCase());
		System.out.println("소문자 변경 = " + "Hello".toLowerCase());
		
		System.out.println("문자열 검색 = " + e.indexOf("짜"));
		System.out.println("문자열 검색 = " + e.indexOf("날짜"));
		System.out.println("문자열 검색 = " + e.indexOf("간나다"));
		System.out.println(e);
		
		

		
	}
	
}
