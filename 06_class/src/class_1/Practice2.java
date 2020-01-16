package class_1;

import java.util.Comparator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice2 {
	public static void main(String[] args) {
		ShapeTest st = new ShapeTest();
		
		System.out.println("ø¯¿« ≥–¿Ã : " + st.area(3));
		System.out.println("ªÔ∞¢«¸¿« ≥–¿Ã : " + st.area(5,7));
		System.out.println("ªÁ¥Ÿ∏Æ≤√¿« ≥–¿Ã : " + st.area(2,3,5));
		
		
		String s = "1234567a";
		System.out.println(s.indexOf('a'));
	    System.out.println(Stream.of(s.split(""))
	    		.sorted(Comparator.reverseOrder())
	    		.collect(Collectors.joining(""))
	    		.toString());
		
	}
}
