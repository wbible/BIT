package winEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IdxCheckEx {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		IdxCheckEx c = new IdxCheckEx();
		
		System.out.print("�ֹε�Ϲ�ȣ ��ȿ�� �˻�: ");
		String inputStr = br.readLine();
		
		System.out.println(c.idxCheck(inputStr) ? "��ȿ�մϴ�." : "��ȿ���� �ʽ��ϴ�.");
		
	}
	
	public boolean idxCheck(String str) {		
		String pStr = "^[0-9]{6}-[0-9]{7}$";
		Pattern p = Pattern.compile(pStr);
		Matcher m = p.matcher(str);
		return m.find();
	}

}