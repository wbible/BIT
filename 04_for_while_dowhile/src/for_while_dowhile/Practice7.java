package for_while_dowhile;
//[����7] ������ 
//3�� for�� ����ϼ���
public class Practice7 {
	public static void main(String[] args) {
		for (int j = 0; j <= 3; j = j+3) {
			for (int i = 1; i <= 9; i++) {
				for (int dan = 2; dan <= 4; dan++) {
					System.out.printf("%d*%d=%d\t", dan+j, i, (dan+j) * i);
					if (dan == 4)
						System.out.println();
				}
			}
			System.out.println();
		}
	}
}
