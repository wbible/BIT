package thread;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

public class RunRace extends Frame implements ActionListener{
	private static final int FRAME_WIDTH = 600;
	private static final int FRAME_HEIGHT = 500;
	private static final int BTN_WIDTH = 200;
	private static final int BTN_HEIGHT = 30;
	private static final int GAP = 10;
	
	private int count;
	private String[] name;
	private Racer[] r;
	
	private Button btn;
	
	public RunRace(int count, String[] name) {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((int) ((screen.getWidth() - FRAME_WIDTH) / 2), (int) ((screen.getHeight() - FRAME_HEIGHT) / 2),
				FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);
		setTitle("경마 게임");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		this.count = count;
		this.name = name;
		
		Panel p = new Panel(new FlowLayout(FlowLayout.RIGHT));
		add("South", p);
				
		Label lb_time = new Label("", Label.CENTER);
		p.add(lb_time);
		p.setBackground(Color.DARK_GRAY);
		lb_time.setPreferredSize(new Dimension(FRAME_WIDTH - BTN_WIDTH - 20, BTN_HEIGHT));
		lb_time.setForeground(Color.white);
		lb_time.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		
		btn = new Button("출발");
		btn.setPreferredSize(new Dimension(BTN_WIDTH, BTN_HEIGHT));
		btn.addActionListener(this);
		p.add(btn);
		
		Panel p2 = new Panel();
		add("Center", p2);
		p2.setLayout(new GridLayout(count, 1));
		
		
		r = new Racer[count];
		for(int i = 0; i < count; i++) {
			r[i] = new Racer(name[i], count, lb_time); // 캔버스 생성
			p2.add(r[i]);
		}
		setVisible(true);
		setAlwaysOnTop(true);
		toFront();
		requestFocus();
		setAlwaysOnTop(false);
		repaint();
//		setState(Frame.NORMAL);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Thread[] t = new Thread[count];
		for(int i = 0; i < count; i++) {
			t[i] = new Thread(r[i]); // 스레드 생성
			t[i].setPriority((int)(Math.random()*10)+1);
			t[i].start();
		}
		btn.setEnabled(false);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("경주마 수 : ");
		int count = scan.nextInt();
		scan.nextLine();
		
		String[] name = new String[count];
		for (int i =0; i < count; i++) {
			System.out.print((i+1) + "번째 경주마 이름 입력 : ");
			name[i] = scan.nextLine();
		}
		
		new RunRace(count, name);
	}

}
