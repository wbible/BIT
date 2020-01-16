package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayTest3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayTest3 p = new ArrayTest3();
		
		System.out.print("�迭�� ũ�⸦ �Է��ϼ��� : ");
		int size = Integer.parseInt(br.readLine());
		int[] arr = new int[size];
		p.input(arr, br);
		
		int min, max, sum;
		min = p.min(arr);
		max = p.max(arr);
		sum = p.sum(arr);
		
		p.output(arr, max, sum, min);
		
	}
	
	public void input(int[] arr, BufferedReader br) throws IOException {
		for(int i = 0; i < arr.length; i++ ) {
			System.out.printf("ar[%d] : ", i);
			arr[i] = Integer.parseInt(br.readLine());
		}
	}
	
	public void output(int[] arr, int max, int sum, int min) {
		System.out.println("�迭�� ũ�� : " + arr.length);
		System.out.println("�� = " + sum);
		System.out.println("�ִ밪 = " + max);
		System.out.println("�ּҰ� = " + min);
	}
	
	public int min(int[] arr) {
		int min = arr[0];
		for (int i: arr) {
			if (min > i) min = i;
		}
		return min;
	}
	
	public int max(int[] arr) {
		int max = arr[0];
		for (int i: arr) {
			if (max < i) max = i;
		}
		return max;
	}
	
	public int sum(int[] arr) {
		int s = 0;
		for (int i: arr) {
			s += i;
		}
		return s;
	}
}
