package array;

public class MultiArray {
	public static void main(String[] args) {
		int[][] ar = new int[3][2];
		ar[0][0] = 10;
		ar[0][0] = 20;
		
		System.out.println("배열명 ar = " + ar);
		System.out.println("배열명 ar[0] = " + ar[0]);
		System.out.println("배열명 ar[1] = " + ar[1]);
		System.out.println("배열명 ar[2] = " + ar[2]);
		
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[i].length; j++) {
				System.out.println("ar[" + i + "]["+ j + "] = " + ar[i][j]);
			}
		}
		
	}
}
