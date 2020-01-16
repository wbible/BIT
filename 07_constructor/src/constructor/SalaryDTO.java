package constructor;

public class SalaryDTO {
	private String name;
	private String position;
	private int basePay;
	private int benefit;
	private double taxRate;
	private int tax;
	public String getName() {
		return name;
	}

	public String getPosition() {
		return position;
	}

	public int getBasePay() {
		return basePay;
	}

	public int getBenefit() {
		return benefit;
	}

	public double getTaxRate() {
		return taxRate;
	}

	public int getTax() {
		return tax;
	}

	public int getSalary() {
		return salary;
	}

	private int salary;
	
	public SalaryDTO(String name, String position, int basePay, int benefit) {
		this.name = name;
		this.position = position;
		this.basePay = basePay;
		this.benefit = benefit;
	}
	
	public void calc() {
		if (basePay <= 2000000) taxRate = 0.01;
		else if (basePay <= 4000000) taxRate = 0.02;
		else taxRate = 0.03;
		tax = (int) ((basePay + benefit) * taxRate); 
		salary = basePay + benefit - tax;
	}
}
