package nested;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalcMain extends JFrame {
	public static final int FRAME_WIDTH = 310;
	public static final int FRAME_HEIGHT = 425;
	public static final int BTN_WIDTH = 65;
	public static final int BTN_HEIGHT = 50;
	public static final int GAP = 8;
	
	private JButton[] btn_list;
	private JButton btn_back, btn_clear;
	private JLabel lb_top, lb_main;
	
	private boolean resetTrigger;
	private StringBuffer dispBuf, inputBuf;
	private double result;
	private String op;
	
	public CalcMain() {
		init();
		init_event(lb_main, lb_top);
	}
	
	public void init() {
		// ���� ����
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension d_btn = new Dimension(BTN_WIDTH, BTN_HEIGHT);
		
		// ������ �ʱ�ȭ - ȭ�� �߾ӿ� ���
		setTitle("����");
		
		setBounds((int) ((screen.getWidth() - FRAME_WIDTH) / 2), (int) ((screen.getHeight() - FRAME_HEIGHT) / 2),
				FRAME_WIDTH, FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		// �����̳ʿ� �г� �ʱ�ȭ
		Container c = getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.CENTER, GAP, GAP));
		JPanel p_top = new JPanel();
		JPanel p_mid = new JPanel();
		JPanel p_main = new JPanel();
		c.add(p_top); 
		c.add(p_mid); 
		c.add(p_main);
		
		// �г� ���̾ƿ�
		p_top.setLayout(new BorderLayout(GAP, GAP));
		p_mid.setLayout(new GridLayout(1,2, GAP, GAP));
		p_main.setLayout(new GridLayout(4,4, GAP, GAP));
		
		// ���̺� �ʱ�ȭ
		lb_top = new JLabel("", JLabel.RIGHT);
		lb_main = new JLabel("0", JLabel.RIGHT);
		lb_top.setPreferredSize(new Dimension(FRAME_WIDTH - GAP * 2 -10, 30));
		lb_main.setPreferredSize(new Dimension(FRAME_WIDTH - GAP * 2 -10, BTN_HEIGHT));
		lb_top.setFont(new Font("���� ���", Font.BOLD, 12));
		lb_main.setFont(new Font("���� ���", Font.BOLD, 28));
		
		JLabel[] lb_list = {lb_top, lb_main}; 
		for(int i = 0; i < lb_list.length; i++) {
			lb_list[i].setOpaque(true);
			lb_list[i].setBackground(Color.WHITE);
			lb_list[i].setBorder(BorderFactory.createEmptyBorder(0,GAP,0,GAP)); // ������ ���� ����
		}
		p_top.add("North", lb_top); p_top.add("Center", lb_main);
		
		// ��ư �ʱ�ȭ - 1 (backspace, clear)
		btn_back = new JButton("Backspace");
		btn_clear = new JButton("C");
		JButton[] btn_list_top = {btn_back, btn_clear};
		for(int i = 0; i < btn_list_top.length; i++) {
			btn_list_top[i].setPreferredSize(new Dimension(BTN_WIDTH * 2 + GAP, BTN_HEIGHT));
			btn_list_top[i].setFont(new Font("���� ���", Font.BOLD, 16));
			p_mid.add(btn_list_top[i]);
		}
		
		// ��ư �ʱ�ȭ - 2 (����, ��ȣ)
		String[] str_btn = {"7", "8", "9", "��", "4", "5", "6", "��", "1", "2", "3", "-", ".", "0", "=", "+"};
		btn_list = new JButton[str_btn.length];
		for(int i = 0; i < btn_list.length; i++) {
			btn_list[i] = new JButton(str_btn[i]);
			btn_list[i].setPreferredSize(d_btn);
			p_main.add(btn_list[i]);
		}
		
		reset();
		setVisible(true);
	}
	
	public void reset() {
		op = "";
		dispBuf = new StringBuffer();
		inputBuf = new StringBuffer("0");
		disp_main(inputBuf);
		lb_top.setText("");
		resetTrigger = true;
	}
	
	public void init_event(JLabel lb_main, JLabel lb_top) {
		// ���� ��ư Ŭ����
		ActionListener action_num = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (resetTrigger) {
					inputBuf = new StringBuffer();
					if(e.getActionCommand().equals(".")) inputBuf.append("0");
//					else if(e.getActionCommand().equals("0")) return;
				}
				
				if (inputBuf.toString().equals("0") && e.getActionCommand().equals("0")) return;
				if (inputBuf.indexOf(".") > 0 && e.getActionCommand().equals(".")) return;
				inputBuf.append(e.getActionCommand());
				disp_main(inputBuf);
				resetTrigger = false;
			}
		};
		
		// ��ȣ ��ư Ŭ����
		ActionListener action_symbol = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(dispBuf.length() == 0 && inputBuf.toString().equals("0") && !e.getActionCommand().equals("=")) {
					dispBuf.append("0 " + e.getActionCommand()); 
					lb_top.setText(dispBuf.toString());	
					resetTrigger = true;
					return;
				}
				if(e.getActionCommand().equals("=")) {
					if(dispBuf.length() == 0) {
						dispBuf.append(inputBuf + " =");
						resetTrigger = true;
					}else if(dispBuf.substring(dispBuf.length()-1).equals("=")) {
						dispBuf.delete(0, dispBuf.length());
						dispBuf.append(dotFormat(Double.toString(result)));
						if(op.length()!=0) dispBuf.append(" " + op + " " + inputBuf + " =");
						else dispBuf.append(" =");
					}else {
						dispBuf.append(" " + inputBuf + " =");
					}
					resetTrigger = false;
					calc(e.getActionCommand());
				}else if(endWithSymbol(dispBuf.toString()) && resetTrigger) {
					// �������� �ٸ� ��ȣ�� ���� �� ���� ��ȣ�� �����ϰ� ���ο� ��ȣ�� ����
					dispBuf.deleteCharAt(dispBuf.length()-1);
					dispBuf.append(e.getActionCommand());
					op = e.getActionCommand();
					
				}else if(dispBuf.toString().endsWith("=")) {// �������� = ��ȣ�� ���� ��
					dispBuf = new StringBuffer(dotFormat(Double.toString(result)));
					dotFormat(dispBuf);
					dispBuf.append(" " + e.getActionCommand());
					if(!e.getActionCommand().equals("=")) op = e.getActionCommand();
					calc(e.getActionCommand());
				}else {
					dotFormat(inputBuf);
					dispBuf.append(" " + inputBuf.toString() + " " + e.getActionCommand());
					calc(e.getActionCommand());
				}
				
				lb_top.setText(dispBuf.toString());	
				resetTrigger = true;
			}
		};
		
		// Ŭ����
		ActionListener action_clear = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		};
		
		// Backspace
		ActionListener action_back = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(lb_top.getText().toString().endsWith("=")) {
					lb_top.setText("");
					resetTrigger = true;
				}
				else {
					inputBuf.deleteCharAt(inputBuf.length()-1);
					if (inputBuf.length() == 0) {
						inputBuf.append("0");
						resetTrigger = true;
					}
					disp_main(inputBuf);
				}
			}
		};
		
		
		for(JButton btn : btn_list) {
			if(endWithSymbol(btn.getText()) || btn.getText().equals("=")) {
				btn.addActionListener(action_symbol); 
			}else btn.addActionListener(action_num);
		}
		
		btn_clear.addActionListener(action_clear);
		btn_back.addActionListener(action_back);
	}
	
	public boolean endWithSymbol(String str) {
		return (str.endsWith("+") || str.endsWith("-") || str.endsWith("��") || str.endsWith("��"));
	}
	
	public void dotFormat(StringBuffer inputBuf) {
		while(inputBuf.substring(inputBuf.length()-1).equals("0") && inputBuf.indexOf(".") > 0) 
			inputBuf.deleteCharAt(inputBuf.length()-1);
		if (inputBuf.substring(inputBuf.length()-1).equals("."))
			inputBuf.deleteCharAt(inputBuf.length()-1);
	}
	
	public String dotFormat(String input) {
		StringBuffer inputBuf = new StringBuffer(input);
		while(inputBuf.substring(inputBuf.length()-1).equals("0") && inputBuf.indexOf(".") > 0) 
			inputBuf.deleteCharAt(inputBuf.length()-1);
		if (inputBuf.substring(inputBuf.length()-1).equals("."))
			inputBuf.deleteCharAt(inputBuf.length()-1);
		return inputBuf.toString();
	}
	
	public void calc(String input) {
		System.out.println(inputBuf);
		if(!resetTrigger) {
			double num = Double.parseDouble(inputBuf.toString());
			if (op.length() != 0) {
				System.out.print(result + " " + op + " " + inputBuf + " = ");
				if(op.equals("+")) result += num; 
				else if(op.equals("-")) result -= num; 
				else if(op.equals("��")) result *= num; 
				else if(op.equals("��")) {
					if (num != 0.0) {
						result /= num;
					}else {
						reset();
						lb_main.setText("0���� ���� �� ����");
						return;
					}
				}
				StringBuffer inputBuf = new StringBuffer(Double.toString(result));
				dotFormat(inputBuf);
				disp_main(inputBuf);
				System.out.println(result);
			}else {
				result = num;
			}
			if(!input.equals("=")) op = input;
		}
	}
	
	public void disp_main(StringBuffer sb) {
		if (sb.length() == 0) return;
		
		DecimalFormat df = new DecimalFormat("#,###");
		String str_disp;
		str_disp = df.format(Double.parseDouble(sb.toString()));
		if (sb.substring(sb.length()-1).equals(".")) str_disp = str_disp + ".";
		else if (sb.indexOf(".") > 0) str_disp = str_disp + sb.substring(sb.indexOf("."));
		lb_main.setText(str_disp);
//		else lb_main.setText("0");
	}
	
	public static void main(String[] args) {
		new CalcMain();
	}

}
