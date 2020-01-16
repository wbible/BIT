package interface_1;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements WindowListener, ActionListener{
	
	private Toolkit toolkit = Toolkit.getDefaultToolkit();
	public static final int FRAME_WIDTH = 300;
	public static final int FRAME_HEIGHT = 300;
	public static final int TF_WIDTH = 140;
	public static final int TF_HEIGHT = 30;
	public static final int V_GAP = 5;
	public static final int H_GAP = 5;
	public static final int LEFT_GAP = 40;
	public static final int LB_WIDTH = 60;
	public static final int LB_HEIGHT = TF_HEIGHT;
	public static final int TOP = 70;
	public static final int BTN_WIDTH = 98;
	public static final int BTN_HEIGHT = 30;
	private JLabel idL, pwdL;
	private static JTextField idT, pwdT;
	private JButton loginB, cancelB;
	
	public Login() {
		setLayout(null);
		Container c = getContentPane();
		
		idL = new JLabel("아이디");
		pwdL = new JLabel("비밀번호");
		idT = new JTextField();
		pwdT = new JPasswordField();
		loginB = new JButton("로그인");
		cancelB = new JButton("취소");
		
		idL.setBounds(LEFT_GAP, TOP, LB_WIDTH, LB_HEIGHT);
		idT.setBounds(LEFT_GAP + LB_WIDTH , TOP, TF_WIDTH, TF_HEIGHT);
		pwdL.setBounds(LEFT_GAP, TOP + LB_HEIGHT + V_GAP, LB_WIDTH, LB_HEIGHT);
		pwdT.setBounds(LEFT_GAP + LB_WIDTH , TOP + TF_HEIGHT + V_GAP, TF_WIDTH, TF_HEIGHT);
		loginB.setBounds(LEFT_GAP, TOP + (LB_HEIGHT + V_GAP) * 2, BTN_WIDTH, BTN_HEIGHT);
		cancelB.setBounds(LEFT_GAP + BTN_WIDTH + H_GAP, TOP + (LB_HEIGHT + V_GAP) * 2, BTN_WIDTH, BTN_HEIGHT);
		c.add(idL);
		c.add(idT);
		c.add(pwdL);
		c.add(pwdT);
		c.add(loginB);
		c.add(cancelB);
		
		loginB.addActionListener(this);
		cancelB.addActionListener(this);
		pwdT.addKeyListener(new KeyListener() {
			
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
				if(e.getKeyCode() == KeyEvent.VK_ENTER) LoginTry();
					
			}
		});
		
		Dimension screen = toolkit.getScreenSize();
		setTitle("Login");
		setBounds((int) ((screen.getWidth() - FRAME_WIDTH) / 2), (int) ((screen.getHeight() - FRAME_HEIGHT) / 2),
				FRAME_WIDTH, FRAME_HEIGHT);
		addWindowListener(this);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Login();
	}
	
	public void LoginTry() {
		new LoginResult(idT.getText(), pwdT.getText());
	}
	
	public void reset() {
		idT.setText("");
		pwdT.setText("");
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cancelB) reset();
		else LoginTry();
	}
}
