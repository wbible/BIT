package thread;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.swing.JLabel;

public class Clock extends Frame implements Runnable{
	private JLabel lb_clock;
	public Clock() {
		setBounds(800, 200, 300, 100);
		lb_clock = new JLabel("", JLabel.CENTER);
		lb_clock.setBackground(Color.DARK_GRAY);
		lb_clock.setOpaque(true);
		lb_clock.setForeground(Color.WHITE);
		lb_clock.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		add(lb_clock);
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setVisible(true);
		
		// 스레드 생성
		Thread t = new Thread(this);
		t.start();
	}
	
	@Override
	public void run() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH시 mm분 ss초");
		while (true) {
			lb_clock.setText(sdf.format(new Date()));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Clock clock = new Clock();
		
	}

}
