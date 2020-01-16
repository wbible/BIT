package constructor;

import java.text.DecimalFormat;

public class SalaryMain {
	public static void main(String[] args) {
		SalaryDTO[] s = new SalaryDTO[3];
		DecimalFormat df = new DecimalFormat("#,###.##");
		
		s[0] = new SalaryDTO("ȫ�浿", "����", 5000000, 200000);
		s[1] = new SalaryDTO("���缮", "����", 3500000, 150000);
		s[2] = new SalaryDTO("�ڸ��", "���", 1800000, 100000);
		
		System.out.printf("�̸�\t����\t�⺻��\t\t����\t����\t����\t����\n");
		for(SalaryDTO ss : s) {
			ss.calc();
			System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s\n",
					ss.getName(), ss.getPosition(), df.format(ss.getBasePay()), 
					df.format(ss.getBenefit()), df.format(ss.getTaxRate()),
					df.format(ss.getTax()), df.format(ss.getSalary()));
		}
		
		
	}
}
