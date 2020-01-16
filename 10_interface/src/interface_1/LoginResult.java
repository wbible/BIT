package interface_1;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class LoginResult extends JFrame implements WindowListener{
	public static final int FRAME_WIDTH = 200;
	public static final int FRAME_HEIGHT = 150;
	
	private final static String ID = "angel";
	private final static String PWD = "1004";
	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	private JLabel lb_result;
	
	private String id, pwd;

	public LoginResult(String id, String pwd) {
		// 로그인 프레임
		setBounds((int) ((screen.getWidth() - FRAME_WIDTH) / 2), (int) ((screen.getHeight() - FRAME_HEIGHT) / 2),
				FRAME_WIDTH, FRAME_HEIGHT);
		
		Container c = getContentPane(); 
		lb_result = new JLabel();
		lb_result.setHorizontalAlignment(JLabel.CENTER);
		c.add(lb_result);
		
		result();
//		setVisible(true);
//		addWindowListener(this);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public void result() {
		lb_result.setText(ID.equals(id) && PWD.equals(pwd) ? "로그인 성공" : "로그인 실패");
		JOptionPane.showMessageDialog(this, lb_result.getText());
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		setVisible(false);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
