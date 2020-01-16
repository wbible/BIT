package inheritance;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;

public class WindowTest extends Frame{
	private final int FRAME_WIDTH = 300;
	private final int FRAME_HEIGHT = 400;
	
	public WindowTest()  {
		super("내가 만든 윈도우");
		
		setBackground(new Color(80, 110 ,50));
		setBounds(700, 200, FRAME_WIDTH, FRAME_HEIGHT);
		setForeground(Color.YELLOW);
		setVisible(true);
		
	}

	
	@Override
	public void paint(Graphics g) { // Call Back 메소드 - 일정 시점이 되면 JVM에 의해서 호출
//		g.setColor(new Color(255,255,255));
//		g.drawLine(50, 50, 200, 200);
//		g.drawLine(200, 50, 50, 200);
//		g.drawRect(50, 50, 150, 150);
//		g.setColor(Color.YELLOW);
//		g.drawOval(50, 50, 150, 150);
//		
//		for(int i = 50; i <= 200; i++) {
//			g.drawLine(i, 50, 200, 200);
//		}
//		g.fillRoundRect(50, 250, 100, 100, 20, 20);
//		
//		g.setColor(Color.BLACK);
//		g.drawString("fillRoundRect", 60, 300);
		
		for(int i = 0; i < FRAME_HEIGHT; i+=100) {
			g.fillRect(0, i, FRAME_WIDTH, 50);
		}
		
		
	}


	public static void main(String[] args) {
		new WindowTest();
		
	}
}
