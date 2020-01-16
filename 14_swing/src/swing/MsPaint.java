package swing;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import swing.MsPaint.E_shape;

public class MsPaint extends JFrame implements ActionListener {
	public enum E_shape{
		LINE, OVAL, FILL_OVAL, RECT, FILL_RECT, ROUND_RECT, FILL_ROUND_RECT, PEN
	}
	private int x1, y1, x2, y2;
	private JTextField tf_x1, tf_y1, tf_x2, tf_y2;
	private JTextField[] tf_ar;
	private JLabel[] lb_ar;
	private JCheckBox cBox_fill;
	private MyCanvas canvas;
	private JRadioButton[] radio_ar;
	private JComboBox<String> combo_color;
	private Map<String, Color> colorMap;
	private boolean penDrawing;
	private long pen_group;

	public MsPaint() {
		// 프레임과 컨테이너 설정
		super("미니 그림판");
		setBounds(300, 200, 800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		
		// 상단 패널
		JPanel p_top = new JPanel();
		p_top.setLayout(new FlowLayout(FlowLayout.LEFT));
		con.add("North", p_top);
		
		JLabel lb_x1 = new JLabel("X1"); tf_x1 = new JTextField(4);
		JLabel lb_y1 = new JLabel("Y1"); tf_y1 = new JTextField(4);
		JLabel lb_x2 = new JLabel("X2"); tf_x2 = new JTextField(4);
		JLabel lb_y2 = new JLabel("Y2"); tf_y2 = new JTextField(4);
		
		lb_ar = new JLabel[]{lb_x1, lb_y1, lb_x2, lb_y2};
		tf_ar = new JTextField[]{tf_x1, tf_y1, tf_x2, tf_y2};
		for(int i = 0; i < lb_ar.length; i++) {
			p_top.add(lb_ar[i]); p_top.add(tf_ar[i]);
			tf_ar[i].setHorizontalAlignment(JTextField.CENTER);
		}
		
		cBox_fill = new JCheckBox("채우기"); 
		p_top.add(cBox_fill);
		cBox_fill.setSelected(true);
		
		// 중앙 캔버스
		canvas = new MyCanvas(this); con.add("Center", canvas);
		
		// 하단 패널
		JPanel p_bottom = new JPanel();
		p_bottom.setLayout(new FlowLayout(FlowLayout.LEFT));
		con.add("South", p_bottom);
		
		String[] radio_title = {"선", "원", "사각형", "둥근사각형", "연필"};
		radio_ar = new JRadioButton[radio_title.length];
		ButtonGroup bg = new ButtonGroup();
		for(int i = 0; i < radio_title.length; i++) {
			radio_ar[i] = new JRadioButton(radio_title[i]);
			radio_ar[i].addActionListener(this);
			bg.add(radio_ar[i]);
			p_bottom.add(radio_ar[i]);
		}
		radio_ar[2].setSelected(true);
		
		String[] colors = {"검정", "빨강", "초록", "파랑", "보라", "하늘"};
		Color[] color_data = {Color.BLACK, Color.RED, Color.GREEN, Color.BLUE, Color.MAGENTA, Color.CYAN};
		colorMap = new HashMap<String, Color>();
		for(int i = 0; i < colors.length; i++) colorMap.put(colors[i], color_data[i]);
		
		combo_color = new JComboBox<String>(colors);
		p_bottom.add(combo_color);
		
		String[] strButtons = {"그리기", "되돌리기", "지우기"};
		JButton[] buttons = new JButton[strButtons.length];
		for(int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(strButtons[i]);
			buttons[i].addActionListener(this);
			p_bottom.add(buttons[i]);
		}
		
		// 캔버스 이벤트 처리
		canvas.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				x1 = e.getX(); y1 = e.getY();
				if(!radio_ar[radio_ar.length-1].isSelected()) {
					canvas.addDrawingList(0,0,0,0,0);
					tf_x1.setText(x1+""); tf_y1.setText(y1+"");
				}
				else {
					penDrawing = true;
					pen_group++;
				}
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				if(penDrawing) {
					canvas.addDrawingList(0,0,0,0,pen_group++);
				}
				penDrawing = false;
			}
		});
		
		canvas.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				x2 = e.getX(); y2 = e.getY();
				Graphics g = canvas.getGraphics();
				g.setColor(getSelectedColor());
				if(!radio_ar[radio_ar.length-1].isSelected()) {
					canvas.undoDrawing();
					canvas.addDrawingList(x1, y1, x2, y2, 0);
					tf_x2.setText(x2+""); tf_y2.setText(x2+"");
				}else {
					g.drawLine(x1, y1, x2, y2);
					canvas.addDrawingList(x1, y1, x2, y2, pen_group);
					x1 = e.getX(); y1 = e.getY();
				};
				g.dispose();
			}
		});
		setVisible(true); 
	}
	
	// 버튼 이벤트 처리
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() instanceof JRadioButton) cBox_fill.setEnabled(!e.getActionCommand().equals("선"));
		else if(e.getSource() instanceof JButton) {
			// 지우기
			if(e.getActionCommand().equals("지우기")) {
				canvas.clearDrawing();
				return;
			}else if (e.getActionCommand().equals("되돌리기")) {
				canvas.undoDrawing();
				return;
			}
			// 그리기
			if(!isDataCorrect()) {
				JOptionPane.showMessageDialog(this, "좌표가 올바르게 입력되지 않았습니다." );
				return;
			}
			
			// 선택된 색상과 좌표를 canvas로 넘겨주며 드로잉리스트에 추가
			x1 = Integer.parseInt(tf_x1.getText().trim()); y1 = Integer.parseInt(tf_y1.getText().trim());
			x2 = Integer.parseInt(tf_x2.getText().trim()); y2 = Integer.parseInt(tf_y2.getText().trim());
			canvas.addDrawingList(x1, y1, x2, y2, 0);
		}
	}

	public E_shape getDrawingShape() {
		E_shape shape = E_shape.PEN;
		int i;
		for(i = 0; i < radio_ar.length; i++) {
			if(radio_ar[i].isSelected()) break;
		}
		if(i == 0) shape = E_shape.LINE; // 선 그리기
		else if(i == 1) { ;//원 그리기
			if (cBox_fill.isSelected()) shape = E_shape.FILL_OVAL;
			else shape = E_shape.OVAL;
		}else if(i == 2) { //사각형 그리기
			if (cBox_fill.isSelected()) shape = E_shape.FILL_RECT;
			else shape = E_shape.RECT;
		}else if(i == 3) {//둥근사각형
			if (cBox_fill.isSelected()) shape = E_shape.FILL_ROUND_RECT;
			else shape = E_shape.ROUND_RECT;
		}
		return shape;
	}
	
	public Color getSelectedColor() {
		return colorMap.get(combo_color.getSelectedItem().toString());
	}
	
	public boolean isDataCorrect() {
		for(JTextField tf : tf_ar) {
			if (!tf.getText().matches("^[0-9]+$")) {
				tf.requestFocus();
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		new MsPaint();
	}

}
//------------------------
class MyCanvas extends Canvas implements MouseListener, MouseMotionListener {
	public static final int ROUND = 50;
//	private int x1, y1, x2, y2;
	private MsPaint msPaint;
	private Vector<ShapeDTO> v = new Vector<ShapeDTO>();
	private Image bufferImg;
	private Graphics bufferG;
	
	public MyCanvas(MsPaint msPaint) {
		setBackground(new Color(252,245,245));
		this.msPaint = msPaint;
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}
	
	public void addDrawingList(int x1, int y1, int x2, int y2, long pen_group) {
		ShapeDTO dl = new ShapeDTO(msPaint.getDrawingShape(), msPaint.getSelectedColor(), x1, y1, x2, y2, pen_group);
		v.add(dl);
		repaint();
	}
	
	public void undoDrawing() {
		if(v.size()!=0) {
			long pen_group = v.get(v.size()-1).getPen_group();
			if(pen_group != 0) {
				while(v.size()>0) {
					if(v.get(v.size()-1).getPen_group()==pen_group) v.remove(v.size()-1);
					else break;
				}
			}else {				
				v.remove(v.size()-1);
			}
		}
		repaint();
	}
	
	public void clearDrawing() {
		v.clear();
		repaint();
	}
	
	public void drawing(Graphics g, E_shape shape, Color color, int x1_, int y1_, int x2_, int y2_) {
		int x1, y1, x2, y2, width, height;
		x1 = Math.min(x1_, x2_); y1 = Math.min(y1_, y2_);
		x2 = Math.max(x1_, x2_); y2 = Math.max(y1_, y2_);
		width = x2-x1; height = y2-y1;
		
		if(shape.equals(E_shape.LINE)) {
			g.drawLine(x1_, y1_, x2_, y2_);
		}else if(shape.equals(E_shape.RECT)) {
			g.drawRect(x1, y1, width, height);
		}else if(shape.equals(E_shape.FILL_RECT)) {
			g.fillRect(x1, y1, width, height);
		}else if(shape.equals(E_shape.OVAL)) {
			g.drawOval(x1, y1, width, height);
		}else if(shape.equals(E_shape.FILL_OVAL)) {
			g.fillOval(x1, y1, width, height);
		}else if(shape.equals(E_shape.ROUND_RECT)) {
			g.drawRoundRect(x1, y1, width, height, ROUND, ROUND);
		}else if(shape.equals(E_shape.FILL_ROUND_RECT)) {
			g.fillRoundRect(x1, y1, width, height, ROUND, ROUND);
		}else {
			g.drawLine(x1_, y1_, x2_, y2_);
		}
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(bufferImg, 0, 0, this);
	}
	
	@Override
	public void update(Graphics g) {
		Dimension di = getSize();
		if(bufferG==null) {
			bufferImg = createImage(di.width, di.height);
			bufferG = bufferImg.getGraphics();
		}
		bufferG.setColor(getBackground());
		bufferG.fillRect(0, 0, di.width, di.height);
		
		for(ShapeDTO d : v) {
			bufferG.setColor(d.getColor());
			drawing(bufferG, d.getShape(), d.getColor(), d.getX1(), d.getY1(), d.getX2(), d.getY2());
		}	
		paint(g);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
//		x1 = e.getX(); y1 = e.getY();
//		addDrawingList(0,0,0,0);
//		image = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
//		x2 = e.getX(); y2 = e.getY();
//		DrawingList dl = new DrawingList(msPaint.getDrawingShape(), msPaint.getSelectedColor(), 
//				x1, y1, x2, y2);
//		v.add(dl);
//		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
//		Graphics g = getGraphics();
//		x2 = e.getX(); y2 = e.getY();
//		g.setColor(msPaint.getSelectedColor());
		
//		paintAll(image.getGraphics());
//		update(g);
//		drawing(g, msPaint.getDrawingShape(), msPaint.getSelectedColor(), x1, y1, x2, y2);
		
//		removeDrawingList();
//		addDrawingList(x1, y1, x2, y2);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

