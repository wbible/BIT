package abstract_1;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class WindowTest extends Frame{
	public final static int FRAME_WIDTH = 300;
	public final static int FRAME_HEIGHT = 400;
	
	public WindowTest() {
		setBounds(800,300,FRAME_WIDTH, FRAME_HEIGHT);
		setVisible(true);
	}
	
	
	@Override
	public void paint(Graphics g) {
		g.drawString("이미지", 50, 80);
		//이미지 불러오기 
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage("apeach.jpg");
		g.drawImage(img, 20, 100, this); // 이미지 그리기
	}



	public static void main(String[] args) {
		WindowTest wt = new WindowTest();
		

	}

}
