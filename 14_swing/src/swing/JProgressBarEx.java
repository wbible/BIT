package swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class JProgressBarEx extends JFrame implements ActionListener, Runnable {
	private JProgressBar jpb = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
	private JButton btn_start = new JButton("시작");
	private JButton btn_stop = new JButton("멈춤");
	
	private boolean bb = true;
	private static int ii;
	
	public JProgressBarEx() {
		super("Test");
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		con.add("North", new JLabel("이것이 프로그레스 바이다."));
		con.add("Center", btn_start);
		jpb.setStringPainted(true);
		jpb.setString("0%");
		
		con.add("Center",jpb);
		JPanel jp = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jp.add(btn_start);jp.add(btn_stop);
		btn_start.addActionListener(this);
		btn_stop.addActionListener(this);
		
		con.add("South", jp);
		setSize(300, 150);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn_start) {
			bb = true;
			new Thread(this).start();
			btn_start.setEnabled(false);
			btn_stop.setEnabled(true);
		}else {
			bb = false;
			btn_start.setEnabled(true);
			btn_stop.setEnabled(false);
		}
		
	}

	@Override
	public void run() {
		if(ii == 100) ii = 0;
		for(int i = ii; i<= 100; i++) {
			if(!bb) break;
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			jpb.setValue(i);
			ii = i;
			jpb.setString(i + "%");
		}
		btn_start.setEnabled(true);
		btn_stop.setEnabled(false);
	}
	
	public static void main(String[] args) {
		new JProgressBarEx();
	}


}
