package io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteStream {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("data.txt");
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		int data = 0;
		while((data = bis.read()) != -1) {			
			System.out.print((char)data);
		}
		bis.close();
	}
}

// ���� ���ε� (JSP-�� �� �����, Spring)
// ���� �ٿ�ε�
// ���� - 2byte (\r\n)