package calculator;

public class Test {
	
	public static void main(String[] args) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("abc");
		sb.delete(sb.length()-2, sb.length());
		System.out.println(sb);
	} 
	
}
