package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayTest4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] ar = new boolean[5];
		ArrayTest4 at = new ArrayTest4();
		
		at.menu(br, ar);
		System.out.println("프로그램을 종료합니다.");
	}

	public void menu(BufferedReader br, boolean[] ar) throws IOException {
		while(true) {
			System.out.println("**************");
			System.out.printf("   1. 입차\n");
			System.out.printf("   2. 출차\n");
			System.out.printf("   3. 리스트\n");
			System.out.printf("   4. 종료\n");
			System.out.println("**************");
			String select = br.readLine();
			if(select.equals("1")) {
				input(br, ar);
			}else if(select.equals("2")) {
				output(br, ar);
			}else if(select.equals("3")) {
				list(ar);
			}else if(select.equals("4")) {
				break;
			}else {
				System.out.println("입력이 올바르지 않습니다. 다시 입력해주세요.");
			}
		}
	}

	public void input(BufferedReader br, boolean[] ar) throws IOException {
		System.out.print("위치 입력 : ");
		int num = Integer.parseInt(br.readLine());
		if(ar[num-1]) {
			System.out.println("이미 주차되어있습니다");
		}else {
			System.out.printf("%d위치에 입차\n", num);
			ar[num-1] = true;
		}
	}

	public void output(BufferedReader br, boolean[] ar) throws IOException {
		System.out.print("위치 입력 : ");
		int num = Integer.parseInt(br.readLine());
		if(ar[num-1]) {
			System.out.printf("%d위치에 출차\n", num);
			ar[num-1] = false;
		}else {
			System.out.println("주차되어 있지않습니다");
		}
	}
	
	public void list(boolean[] ar) {
		for(int i = 0; i < ar.length; i++) {
			System.out.printf("%d위치 : %s\n", i+1, ar[i]);
		}
	}
}
