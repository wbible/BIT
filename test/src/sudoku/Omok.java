package sudoku;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Omok extends JFrame implements MouseListener{
	private int width;
	private JLabel[][] lb_ar;
	
	public Omok() {
		
		JPanel p_main = new JPanel();
		p_main.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		p_main.setBackground(Color.LIGHT_GRAY);
		
		p_main.setLayout(new GridLayout(18,18));
		
		lb_ar = new JLabel[18][18];
		for(int i = 0; i< 18; i++) {
			for(int j = 0; j < 18; j++) {
				lb_ar[i][j] = new JLabel();
				lb_ar[i][j].setOpaque(true);
				lb_ar[i][j].setBackground(new Color(150,50,50));
				lb_ar[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
				p_main.add(lb_ar[i][j]);
			}
		}
		
		Container c = getContentPane();
		c.add("Center", p_main);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(900, 200, 500, 500);
		width = getWidth();
		setVisible(true);
		addMouseListener(this);
		
//		input(1,1);		
	}
	
	public void input(Graphics g, int x, int y) {
		g.setColor(Color.WHITE);
		int size = (int) (lb_ar[0][0].getWidth() / 2)-2;
		int x1, y1;
		int xgap = 8;
		int ygap = 31;
//		for(int i = 0; i < 18; i++) {
//			g.drawLine(lb_ar[0][i].getX()+xgap, 0, lb_ar[0][i].getX()+xgap, getHeight());
//			g.drawLine(0, lb_ar[i][0].getY()+ygap, getWidth(), lb_ar[i][0].getY()+ygap);
//		}
		
		x1 = lb_ar[x][y].getX()+xgap;
		y1 = lb_ar[x][y].getY()+ygap;
		g.fillOval(x1-size, y1-size, size*2, size*2);
	
	}
	
	
	
	@Override
	public void paint(Graphics g) {
		
		super.paint(g);
		input(g, 1, 2);
	}

	public static void main(String[] args) {
		new Omok();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int xgap = 8;
		int ygap = 31;
		int x1 = e.getX()-xgap; int y1 = e.getY()-ygap;
		int x=0, y=0;
		int size = (int) (lb_ar[0][0].getWidth() / 2)-2;
		for(int i = 0; i < 18; i++) {
			System.out.println(lb_ar[0][i].getX());
			if(x1 > lb_ar[0][i].getX()-size && x1 < lb_ar[0][i].getX()+size) x = i;
		}
		for(int i = 0; i < 18; i++) {
			if(y1 > lb_ar[i][0].getY()-size && y1 < lb_ar[i][0].getX()+size) y = i;
		}
		input(getGraphics(), x, y);
		System.out.println(x1);
		System.out.println(y1);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}