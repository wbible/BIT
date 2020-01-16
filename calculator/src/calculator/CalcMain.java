package calculator;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class CalcMain extends JFrame {
	public static final int FRAME_WIDHT = 300;
	public static final int FRAME_HEIGHT = 400;
	public static final int BTN_WIDHT = 65;
	public static final int BTN_HEIGHT = 30;
	public static final int BTN_GAP = 8;
	public static final int LABEL_HEIGHT = 100;
	
	public CalcMain() {
		super("°è»ê±â");
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((int)((screen.getWidth()-FRAME_WIDHT)/2),(int)((screen.getHeight()-FRAME_HEIGHT)/2),
				FRAME_WIDHT, FRAME_HEIGHT);
		
		Container con = getContentPane();
		con.setLayout(null);
		
		JLabel label_top = new JLabel(new ImageIcon("D:\\lib\\img/window.jpg"));
		con.add(label_top);
		
		label_top.setHorizontalAlignment(SwingConstants.RIGHT);
		label_top.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
		con.add(label_top);
		label_top.setBounds(0, 0, FRAME_WIDHT, LABEL_HEIGHT);
		
		
		
		for(int i = 0; i < 4; i++) {
			JButton btn = new JButton();
			btn.setBounds(BTN_GAP + (BTN_GAP+BTN_WIDHT)*i, BTN_GAP + LABEL_HEIGHT, BTN_WIDHT, BTN_HEIGHT);
			con.add(btn);
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		CalcMain w = new CalcMain();
		
		
	}
}
