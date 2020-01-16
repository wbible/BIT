package nested;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RGBTest extends JFrame {

	class DrCanvas extends Canvas{
		public DrCanvas() {
			setBackground(new Color(255,200,255));
		}
	}
	
	private JButton redB, greenB, blueB;
	private DrCanvas can;
	
	public RGBTest() {
		setBounds(700,100,300,400);
		Container c = getContentPane();
		
		redB = new JButton(new ImageIcon("16-arrow-left.png"));
		greenB = new JButton(new ImageIcon("16-arrow-up.png"));
		blueB = new JButton(new ImageIcon("16-arrow-right.png"));
		JButton[] btn_list = {redB, greenB, blueB};
		
		can = new DrCanvas();
		
		JPanel p = new JPanel(); 
		for(JButton btn : btn_list) {
			p.add(btn);
			btn.setPreferredSize(new Dimension(70,30));
		}
		
		c.add("North", p);
		c.add("Center", can);
		
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		redB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				can.setBackground(new Color(255,0,0));
			}
		});
		greenB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				can.setBackground(new Color(0,255,0));
			}
		});
		blueB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				can.setBackground(new Color(0,0,255));
			}
		});
	}
	
	public static void main(String[] args) {
		new RGBTest();
	}

}
