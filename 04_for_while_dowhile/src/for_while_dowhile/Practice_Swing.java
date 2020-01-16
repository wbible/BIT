package for_while_dowhile;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Practice_Swing extends JFrame{
	private final static int FRAME_WIDTH = 500;
	private final static int FRAME_HEIGHT = 500;
	private final static String IMG_PATH = "D:\\lib\\img\\";
	public final int LB_WIDTH = 200;
	public final int LB_HEIGHT = 120;
	
	public Practice_Swing() {
		
		super("가위바위보 게임");
		setLayout(new BorderLayout(10, 10));
		
		// 윈도우를 스크린 중앙에 위치
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((int)screen.getWidth() / 2 - (FRAME_WIDTH / 2), (int)screen.getHeight() / 2 - (FRAME_HEIGHT / 2), 500, 500);
		
		JPanel p1 = new JPanel();
		JLabel title = new JLabel("날 이겨보세요!");
		p1.add(title, BorderLayout.NORTH);
		add(p1);
		
		// 컴퓨터 이미지 아이콘 등록 + 레이블 크기에 맞추어 리사이즈 
		JPanel p_computer = new JPanel();
		p_computer.setLayout(new BorderLayout(20,20));
		p1.add(p_computer, BorderLayout.WEST);
		
		JLabel l_computer = new JLabel();
		l_computer.setSize(LB_WIDTH, LB_HEIGHT);
		
		ImageIcon i_computer = new ImageIcon(IMG_PATH+"computer.png");
		Image scaledImg = i_computer.getImage().getScaledInstance(l_computer.getWidth(), l_computer.getHeight(), Image.SCALE_SMOOTH);
		i_computer = new ImageIcon(scaledImg);
		l_computer.setIcon(i_computer);

		p_computer.add(l_computer);
		
		// 사람 이미지 아이콘 등록 + 레이블 크기에 맞추어 리사이즈 
		JPanel p_user = new JPanel();
		p_user.setLayout(new BorderLayout(20,20));
		p1.add(p_user, BorderLayout.EAST);
		
		JLabel l_user = new JLabel();
		l_user.setSize(LB_WIDTH, LB_HEIGHT);
		
		ImageIcon i_user = new ImageIcon(IMG_PATH+"user.png");
		scaledImg = i_user.getImage().getScaledInstance(l_user.getWidth(), l_user.getHeight(), Image.SCALE_SMOOTH);
		i_user = new ImageIcon(scaledImg);
		l_user.setIcon(i_user);
		p_user.add(l_user);
		
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		Practice_Swing p = new Practice_Swing();
	}

}
