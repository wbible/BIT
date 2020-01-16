package array;

public class MultiArray4 {
	public static void main(String[] args) {
		String[] name = {"홍길동", "코난", "또치"};
		int[][] jumsu = {{90, 95, 100, 0}, {100, 89, 75, 0},{75, 80, 48, 0}};
		double avg[] = new double[name.length];
		String[] grade = new String[name.length];
		
		String dash = "----------------------------------------------------";
		System.out.println(dash);
		System.out.printf("이름\t국어\t영어\t수학\t총점\t평균\t학점\n");
		System.out.println(dash);
		for (int i = 0; i < name.length; i++) {
			System.out.printf("%s\t", name[i]);
			for (int j = 0; j < 3; j++){
				jumsu[i][3] += jumsu[i][j];
				System.out.printf("%3d\t", jumsu[i][j]);
			}
			avg[i] = jumsu[i][3] / 3.0;
			switch (jumsu[i][3] / 30) {
			case 10:
			case 9: grade[i] = "A"; break;
			case 8: grade[i] = "B"; break;
			case 7: grade[i] = "C"; break;
			case 6: grade[i] = "D"; break;
			case 5: grade[i] = "E"; break;
			default: grade[i] = "F";
			}
			System.out.printf("%3d\t%.2f\t%s\n", jumsu[i][3], avg[i], grade[i]);
		}
		System.out.println(dash);
	}
}
