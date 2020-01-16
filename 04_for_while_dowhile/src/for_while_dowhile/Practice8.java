package for_while_dowhile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//[문제8] 계좌관리 프로그램
//예금, 출금, 잔고, 종료 기능을 제공하는 간단 계좌관리 프로그램을 작성하시오.
public class Practice8 {
	private int user;
	private int money = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Practice8 p = new Practice8(); 
		
		while(true) {
			p.setUser(-1);
			System.out.println("****************");
			System.out.println(" 1. 예금");
			System.out.println(" 2. 출금");
			System.out.println(" 3. 잔액");
			System.out.println(" 4. 종료");
			System.out.println("****************");
			System.out.print("번호 선택 : ");
			
			p.setUser(p.getNumber(br));
			if(p.getUser() == 1) {
				p.input(br);
			}else if(p.getUser() == 2) {
				p.output(br);
			}else if(p.getUser() == 3) {
				System.out.printf("당신의 잔액은 %d원입니다.\n", p.getMoney());
			}else {
				break;
			}
			
		}
		System.out.println("프로그램 종료");
		
	}
	
	public void input(BufferedReader br) throws IOException {
		int tmp;
		while(true){
			System.out.print("예금액 : ");
			tmp = getMoney(br);
			if(tmp % 10000 == 0) break;
			System.out.println("만원 단위로 입력하세요");
		}
		setMoney(getMoney() + tmp);
		System.out.printf("당신의 잔액은 %d원입니다.\n", getMoney());
	}
	
	public void output(BufferedReader br) throws IOException {
		System.out.print("출금액 : ");
		int tmp = getMoney(br);
		if(tmp > getMoney()) {
			System.out.printf("잔액이 부족합니다.\n");
		}else {
			setMoney(getMoney() - tmp);
		}
		System.out.printf("당신의 잔액은 %d원입니다.\n", getMoney());
	}
	
	public int getNumber(BufferedReader br) throws IOException {
		String tmp = br.readLine();
		// 숫자가 아닌 값이 입력된 경우 에러 메시지를 출력하고 프로그램 재실행
		while(tmp.split("[!0-9]").length > 0 || Integer.parseInt(tmp) > 4 || Integer.parseInt(tmp) == 0) {
			System.out.println("입력값이 잘못되었습니다. 다시 입력해주세요.");
			tmp = br.readLine();
		}
		// 숫자만 입력된 경우 그 값을 int 형으로 반환
		return Integer.parseInt(tmp);
	}
	
	public int getMoney(BufferedReader br) throws IOException {
		String tmp = br.readLine();
		// 숫자가 아닌 값이 입력된 경우 에러 메시지를 출력하고 프로그램 재실행
		while(tmp.split("[!0-9]").length > 0) {
			System.out.println("입력값이 잘못되었습니다. 다시 입력해주세요.");
			tmp = br.readLine();
		}
		// 숫자만 입력된 경우 그 값을 int 형으로 반환
		return Integer.parseInt(tmp);
	}
	
	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
}
