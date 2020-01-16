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
		System.out.println("���α׷��� �����մϴ�.");
	}

	public void menu(BufferedReader br, boolean[] ar) throws IOException {
		while(true) {
			System.out.println("**************");
			System.out.printf("   1. ����\n");
			System.out.printf("   2. ����\n");
			System.out.printf("   3. ����Ʈ\n");
			System.out.printf("   4. ����\n");
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
				System.out.println("�Է��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
			}
		}
	}

	public void input(BufferedReader br, boolean[] ar) throws IOException {
		System.out.print("��ġ �Է� : ");
		int num = Integer.parseInt(br.readLine());
		if(ar[num-1]) {
			System.out.println("�̹� �����Ǿ��ֽ��ϴ�");
		}else {
			System.out.printf("%d��ġ�� ����\n", num);
			ar[num-1] = true;
		}
	}

	public void output(BufferedReader br, boolean[] ar) throws IOException {
		System.out.print("��ġ �Է� : ");
		int num = Integer.parseInt(br.readLine());
		if(ar[num-1]) {
			System.out.printf("%d��ġ�� ����\n", num);
			ar[num-1] = false;
		}else {
			System.out.println("�����Ǿ� �����ʽ��ϴ�");
		}
	}
	
	public void list(boolean[] ar) {
		for(int i = 0; i < ar.length; i++) {
			System.out.printf("%d��ġ : %s\n", i+1, ar[i]);
		}
	}
}
