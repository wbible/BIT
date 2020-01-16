package winEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BibleEx {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BibleStr c = new BibleStr();

		System.out.print("검색하실 성구를 입력하세요: ");
		String input = br.readLine().trim();

		c = c.getSearchStr(input, c.patternCheck(input));
		System.out.println(c);
	}
}
