package network;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.peer.MenuPeer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements ActionListener{
	private JTextArea output;
	private JTextField input;
	private JButton send;
	
	public ChatClient() {
		
		Container c = getContentPane();
		output = new JTextArea();
		output.setAutoscrolls(true);
		output.setEditable(false);
		JScrollPane scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		c.add("Center", scroll);
		
		// 하단 패널
		JPanel p_bottom = new JPanel();
		p_bottom.setLayout(new BorderLayout());
		input = new JTextField();
		send = new JButton("전송");
		p_bottom.add("Center", input); p_bottom.add("East", send);
		c.add("South", p_bottom);
		
		// 메뉴바
		JMenuBar menubar = getJMenuBar(); 
		JMenu menu = new JMenu("접속");
		menubar.add(menu);
		JMenuItem m1_1 = new JMenuItem("서버 연결"); m1_1.addActionListener(this);
		menu.add(m1_1);
		
		// 프레임
		setBounds(800, 100, 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

	private void service() {
		
		String serverIP = JOptionPane.showInputDialog(this, "서버 IP를 입력하세요", "192.168.0.59");
		if(serverIP == null || serverIP.length()==0) {
			System.out.println("서버 IP가 입력되지 않았습니다.");
			return;
		}
		
		//닉네임
		String nickName = JOptionPane.showInputDialog(this, "닉네임을 입력하세요", "닉네임", JOptionPane.INFORMATION_MESSAGE);
		if(nickName == null) nickName = "guest";
	}
	
	public static void main(String[] args) {
		new ChatClient().service();
	}
}
