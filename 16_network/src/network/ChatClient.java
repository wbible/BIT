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
		
		// �ϴ� �г�
		JPanel p_bottom = new JPanel();
		p_bottom.setLayout(new BorderLayout());
		input = new JTextField();
		send = new JButton("����");
		p_bottom.add("Center", input); p_bottom.add("East", send);
		c.add("South", p_bottom);
		
		// �޴���
		JMenuBar menubar = getJMenuBar(); 
		JMenu menu = new JMenu("����");
		menubar.add(menu);
		JMenuItem m1_1 = new JMenuItem("���� ����"); m1_1.addActionListener(this);
		menu.add(m1_1);
		
		// ������
		setBounds(800, 100, 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

	private void service() {
		
		String serverIP = JOptionPane.showInputDialog(this, "���� IP�� �Է��ϼ���", "192.168.0.59");
		if(serverIP == null || serverIP.length()==0) {
			System.out.println("���� IP�� �Էµ��� �ʾҽ��ϴ�.");
			return;
		}
		
		//�г���
		String nickName = JOptionPane.showInputDialog(this, "�г����� �Է��ϼ���", "�г���", JOptionPane.INFORMATION_MESSAGE);
		if(nickName == null) nickName = "guest";
	}
	
	public static void main(String[] args) {
		new ChatClient().service();
	}
}