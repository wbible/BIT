package instance;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.*;

public class CompTest {
	public static void main(String[] args) {

		JFrame frame1 = new JFrame("Console Window");
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int width = 500;
		int height = 400;
		
		frame1.setBounds((int)(screen.getWidth()/2-width/2),(int)(screen.getHeight()/2-height/2),width,height);
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(10, 1));
		frame1.add(p1);

		int score = 95;
		String result = score >= 80 && score <= 100 ? "�հ�" : "���հ�";
		addLabel(p1, "����� '" + result + "'�Դϴ�.");

		result = score % 2 == 0 ? "¦��" : "Ȧ��";
		addLabel(p1, "��� = " + result);

		int b = 80;
		addLabel(p1, "ū �� = " + (score >= b ? score : b));
		
		frame1.setVisible(true);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void addLabel(JPanel p, String str) {
		JLabel l1 = new JLabel(str);
		l1.setHorizontalAlignment(JLabel.CENTER);
		l1.setFont(l1.getFont().deriveFont(Font.PLAIN, 14.0f));
		p.add(l1);
	}
}
