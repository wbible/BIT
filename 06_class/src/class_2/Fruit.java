package class_2;

public class Fruit {
	private String pum;
	private int jan, feb, mar, tot;
	private static int sumJan, sumFeb, sumMar;
	
	public Fruit(String pum, int jan, int feb, int mar) {
		this.pum = pum;
		this.jan = jan;
		this.feb = feb;
		this.mar = mar;
		calcTot();
	}
	
	public void calcTot() {
		tot = jan + feb + mar;
		sumJan += jan;
		sumFeb += feb;
		sumMar += mar;
	}
	
	public void display() {
		System.out.printf("%s\t%d\t%d\t%d\t%d\n", pum, jan, feb, mar, tot);
	}
	
	public static void output() {
		System.out.printf("\t%d\t%d\t%d\n", sumJan, sumFeb, sumMar);
	}
}
