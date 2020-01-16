package interface_1;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class WindowTest extends JFrame implements MouseListener, MouseMotionListener {
	public static final int FRAME_WIDTH = 300;
	public static final int FRAME_HEIGHT = 400;
	private int x, y;
	
	public WindowTest() {
		setTitle("���� ���� ������");
		setBounds(800, 300, FRAME_WIDTH, FRAME_HEIGHT);
		setVisible(true);
		
		// �̺�Ʈ ó��
		addMouseListener(this);
//		addMouseMotionListener(this);
		addWindowListener(new WindowExit());
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawString("X: " + x + "\t Y: " + y, x, y);
	}

	public static void main(String[] args) {
		WindowTest wt = new WindowTest();	
	}
	//MouseListener Override - EventHandler
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("���콺 Ŭ��");
		x = e.getX();
		y = e.getY();
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		 System.out.println("���콺 IN");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("���콺 OUT");		
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	//MouseMotionListener Override - EventHandler
	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("���콺 �巡��");
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}
}
