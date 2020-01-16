package class_1;

public class SungjukMain1 {
	public static void main(String[] args) {
		Sungjuk aa = new Sungjuk();
		Sungjuk[] ar = new Sungjuk[3];
		for(int i = 0; i < ar.length; i++) {
			ar[i] = new Sungjuk();
		}
		
		
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		
		ar[0].setName("홍길동");
		ar[0].setKor(90);
		ar[0].setEng(90);
		ar[0].setMath(90);
		
		ar[1].setName("또치");
		ar[1].setKor(85);
		ar[1].setEng(78);
		ar[1].setMath(90);
		
		ar[2].setName("코난");
		ar[2].setKor(75);
		ar[2].setEng(98);
		ar[2].setMath(86);
		
		for(Sungjuk s: ar) {
			s.calc();
			System.out.println(s.getName() + "\t" + s.getKor() + "\t" + s.getEng() + "\t" + s.getMath()
					+ "\t" + s.getTot() + "\t" + String.format("%.2f", s.getAvg()));
		}
	}
}
