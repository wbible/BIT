package instance;

public class Operator2 {
	public static void main(String[] args) {
		boolean a = 25 > 36;
		System.out.println(a);

		String b = "apple"; // 문자열 literal - heap 내에서 위치가 달라짐
		// heap 영역에서는 메모리에 이름을 붙일 수 없고 위치 주소를 전달해준다.
		String c = new String("apple");
		System.out.println("b == c " + (b == c ? "같다." : "다르다."));
		System.out.println("b != c " + (b != c ? "참" : "거짓"));
		
		System.out.println("b.equals(c) : " + (b.equals(c) ? "같다" : "다르다"));
		System.out.println("!b.equals(c) : " + (!b.equals(c) ? "참" : "거짓"));
	}
}
