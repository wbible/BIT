package inheritance;

import java.util.Scanner;

class ShapeTest {
	protected Scanner scan = new Scanner(System.in);
	protected double area;
	public ShapeTest() {
		System.out.println("ShapeTest �⺻������");
	}
	public void calcArea() {
		System.out.println("������ ����մϴ�.");
	}
	public void dispArea() {
		System.out.println("������ ����մϴ�.");
	}
}

class SamTest extends ShapeTest{ 
	private int base, height;
	public SamTest() {
		System.out.println("SamTest �⺻������");
		System.out.print("�غ� : ");
		base = scan.nextInt();
		System.out.print("���� : ");
		height = scan.nextInt();
		scan.nextLine();
	}
	@Override
	public void calcArea() {
		area = base*height/2.;
	}
	@Override
	public void dispArea() {
		System.out.println("�ﰢ�� ���� = " + area);
	}
}

class SaTest extends ShapeTest{ 
	private int width, height;
	public SaTest() {
		System.out.println("SaTest �⺻������");
		System.out.print("���� : ");
		width = scan.nextInt();
		System.out.print("���� : ");
		height = scan.nextInt();
		scan.nextLine();
	}
	@Override
	public void calcArea() {
		area = width * height;
	}
	@Override
	public void dispArea() {
		System.out.println("�簢�� ���� = " + area);
	}
}

class SadanTest extends ShapeTest{ 
	private int top, bottom, height;
	public SadanTest() {
		System.out.println("SadanTest �⺻������");
		System.out.print("���� : ");
		top = scan.nextInt();
		System.out.print("�غ� : ");
		bottom = scan.nextInt();
		System.out.print("���� : ");
		height = scan.nextInt();
		scan.nextLine();
	}
	@Override
	public void calcArea() {
		area = (top + bottom) * height /2.;
	}
	@Override
	public void dispArea() {
		System.out.println("��ٸ��� ���� = " + area);
	}
}

public class ShapeMain {
	public static void main(String[] args) {
//		SamTest sam = new SamTest();
//		sam.calcArea();
//		sam.dispArea();
//		
//		SaTest sa = new SaTest();
//		sa.calcArea();
//		sa.dispArea();
//		
//		SadanTest sadan = new SadanTest();
//		sadan.calcArea();
//		sadan.dispArea();
		
		ShapeTest shape = new SamTest(); // ���յ� ���߱�, �θ� =�ڽ�, �ڽ� =(�ڽ�)�θ�
		shape.calcArea();
		shape.dispArea();
		
	}
}
