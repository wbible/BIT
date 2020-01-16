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
		
		nf = new DecimalFormat("#,###.##��");
		System.out.println(nf.format(12345678.456789));
		System.out.println(nf.format(12345678));
		System.out.println();
		
		nf = new DecimalFormat("#,###.00��");
		System.out.println(nf.format(12345678.456789));
		System.out.println(nf.format(12345678));
		System.out.println();
		
		NumberFormat nf4 = NumberFormat.getInstance(); // �޼ҵ带 �̿��� ����
		System.out.println(nf4.format(12345678.456789));
		System.out.println(nf4.format(12345678));
		System.out.println();
		
		NumberFormat nf5 = NumberFormat.getCurrencyInstance(); // �޼ҵ带 �̿��� ����
		nf5.setMaximumFractionDigits(2);
		nf5.setMinimumFractionDigits(2);
		System.out.println(nf5.format(12345678.456789));
		System.out.println(nf5.format(12345678));
		System.out.println();
		
		
		NumberFormat nf6 = NumberFormat.getCurrencyInstance(Locale.US); // �޼ҵ带 �̿��� ����
		nf6.setMaximumFractionDigits(2);
		nf6.setMinimumFractionDigits(2);
		System.out.println(nf6.format(12345678.456789));
		System.out.println(nf6.format(12345678));
		System.out.println();
	}
}
