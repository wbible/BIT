package instance;

/* 점수 80~100 합격 or 불합격
 * 
 */
public class Variable2 {
	int a; // field - 인스턴스 변수
	static int b; // field - 클래스 변수
	String str;

	public static void main(String[] args) {
		int a = 10; // local variable(지역 변수), 쓰레기값(반드시 초기화)
		
		Variable2 v = new Variable2();
		
		System.out.println("지역 a = " + a);
		System.out.println("필드 a = " + v.a);
		System.out.println("필드 b = " + b);
		System.out.println("필드 str = " + v.str);
		
		if(a < 10 && ++a < 11) {
		}
		System.out.println(a);
	}
}
