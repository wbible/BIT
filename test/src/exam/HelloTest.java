package exam;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;

class HelloTest{
	public static void main(String[] args){
		String[] ar = {"1", "20", "31", "45", "15"};
		int[] ar2 = {1, 2, 3, 4, 5};
		
		Arrays.sort(ar, new Comparator<String>() {
			public int compare(String a, String b) {
				int i = 0;
				int tmp = b.charAt(i) - a.charAt(i);
				while(tmp == 0) {
					if(a.length() == i +1 || b.length() == i +1) break;
					i++;
					tmp = b.charAt(i) - a.charAt(i);
				}
				return tmp;
			}
		});
		
		System.out.println(Arrays.toString(ar));
		
		DecimalFormat df = new DecimalFormat("####");
		System.out.println(df.format(123456789));
	}
}