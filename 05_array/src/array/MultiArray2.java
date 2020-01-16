package array;

public class MultiArray2 {
	public static void main(String[] args) {
		int[][] ar = new int[10][10];
		int num = 0;
		
		for(int i = ar.length - 1; i >= 0; i--) {
			for(int j = ar[i].length-1; j >= 0; j--) {
				ar[i][j] = ++num;
			}
		}
		
		for(int i = 1; i <= 10; i++) {
			for(int j = 1; j <= 10; j++) {
				System.out.printf("ar[%d][%d] =%2d  ", i-1, j-1, ar[i-1][j-1]);
			}
			System.out.println();
		}
	}
}
