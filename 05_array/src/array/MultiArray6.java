package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultiArray6 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt;
		
		System.out.print("인원수 : ");
		cnt = Integer.parseInt(br.readLine());
		String name[] = new String[cnt];
		int subjectCnt[] = new int[cnt]; 
		String[][] subject = new String[cnt][];
		double[][] jumsu = new double[cnt][];
		
		for(int i = 0; i < cnt; i++) {
			System.out.print("이름입력 : ");
			name[i] = br.readLine();
			System.out.print("과목 수 입력 : ");
			subjectCnt[i] = Integer.parseInt(br.readLine());
			subject[i] = new String[subjectCnt[i]];
			jumsu[i] = new double[subjectCnt[i] + 2];
			
			for(int j = 0; j < subjectCnt[i]; j++) {
				System.out.print("과목명 입력 : ");
				subject[i][j] = br.readLine();
			}
			for(int j = 0; j < subjectCnt[i]; j++) {
				System.out.printf("%s 점수 입력 : ", subject[i][j]);
				jumsu[i][j] = Integer.parseInt(br.readLine());
				jumsu[i][jumsu[i].length-2] += jumsu[i][j];
			}
			jumsu[i][jumsu[i].length-1] += jumsu[i][jumsu[i].length-2] / subjectCnt[i];
			System.out.println("---------------------");
		}
		
		for(int i = 0; i < cnt; i++) {
			System.out.print("이름\t");
			for(int j = 0; j < subjectCnt[i]; j++) {
				System.out.printf(subject[i][j]+"\t");
			}
			System.out.print("총점\t평균\n");
			
			System.out.print(name[i] + "\t");
			for(int j = 0; j < jumsu[i].length-1; j++) {
				System.out.printf("%3d\t", (int)jumsu[i][j]);
			}
			System.out.printf("%.2f\n", jumsu[i][jumsu[i].length-1]);
			System.out.println();
		}
		
		
	}
}
