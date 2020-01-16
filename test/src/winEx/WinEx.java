package winEx;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WinEx {
	final static int MOVE = 20;
	final static int TOP_HEIGHT = 50;
	final static int FIGHTER_WIDTH = 70;
	final static int FIGHTER_HEIGHT = 70;
	final static int EGG_WIDTH = 20;
	final static int EGG_HEIGHT = 30;
	final static int FIRE_FRAME = 10;
	
	public static void main(String[] args) {
		JFrame f = new JFrame("window text");
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension top = new Dimension(50, (int)screen.getWidth());
		
		
		f.setLayout(null);
		JPanel p_top = new JPanel();
		
		p_top.setBackground(Color.LIGHT_GRAY);
		f.add(p_top);
		p_top.setBounds(0,0,(int)screen.getWidth(), TOP_HEIGHT);
		
		
		JPanel p1 = new JPanel();
		p1.setBounds(0, TOP_HEIGHT, (int)screen.getWidth(), (int)screen.getHeight()- TOP_HEIGHT);
		p1.setBackground(Color.white);
		ImageIcon fighter = new ImageIcon("D:\\lib\\army fighter.png");  //이미지 경로
		Image scaledImg = fighter.getImage().getScaledInstance(FIGHTER_WIDTH, FIGHTER_HEIGHT, Image.SCALE_SMOOTH);
		fighter = new ImageIcon(scaledImg);
		JLabel l1 = new JLabel();
		l1.setSize(FIGHTER_WIDTH, FIGHTER_HEIGHT);
		l1.setIcon(fighter);
		p1.add(l1);

		f.add(p1);
		

		l1.setLocation((int) p1.getWidth() / 2, (int) (p1.getY() + p1.getHeight())-300);
		System.out.println(p1.getY() + p1.getHeight()-300);
		
		f.setBounds(0, 0, screen.width, screen.height - 30);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setUndecorated(true);
		f.setVisible(true);

		f.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				int keycode = (int) e.getKeyCode();
				switch (keycode) {
				case KeyEvent.VK_LEFT:
					while (l1.getLocation().x - MOVE > 0) {
						l1.setLocation(l1.getLocation().x - MOVE, l1.getLocation().y);
						break;
					}
					break;
				case KeyEvent.VK_RIGHT:
					while (l1.getLocation().x + MOVE < p1.getWidth()) {
						l1.setLocation(l1.getLocation().x + MOVE, l1.getLocation().y);
						break;
					}
					break;
				case KeyEvent.VK_UP:
					while (l1.getLocation().y - MOVE > 0) {
						l1.setLocation(l1.getLocation().x, l1.getLocation().y - MOVE);
						break;
					}
					break;
				case KeyEvent.VK_DOWN:
					while (l1.getLocation().y + MOVE < p1.getHeight()) {
						l1.setLocation(l1.getLocation().x, l1.getLocation().y + MOVE);
						break;
					}
					break;
				case KeyEvent.VK_SPACE:
					EggFire(p1, l1);
					break;
				}
			}
		});

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void EggFire(JPanel p, JLabel l1) {
		ImageIcon egg = new ImageIcon("D:\\lib\\egg.png");
		Image scaledImg = egg.getImage().getScaledInstance(EGG_WIDTH, EGG_HEIGHT, Image.SCALE_SMOOTH);
		egg = new ImageIcon(scaledImg);
		
		JLabel labelEgg = new JLabel();
		labelEgg.setBounds(l1.getX()+25,l1.getY(),EGG_WIDTH, EGG_HEIGHT);
		labelEgg.setIcon(egg);
		p.add(labelEgg);
		
		Timer fire_timer = new Timer();
		TimerTask fire_egg = new TimerTask() {
			
			@Override
			public void run() {
				labelEgg.setLocation(labelEgg.getX(), labelEgg.getY()-5);
				p.repaint();					
				if (labelEgg.getY()<-EGG_HEIGHT){
					fire_timer.cancel();
				}
			}
		};
		fire_timer.schedule(fire_egg, 0, FIRE_FRAME);
	}

}
