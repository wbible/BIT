package array;

public class ArrayTest {
	public static void main(String[] args) {
		int[] ar = {25, 36, 47, 55, 60};
		
		System.out.println("�迭�� ar = " + ar);
		System.out.println("�迭 ũ�� = " + ar.length);
		
		for (int i = 0; i < ar.length; i++) {
			if(ar[i] % 2 == 1)
				System.out.printf("ar[%d] : %d\n", i, ar[i]);
		}
	}
}
