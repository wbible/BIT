package thread;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class Racer extends Canvas implements Runnable{
	private String name;
	private Image img;
	private int x, y;
	private static Date startTime;
	public static int rank;
	public static String result;
	private int finish;
	private long timeDiff;
	private Label lb_time;
	DecimalFormat df = new DecimalFormat("###.00");
	
	public Racer(String name, int finish, Label lb_time) {
//		setBackground(new Color((int)(Math.random()*256), (int)(Math.random()*256),(int)(Math.random()*256)));
		this.name = name;
		this.finish = finish;
		this.lb_time = lb_time;
		img = Toolkit.getDefaultToolkit().getImage("horse.gif");
	}
	
	static {
		result = "";
		if (startTime == null) startTime = new Date();
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawLine(0, getHeight()/2, getWidth(), getHeight()/2);
		g.drawImage(img, x, y, 50, this.getHeight(), this);
	}

	@Override
	public void run() {
		for(int i = 0; i < getWidth()+10; i += (int)(Math.random()*10)) {
			x = i;
			time_label();
//			repaint();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

//		date = new Date(); // 종료 시간
		System.out.println(++rank + "등마 : " + name);
		
		time_label();
		timeDiff = (new Date().getTime() - startTime.getTime());
		result += rank + "등마 : " + name + " (" + df.format((timeDiff%(1000*60))/1000.0) + ")\n";
		if(rank == finish) {
			System.out.println("경기가 끝났습니다.");
			JOptionPane.showMessageDialog(this, result);
		}
		
	}
	
	public void time_label() {
		timeDiff = (new Date().getTime() - startTime.getTime());
		lb_time.setText(df.format((timeDiff%(1000*60))/1000.0));
	}

	public String getName() {
		return name;
	}

}
