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
			System.out.println("------ 비트 월급 관리 프로그램 -----");
			System.out.println(" 1. 등록");
			System.out.println(" 2. 출력");
			System.out.println(" 3. 수정");
			System.out.println(" 4. 검색");
			System.out.println(" 5. 종료");
			System.out.print("원하시는 메뉴의 번호를 선택해주세요: ");
			
			input = sc.nextLine();
			if(input.equals("1")) {// 등록 
				insert();
			}else if(input.equals("2")) {// 출력 
				disp();
			}else if(input.equals("3")) {// 수정 
				update();
			}else if(input.equals("4")) {// 검색 
				search(searchIndex("검색할 회원의 이름"));
			}else if(input.equals("5")) {// 종료
				System.out.println("이용해주셔서 감사합니다.");
				 return;
			}else {
				System.out.println("입력값이 올바르지 않습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void insert() {	
		members.add(new EmployeeDTO(scanString("등록할 사원의 이름"), scanString("직급"), scanInt("기본급"), scanInt("수당")));
		System.out.println("등록이 완료되었습니다.");
	}
	
	public void dispColumn() {
		System.out.println("---------------------------------");
		System.out.println("이름	직급	기본급	수당	세율	월급");
	}
	
	public void disp() { 
		if(!members.isEmpty()) {			
			dispColumn();
			for(EmployeeDTO e: members) dispOne(e);
		}else {
			System.out.println("등록된 사원이 없습니다.");
		}
		
	}
	
	public void dispOne(EmployeeDTO e) { 
		DecimalFormat df = new DecimalFormat("#,###.#");
		System.out.printf("%s	%s	%s	%s	%.2f	%s\n", 
				e.getName(), e.getTitle(), df.format(e.getBase()), df.format(e.getBonus()),
				e.getTaxRate(), df.format(e.getSalary()));
	}
	
	public void update() {
		int index = searchIndex("수정할 사원의 이름");
		if(index != -1) members.get(index).updateDTO(scanString("직급"), scanInt("기본급"), scanInt("수당"));
	}
	
	public void search(int index) {
		dispColumn();
		if(index != -1) dispOne(members.get(index));
	}
	
	public int searchIndex(String str) {
		String name; int index;
		index = members.indexOf(new EmployeeDTO(scanString(str)));
		while(index == -1) {
			System.out.println("사원을 찾을 수 없습니다. 다시 입력해주세요. (취소: 0)");
			name = sc.nextLine();
			if(name.equals("0")) return -1;
			index = members.indexOf(new EmployeeDTO(scanString(str)));
		}
		return index;
	}
	
	public String scanString(String column) {
		System.out.print(column + "을(를) 입력하세요: ");
		return sc.nextLine();
	}
	
	public int scanInt(String column) {
		System.out.print(column + "을(를) 입력하세요: ");
		String tmp = sc.nextLine();
//		while(Pattern.matches("^[!0-9]{1}+$", tmp)) {
//			System.out.println("입력값이 올바르지 않습니다. 다시 입력해주세요.");
//			tmp = sc.nextLine();
//		}
		return Integer.parseInt(tmp);
	}
	
}
