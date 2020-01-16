package constructor;

import java.util.Scanner;

public class MemberMain {
	MemberDTO[] member = new MemberDTO[5];

	public static void main(String[] args) {
		MemberMain m_main = new MemberMain();
		for(int i = 0; i < m_main.member.length; i++) {
			m_main.member[i] = new MemberDTO();
		}
		m_main.menu();
		System.out.println("프로그램을 종료합니다. 이용해주셔서 감사합니다.");
		
	}
	
	public void menu() {
		Scanner sc = new Scanner(System.in);
		String inputString;
		
		while(true) {
			System.out.println("*************");
			System.out.println("   1. 가입");
			System.out.println("   2. 출력");
			System.out.println("   3. 수정");
			System.out.println("   4. 탈퇴");
			System.out.println("   5. 끝내기");
			System.out.println("*************");
			System.out.print("번호 : ");
			inputString = sc.nextLine();
			switch(inputString) {
			case "1":
				insert(member, sc);
				break;
			case "2":
				list(member);
				break;
			case "3":
				update(member, sc);
				break;
			case "4":
				delete(member, sc);
				break;
			case "5":
				return;
			default:
				System.out.println("입력값이 잘못되었습니다. 다시 입력해주세요.");
			}
		}
	}

	public void insert(MemberDTO[] member, Scanner sc) {
		String phone = "";
		int index = getBlankIndex(member);
		if (index == -1) {
			System.out.println(member.length + "명의 정원이 꽉 찼습니다..."); return;}
		
		System.out.print("이름 입력 : ");
		member[index].setName(sc.nextLine());
		System.out.print("나이 입력 : ");
		member[index].setAge(sc.nextInt());
		sc.nextLine();
		System.out.print("핸드폰 입력 : ");
		phone = sc.nextLine();
		while(phone.length() == 0) {
			System.out.printf("핸드폰 번호는 필수 입력사항입니다. 다시 입력해주세요.\n핸드폰 입력 : ");
			phone = sc.nextLine();
		};
		member[index].setPhone(phone);
		System.out.print("주소 입력 : ");
		member[index].setAddress(sc.nextLine());
		
		System.out.println("1 row created");
		System.out.println(getBlankCount(member) + "자리 남았습니다.");
		
	}

	public void list(MemberDTO[] member) {
		System.out.printf("이름\t나이\t핸드폰\t\t주소\n");
		if(getBlankCount(member) == member.length) System.out.println("---------- 등록된 회원 없음 ----------");
		else {
			for(MemberDTO m : member) {
				if(m.getPhone().length()!=0) {
					printMember(m);;
				}
			}
		}
	}

	public void update(MemberDTO[] member, Scanner sc) {
		System.out.print("핸드폰 번호 입력 : ");
		String input = sc.nextLine();
		int count = 0;
		int index = getMemberIndex(member, input);
		if (index == -1) System.out.println("찾는 회원이 없습니다.");
		else {
			while(index >= 0) {
				System.out.printf("이름\t나이\t핸드폰\t\t주소\n");
				printMember(member[index]);
				System.out.print("수정 할 이름 입력 : ");
				member[index].setName(sc.nextLine());
				System.out.print("수정 할 핸드폰 입력 : ");
				member[index].setPhone(sc.nextLine());
				System.out.print("수정 할 주소 입력 : ");
				member[index].setAddress(sc.nextLine());
				count++;
				index = getMemberIndex(member, input);
			}
			System.out.printf("%d row(s) updated\n", count);
		}
	}
	
	public void printMember(MemberDTO member) {
		System.out.printf("%s\t%d\t%s\t%s\n", 
				member.getName(), member.getAge(), 
				member.getPhone(), member.getAddress());
	}
	
	public int getBlankIndex(MemberDTO[] member) {
		for(int i = 0; i < member.length; i++) {
			if(member[i].getPhone().length()==0) return i;
		}
		return -1;
	}
	
	public int getMemberIndex(MemberDTO[] member, String phone) {
		for(int i = 0; i < member.length; i++) {
			if(member[i].getPhone().equals(phone)) return i;
		}
		return -1;
	}
	
	public int getBlankCount(MemberDTO[] member) {
		int count = 0;
		for(int i = 0; i < member.length; i++) {
			if(member[i].getPhone().length() == 0) count++;
		}
		return count;
	}

	public void delete(MemberDTO[] member, Scanner sc) {
		System.out.print("핸드폰 번호 입력 : ");
		String input = sc.nextLine();
		int index = getMemberIndex(member, input);
		int count = 0;
		if(index == -1) System.out.println("찾는 회원이 없습니다.");
		else {
			while(index >= 0) {
				member[index] = new MemberDTO();
				index = getMemberIndex(member, input);
				count++;
			}
			System.out.printf("%d row(s) deleted\n", count);
		}
	}
}
