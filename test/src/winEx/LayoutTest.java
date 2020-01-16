package winEx;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class LayoutTest extends JFrame {

	public LayoutTest() {
		setBounds(900, 200, 500, 300);
		
		Container c = getContentPane();
		JTextField t1 = new JTextField();
		c.add("West", t1);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new LayoutTest();
		
	}

}
