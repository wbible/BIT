package abstract_1;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class NumberTest {
	public static void main(String[] args) {
		NumberFormat nf = new DecimalFormat();
		System.out.println(nf.format(12345678.456789));
		System.out.println(nf.format(12345678));
		System.out.println();
		
		nf = new DecimalFormat("#,###.##원");
		System.out.println(nf.format(12345678.456789));
		System.out.println(nf.format(12345678));
		System.out.println();
		
		nf = new DecimalFormat("#,###.00원");
		System.out.println(nf.format(12345678.456789));
		System.out.println(nf.format(12345678));
		System.out.println();
		
		NumberFormat nf4 = NumberFormat.getInstance(); // 메소드를 이용한 생성
		System.out.println(nf4.format(12345678.456789));
		System.out.println(nf4.format(12345678));
		System.out.println();
		
		NumberFormat nf5 = NumberFormat.getCurrencyInstance(); // 메소드를 이용한 생성
		nf5.setMaximumFractionDigits(2);
		nf5.setMinimumFractionDigits(2);
		System.out.println(nf5.format(12345678.456789));
		System.out.println(nf5.format(12345678));
		System.out.println();
		
		
		NumberFormat nf6 = NumberFormat.getCurrencyInstance(Locale.US); // 메소드를 이용한 생성
		nf6.setMaximumFractionDigits(2);
		nf6.setMinimumFractionDigits(2);
		System.out.println(nf6.format(12345678.456789));
		System.out.println(nf6.format(12345678));
		System.out.println();
	}
}
