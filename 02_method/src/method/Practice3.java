package method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// �ʸ� �Է¹޾Ƽ� time()���� ��,��,�ʸ� ���Ͽ� ����Ѵ�

// [������]
// �ʸ� �Է��Ͻÿ� : 3850
// 1�ð� 4�� 10�� �Դϴ�

public class Practice3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Practice3 c = new Practice3();
		
		System.out.print("�ʸ� �Է��Ͻÿ� : ");
		int sec = Integer.parseInt(br.readLine());
		c.time(sec);
		System.out.println("===== ���α׷��� �����մϴ�. =====");
	}
	
	public void time(int sec) {
		int hour = sec / 3600;
		int minute = sec % 3600 / 60;
		int second = sec % 60;
		System.out.printf("%d�ð� %d�� %d���Դϴ�.", hour, minute, second);
	}
}
