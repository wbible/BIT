package inheritance;

import java.util.Scanner;

public class Exam {
	private String name;
	private String dap;
	private char[] ox = {'X', 'X', 'X', 'X', 'X'};
	private int score;
	private final String JUNG="11111";//����-���ȭ
	
	public Exam() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�̸� �Է� : ");
		name = sc.nextLine();
		System.out.print("�� �Է� : ");
		dap = sc.nextLine();
		sc.close();
	}
	
	public String getName() {
		return name;
	}
	
	public char[] getOx() {
		return ox;
	}
	
	public void compare() {
		for(int i = 0; i < JUNG.length(); i++) {
			if(JUNG.charAt(i) == dap.charAt(i)) {
				ox[i] = 'O'; score++; 
			}
		}
	}
	
	public int getScore() {
		return score;
	}

}
