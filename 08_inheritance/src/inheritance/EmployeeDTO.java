package inheritance;
//월급 =  기본급 + 수당 - (기본급 + 수당) * 세율
public class EmployeeDTO {
	private String name;
	private String title;
	private int base;
	private int bonus;
	private double taxRate;
	private int salary;
	
	public EmployeeDTO(String name) {
		this.name = name;
	}
	
	public EmployeeDTO(String name, String title, int base, int bonus) {
		this.name = name;
		updateDTO(title, base, bonus);
		salaryCalc();
	}
	
	public void updateDTO(String title, int base, int bonus) {
		this.title = title;
		this.base = base;
		this.bonus = bonus;
		salaryCalc();
	}
	
	public String getName() {
		return name;
	}

	public String getTitle() {
		return title;
	}

	public int getBase() {
		return base;
	}

	public int getBonus() {
		return bonus;
	}

	public int getSalary() {
		return salary;
	}
	public double getTaxRate() {
		return taxRate;
	}
	
	public void salaryCalc() {
		if(base <= 2000000) taxRate = 0.01;
		else if (base <= 4000000) taxRate = 0.02;
		else taxRate = 0.03;
		
		salary = base + bonus - (int)((base + bonus) * taxRate);
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof EmployeeDTO) {
			EmployeeDTO e = (EmployeeDTO) o;
			if (name.equals(e.getName())) return true;
		}
		return false;
	}
	
	
}
