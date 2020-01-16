package interface_1;

import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

// Frame�� BorderLayout(��������)���� �����ִ�.
public class WindowTest2 extends Frame implements WindowListener, ActionListener{
	public static final int FRAME_WIDTH = 300;
	public static final int FRAME_HEIGHT = 400;
	private Button exitB, newB;
	private TextArea area;
	
	public void init() {
		setTitle("���� ���� ������");
		setBounds(800, 300, FRAME_WIDTH, FRAME_HEIGHT);
		addWindowListener(this);
		
		area = new TextArea();
		newB = new Button("���θ����");
		exitB = new Button("    ������    ");
		
		Panel p = new Panel();  // FlowLayout (������ġ - �߾� ����)
		add("North", p);
		p.setBackground(new Color(255,190,100));
		p.add(newB);
		p.add(exitB);
	
		add("Center", area);
		
		newB.addActionListener(this);
		exitB.addActionListener(this);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new WindowTest2().init();
		
	}
	
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == exitB) System.exit(0);
		if (e.getSource() == newB) {
			area.setText(" ");
			area.setText("");
		}
	}

}
