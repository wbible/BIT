package exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionTest2 {
	private int dan;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		ExceptionTest2 et = new ExceptionTest2();
		et.input();
		et.output();

	}
	
	public void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("���ϴ� �� �Է� : ");
		dan = Integer.parseInt(br.readLine());
		
	}
	public void output() {
		if (dan > 9 || dan < 1) {
//			System.out.println("���� �ʰ� (2~9)������ ����");
			try {				
//				throw new Exception("���� �ʰ� (2~9)������ ����");
				throw new MakeException("���� �ʰ� (2~9)������ ����");
			}catch(Exception e) {
				e.printStackTrace();
			}
			return;
		}
		
		for (int i = 1; i < 10; i++) {
			System.out.print(dan + "*" + i + "=" + dan*i + "\n");
		}
		
	}

}
