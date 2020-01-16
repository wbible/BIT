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
		System.out.println("���α׷��� �����մϴ�. �̿����ּż� �����մϴ�.");
		
	}
	
	public void menu() {
		Scanner sc = new Scanner(System.in);
		String inputString;
		
		while(true) {
			System.out.println("*************");
			System.out.println("   1. ����");
			System.out.println("   2. ���");
			System.out.println("   3. ����");
			System.out.println("   4. Ż��");
			System.out.println("   5. ������");
			System.out.println("*************");
			System.out.print("��ȣ : ");
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
				System.out.println("�Է°��� �߸��Ǿ����ϴ�. �ٽ� �Է����ּ���.");
			}
		}
	}

	public void insert(MemberDTO[] member, Scanner sc) {
		String phone = "";
		int index = getBlankIndex(member);
		if (index == -1) {
			System.out.println(member.length + "���� ������ �� á���ϴ�..."); return;}
		
		System.out.print("�̸� �Է� : ");
		member[index].setName(sc.nextLine());
		System.out.print("���� �Է� : ");
		member[index].setAge(sc.nextInt());
		sc.nextLine();
		System.out.print("�ڵ��� �Է� : ");
		phone = sc.nextLine();
		while(phone.length() == 0) {
			System.out.printf("�ڵ��� ��ȣ�� �ʼ� �Է»����Դϴ�. �ٽ� �Է����ּ���.\n�ڵ��� �Է� : ");
			phone = sc.nextLine();
		};
		member[index].setPhone(phone);
		System.out.print("�ּ� �Է� : ");
		member[index].setAddress(sc.nextLine());
		
		System.out.println("1 row created");
		System.out.println(getBlankCount(member) + "�ڸ� ���ҽ��ϴ�.");
		
	}

	public void list(MemberDTO[] member) {
		System.out.printf("�̸�\t����\t�ڵ���\t\t�ּ�\n");
		if(getBlankCount(member) == member.length) System.out.println("---------- ��ϵ� ȸ�� ���� ----------");
		else {
			for(MemberDTO m : member) {
				if(m.getPhone().length()!=0) {
					printMember(m);;
				}
			}
		}
	}

	public void update(MemberDTO[] member, Scanner sc) {
		System.out.print("�ڵ��� ��ȣ �Է� : ");
		String input = sc.nextLine();
		int count = 0;
		int index = getMemberIndex(member, input);
		if (index == -1) System.out.println("ã�� ȸ���� �����ϴ�.");
		else {
			while(index >= 0) {
				System.out.printf("�̸�\t����\t�ڵ���\t\t�ּ�\n");
				printMember(member[index]);
				System.out.print("���� �� �̸� �Է� : ");
				member[index].setName(sc.nextLine());
				System.out.print("���� �� �ڵ��� �Է� : ");
				member[index].setPhone(sc.nextLine());
				System.out.print("���� �� �ּ� �Է� : ");
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
		System.out.print("�ڵ��� ��ȣ �Է� : ");
		String input = sc.nextLine();
		int index = getMemberIndex(member, input);
		int count = 0;
		if(index == -1) System.out.println("ã�� ȸ���� �����ϴ�.");
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
