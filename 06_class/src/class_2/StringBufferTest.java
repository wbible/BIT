package class_2;

import java.util.Scanner;

public class StringBufferTest {
	private int dan;
	StringBufferTest(){
		Scanner sc = new Scanner(System.in);
		System.out.print("원하는 단을 입력 : ");
		dan = sc.nextInt();
		System.out.println();
		sc.close();
	}
	
	public void output() {
		StringBuffer sb = new StringBuffer();
		
		for (int i = 1; i < 10; i++) {
			sb.append(dan);
			sb.append(" * ");
			sb.append(i);
			sb.append(" = " );
			sb.append(dan * i);
			System.out.println(sb.toString());
			sb = sb.delete(0, sb.length());
		}
	}
	
	public static void main(String[] args) {
		StringBufferTest sbt = new StringBufferTest();
		sbt.output();
		
	}
}
