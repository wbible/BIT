package inheritance;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class SalaryManager {
	private ArrayList<EmployeeDTO> members = new ArrayList<EmployeeDTO>();
	private Scanner sc = new Scanner(System.in); 
	String input;
	
	public void menu() {
		while(true) {
			System.out.println("------ ��Ʈ ���� ���� ���α׷� -----");
			System.out.println(" 1. ���");
			System.out.println(" 2. ���");
			System.out.println(" 3. ����");
			System.out.println(" 4. �˻�");
			System.out.println(" 5. ����");
			System.out.print("���Ͻô� �޴��� ��ȣ�� �������ּ���: ");
			
			input = sc.nextLine();
			if(input.equals("1")) {// ��� 
				insert();
			}else if(input.equals("2")) {// ��� 
				disp();
			}else if(input.equals("3")) {// ���� 
				update();
			}else if(input.equals("4")) {// �˻� 
				search(searchIndex("�˻��� ȸ���� �̸�"));
			}else if(input.equals("5")) {// ����
				System.out.println("�̿����ּż� �����մϴ�.");
				 return;
			}else {
				System.out.println("�Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
			}
		}
	}
	
	public void insert() {	
		members.add(new EmployeeDTO(scanString("����� ����� �̸�"), scanString("����"), scanInt("�⺻��"), scanInt("����")));
		System.out.println("����� �Ϸ�Ǿ����ϴ�.");
	}
	
	public void dispColumn() {
		System.out.println("---------------------------------");
		System.out.println("�̸�	����	�⺻��	����	����	����");
	}
	
	public void disp() { 
		if(!members.isEmpty()) {			
			dispColumn();
			for(EmployeeDTO e: members) dispOne(e);
		}else {
			System.out.println("��ϵ� ����� �����ϴ�.");
		}
		
	}
	
	public void dispOne(EmployeeDTO e) { 
		DecimalFormat df = new DecimalFormat("#,###.#");
		System.out.printf("%s	%s	%s	%s	%.2f	%s\n", 
				e.getName(), e.getTitle(), df.format(e.getBase()), df.format(e.getBonus()),
				e.getTaxRate(), df.format(e.getSalary()));
	}
	
	public void update() {
		int index = searchIndex("������ ����� �̸�");
		if(index != -1) members.get(index).updateDTO(scanString("����"), scanInt("�⺻��"), scanInt("����"));
	}
	
	public void search(int index) {
		dispColumn();
		if(index != -1) dispOne(members.get(index));
	}
	
	public int searchIndex(String str) {
		String name; int index;
		index = members.indexOf(new EmployeeDTO(scanString(str)));
		while(index == -1) {
			System.out.println("����� ã�� �� �����ϴ�. �ٽ� �Է����ּ���. (���: 0)");
			name = sc.nextLine();
			if(name.equals("0")) return -1;
			index = members.indexOf(new EmployeeDTO(scanString(str)));
		}
		return index;
	}
	
	public String scanString(String column) {
		System.out.print(column + "��(��) �Է��ϼ���: ");
		return sc.nextLine();
	}
	
	public int scanInt(String column) {
		System.out.print(column + "��(��) �Է��ϼ���: ");
		String tmp = sc.nextLine();
//		while(Pattern.matches("^[!0-9]{1}+$", tmp)) {
//			System.out.println("�Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
//			tmp = sc.nextLine();
//		}
		return Integer.parseInt(tmp);
	}
	
}
