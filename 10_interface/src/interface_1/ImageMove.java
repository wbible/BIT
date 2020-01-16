package interface_1;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ImageMove extends Frame implements ActionListener, KeyListener {
	public static final int FRAME_WIDTH = 500;
	public static final int FRAME_HEIGHT = 500;
	public static final int BTN_WIDTH = 90;
	public static final int BTN_HEIGHT = 30;
	public static final int PANEL_HEIGHT = 40;
	public static final int MOVE = 20;
	public static final String IMG_LEFT = "D:\\lib\\img/m_left.jpg";
	public static final String IMG_RIGHT = "D:\\lib\\img/m_right.jpg";
	/**
	 * ����, ������, ��, �Ʒ��� �̵���Ű�� ��ư�̴�.
	 */
	private Button btn_clear, btn_left, btn_right, btn_up, btn_down;
	private Toolkit toolkit = Toolkit.getDefaultToolkit();
	private Image img;
	/**
	 * �̹����� ���� ��ġ
	 */
	private int x, y;
	private int img_width = 100;

	/**
	 * <font style = "color:red;">����ȭ���� �ٸ��ִ� �޼ҵ�</font>
	 */
	public void init() {
		Dimension screen = toolkit.getScreenSize();
		
		// ���� ������
		setTitle("�̹��� �̵� �׽�Ʈ");
		setBounds((int) ((screen.getWidth() - FRAME_WIDTH) / 2), (int) ((screen.getHeight() - FRAME_HEIGHT) / 2),
				FRAME_WIDTH, FRAME_HEIGHT);
		
		// �̹��� �� ��ǥ �ʱ�ȭ
		img = toolkit.getImage(IMG_LEFT);
		locationReset();

		// ��ư�� �÷����� �г�
		Panel p_btn = new Panel();
		p_btn.setPreferredSize(new Dimension(FRAME_WIDTH, PANEL_HEIGHT));
		p_btn.setBackground(new Color(255, 190, 100));
		add("North", p_btn);

		// ��ư ��ü �ʱ�ȭ
		btn_clear = new Button("�ʱ�ȭ");
		btn_left = new Button("��������");
		btn_right = new Button("����������");
		btn_up = new Button("����");
		btn_down = new Button("�Ʒ���");

		Button[] btn_list = { btn_clear, btn_left, btn_right, btn_up, btn_down };
		for (Button btn : btn_list) {
			btn.setPreferredSize(new Dimension(BTN_WIDTH, BTN_HEIGHT));
			btn.addActionListener(this);
			btn.addKeyListener(this);
			p_btn.add(btn);
		}
		
		// ���� ������ ȭ�鿡 ���
		setVisible(true);
		addWindowListener(new WindowExit());
	}

	@Override
	public void paint(Graphics g) {
		int x2 = x, y2 = y;
		if(x > getWidth()) x = 0 + (x - getWidth());
		if(x + img_width < 0) x = getWidth() + x;
		if(y < PANEL_HEIGHT - img_width) y = getHeight() + (y - PANEL_HEIGHT);
		if(y > getHeight()) y = PANEL_HEIGHT + (y - getHeight());
//		System.out.println("x = " + x + "\ty = " + y);
		if(x < 0 || x > getWidth() - img_width || y < PANEL_HEIGHT || y > getHeight() - img_width) {
			if(x < 0) x2 = getWidth() + x;
			if(x > getWidth() - img_width) x2 = x - getWidth();
			if(y < PANEL_HEIGHT) y2 = getHeight() + (y - PANEL_HEIGHT);
			if(y > getHeight() - img_width) y2 = y - getHeight() + PANEL_HEIGHT;
			g.drawImage(img, x2, y2, this);
		}
		g.drawImage(img, x, y, this);
	}

	public static void main(String[] args) {
		new ImageMove().init();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		if(e.getSource()==btn_clear) locationReset();
		else if(e.getSource()==btn_left) {
			x -= MOVE;
			img = toolkit.getImage(IMG_LEFT);
		}
		else if(e.getSource()==btn_right) {
			x += MOVE;
			img = toolkit.getImage(IMG_RIGHT);
		}
		else if(e.getSource()==btn_up) y -= MOVE;
		else if(e.getSource()==btn_down) y += MOVE;
		repaint();
	}
	
	public void locationReset() {
		x = (int) ((getWidth() - img_width)/ 2);
		y = (int) ((getHeight() - img_width) / 2);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(KeyEvent.getKeyText(e.getKeyCode()));
		int keycode = (int) e.getKeyCode();
		if (keycode == KeyEvent.VK_LEFT) {
			x -= MOVE;
			img = toolkit.getImage(IMG_LEFT);			
		}else if (keycode == KeyEvent.VK_RIGHT) {
			x += MOVE;
			img = toolkit.getImage(IMG_RIGHT);
		}
		else if (keycode == KeyEvent.VK_UP) y -= MOVE;
		else if (keycode == KeyEvent.VK_DOWN) y += MOVE;
		else if (keycode == KeyEvent.VK_SPACE) locationReset();
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
