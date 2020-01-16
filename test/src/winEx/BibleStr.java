package winEx;

import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.regex.Matcher;

public class BibleStr {
	private String bible;
	private int chapter;
	private int verse;

	public String getBible() {
		return bible;
	}

	public void setBible(String bible) {
		this.bible = bible;
	}

	public int getChapter() {
		return chapter;
	}

	public void setChapter(int chapter) {
		this.chapter = chapter;
	}

	public int getVerse() {
		return verse;
	}

	public void setVerse(int verse) {
		this.verse = verse;
	}

	public BibleStr() {
		bible = "Ã¢";
		chapter = 1;
		verse = 1;
	}

	public int patternCheck(String input) {
		ArrayList<String> pStr = new ArrayList<>();
		pStr.add("^[0-9°¡-ÆR]+\\s[0-9]+\\s[0-9]+$");
		pStr.add("^[0-9°¡-ÆR]+\\s[0-9]+$");
		pStr.add("^[0-9]+\\s[0-9]+$");
		pStr.add("^[0-9]+$");

		Pattern p;
		Matcher m;
		for (String str : pStr) {
			p = Pattern.compile(str);
			m = p.matcher(input);
			if (m.find()) 
				return pStr.indexOf(str);
		}
		return -1;
	}

	public BibleStr getSearchStr(String input, int pattern) {
		BibleStr b = new BibleStr();
		if (pattern == 0) {
			b.setBible(input.split("\\s")[0]);
			b.setChapter(Integer.parseInt(input.split("\\s")[1]));
			b.setVerse(Integer.parseInt(input.split("\\s")[2]));
		} else if (pattern == 1) {
			b.setBible(input.split("\\s")[0]);
			b.setChapter(Integer.parseInt(input.split("\\s")[1]));
			b.setVerse(1);
		} else if (pattern == 2) {
			b.setChapter(Integer.parseInt(input.split("\\s")[0]));
			b.setVerse(Integer.parseInt(input.split("\\s")[1]));
		} else if (pattern == 3) {
			b.setVerse(Integer.parseInt(input));
		}
		return b;
	}

	public String toString() {
		return getBible() + getChapter() + ":" + getVerse();
	}

}
