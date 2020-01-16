package array;

import java.util.ArrayList;
import java.util.Arrays;

public class MultiArray5 {
	public static void main(String[] args) {
		int[][] ar = new int[3][];
		ar[0] = new int[1];
		ar[1] = new int[2];
		ar[2] = new int[3];
		
		ar[0][0] = 10;
		
		ar[1][0] = 20;
		ar[1][1] = 30;
		
		ar[2][0] = 40;
		ar[2][1] = 50;
		ar[2][2] = 60;
		
		for(int i = 0; i < ar.length; i++) {
			for(int j = 0; j < ar[i].length; j++) {
				System.out.printf("ar[%d][%d] = %d\n", i, j, ar[i][j]);
			}
			System.out.println();
		}
		
		ArrayList<String> list = new ArrayList<>(Arrays.asList("»ç°ú", "Æ÷µµ", "±Ö"));
		list.stream().sorted((a, b) -> b.compareTo(a)).forEach(s -> System.out.println(s));
	}
}
