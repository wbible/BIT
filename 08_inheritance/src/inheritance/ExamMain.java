package inheritance;

import java.util.Scanner;

public class ExamMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("인원수 입력 : ");
		int num = sc.nextInt();
		sc.nextLine();
		sc.close();
		
		Exam ar[] = new Exam[num];
		for(int i = 0; i<num; i++) {
			ar[i] = new Exam();
			ar[i].compare();
			System.out.println();
		}
		
		System.out.println("이름	1 2 3 4 5	점수");
		for(Exam e: ar) {
			System.out.print(e.getName() + "\t");
			for(char c: e.getOx()) {
				System.out.print(c + " ");
			}
			System.out.printf("	%3d\n", e.getScore() * 20);
		}
		
	}
}
