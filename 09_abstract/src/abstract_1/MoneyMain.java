package abstract_1;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

abstract class Money{
	public double money, moneyLocal;
	NumberFormat numberFormat, numberFormatLocal;
	
	public Money(double money) {
		this.money = money;
		numberFormat = NumberFormat.getCurrencyInstance(Locale.KOREA);
		calcMoney();
	}
	public abstract void calcMoney();
	public abstract void dispMoney();
	
	public void disp(Locale l, double moneylocal) {
		numberFormatLocal = NumberFormat.getCurrencyInstance(l);
		System.out.printf("%s  ��  %s", numberFormat.format(money), moneylocal);
	}
}

class USMoney extends Money{
	private final double exchangeRate = 1157.50;
	public USMoney(double money) {super(money);}

	@Override
	public void calcMoney() {moneyLocal = money / exchangeRate;}
	@Override
	public void dispMoney() {disp(Locale.US, moneyLocal);}
	
}

class JapanMoney extends Money{
	private final double exchangeRate = 10.64;
	public JapanMoney(double money) {super(money);}
	@Override
	public void calcMoney() {moneyLocal = money / exchangeRate;}
	@Override
	public void dispMoney() {disp(Locale.JAPAN, moneyLocal);}
}

class ChinaMoney extends Money{
	private final double exchangeRate = 166.36;
	public ChinaMoney(double money) {super(money);}
	@Override
	public void calcMoney() {moneyLocal = money / exchangeRate;}
	@Override
	public void dispMoney() {disp(Locale.CHINA, moneyLocal);}
}

public class MoneyMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("���� �Է� : ");
		int moneyInput = scanner.nextInt();
		System.out.print("1. �޷�   2. ��ȭ   3. ����  : ");
		int currency = scanner.nextInt();
		scanner.close();
		
		Money money;
		if (currency == 1) money = new USMoney(moneyInput);
		else if (currency == 2) money = new JapanMoney(moneyInput);
		else if (currency == 3) money = new ChinaMoney(moneyInput);
		else {
			System.out.println("�Է°��� �߸��Ǿ����ϴ�.");
			return;
		}
		money.dispMoney();
	}

}
