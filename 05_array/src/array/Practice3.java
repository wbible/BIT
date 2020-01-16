package array;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Practice3 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Practice3 p3 = new Practice3();
		
		System.out.print("현금 입력 : ");
		int money = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < money/1000; i++) {
			int arr[] = new int[6];
			arr = p3.input();
			p3.sort(arr);
			p3.output(arr);
			System.out.println();
			if ((i+1) % 5 ==0) System.out.println();
		}
		
	}
	
	private void sort(int[] arr) {
		// Selection Sort
		int tmp;
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				tmp = arr[j];
				if(arr[i] > arr[j]) {
					arr[j] = arr[i];
					arr[i] = tmp;
				}
			}
		}
	}

	public int[] input() {
		int size = 6;
		int lotto[] = new int[size];
		for (int i = 0; i < size; i++) {
			lotto[i] = randomLotto();
			for (int j = 0; j < i; j++) {
				if ((lotto[i] == lotto[j])) {
					lotto[i] = randomLotto();
					j = 0;
				}
			}
		}
		//Arrays.sort(lotto);
		return lotto;
	}
	
	public int randomLotto() {
		return (int)(Math.random() * 45 + 1);
	}
	
	public void output(int[] arr) {
		for(int n : arr) System.out.printf("%2d ", n);
	}
	
}
