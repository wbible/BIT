package io;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.util.stream.Stream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class ScoreForm extends JFrame implements ActionListener{
	public static final int FRAME_WIDHT = 500;
	public static final int FRAME_HEIGHT = 200;
	
	private JTextField[] tf;
	private JTable table;
	private String[] field = {"�й�", "�̸�", "����", "����", "����", "����", "���"};
	private JButton btn_input, btn_print, btn_search, btn_desc, btn_save, btn_open;
	private ScoreImpl si;
	private String search_name;
	
	public String getSearch_name() {
		return search_name;
	}
	
	public String[] getField() {
		return field;
	}
	
	public JTable getTable() {
		return table;
	}
	
	public ScoreForm() {
		si = new ScoreImpl(this);
		
		setTitle("����");
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((int)((screen.getWidth()-FRAME_WIDHT)/2),(int)((screen.getHeight()-FRAME_HEIGHT)/2),
				FRAME_WIDHT, FRAME_HEIGHT);
		
		Container con = getContentPane();
		
		String[] fieldName = {"�й�", "�̸�", "����", "����", "����"};
		JLabel[] lb = new JLabel[fieldName.length]; 
		tf = new JTextField[fieldName.length];
		
		JPanel p_main = new JPanel();
		p_main.setLayout(new BorderLayout());
		con.add("Center", p_main);
		
		// ���� �Է� �г�
		JPanel p1 = new JPanel(); JPanel p2 = new JPanel(); 
		p1.setLayout(new GridLayout(fieldName.length,2));
		p2.setLayout(new BorderLayout());
		p_main.add("West", p1); p_main.add("Center", p2);
		
		for(int i = 0; i < fieldName.length; i++) {
			lb[i] = new JLabel(fieldName[i], JLabel.CENTER);
			tf[i] = new JTextField();
			tf[i].setPreferredSize(new Dimension(60, 15));
			tf[i].setHorizontalAlignment(JTextField.CENTER);
			p1.add(lb[i]);
			p1.add(tf[i]);
		}
		
		// ������ ���̺�
//		table = new JTable();
		table = new JTable() {
			DefaultTableCellRenderer renderCenter = new DefaultTableCellRenderer();
			{//initializer block
				renderCenter.setHorizontalAlignment(SwingConstants.CENTER);
				renderCenter.setBackground(new Color(240, 240, 255));
			}
			@Override
		    public TableCellRenderer getCellRenderer (int arg0, int arg1) {
		        return renderCenter;
		    }
		};
		JScrollPane scroll = new JScrollPane(table);
		p2.add(scroll);
		
		// �ϴ� ��ư
		JPanel p_btn = new JPanel(); con.add("South", p_btn);
		JButton[] btn_ar = {btn_input, btn_print, btn_search, btn_desc, btn_save, btn_open};
		String[] btn_name = {"�Է�", "���", "�й��˻�", "����", "��������", "���Ͽ���"};
		for(int i = 0; i < btn_ar.length; i++) {
			btn_ar[i] = new JButton(btn_name[i]);
			btn_ar[i].addActionListener(this);
			p_btn.add(btn_ar[i]);
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ScoreDTO dto;
		String btn_name = e.getActionCommand();
		
		System.out.println(btn_name);
		if(btn_name.equals("�Է�")) {
			if(!isDataOK()) return;
			dto = new ScoreDTO(tf[0].getText(), tf[1].getText(), 
					Integer.parseInt(tf[2].getText()), Integer.parseInt(tf[3].getText()), Integer.parseInt(tf[4].getText()));
			si.input(dto);				
		}else if(btn_name.equals("���")) {
			si.print(table);
		}else if(btn_name.equals("�й��˻�")) {
			search_name = JOptionPane.showInputDialog("�˻��� �й��� �Է��ϼ���.");
			si.search(table);
		}else if(btn_name.equals("����")) {
			si.tot_desc();
		}else if(btn_name.equals("��������")) {
			si.save();
		}else if(btn_name.equals("���Ͽ���")) {
			si.load();
		}
		
	}
	
	public boolean isDataOK() {
		System.out.println("������ üũ");
		if(tf[0].getText().trim().length()==0) {
			JOptionPane.showMessageDialog(this, "�й��� �Է��ϼ���.");
			tf[0].requestFocus();
			return false;
		}else if (tf[1].getText().trim().length()==0) {
			JOptionPane.showMessageDialog(this, "�̸��� �Է��ϼ���.");
			tf[0].requestFocus();
			return false;
		}
		
		String p = "[0-9]+";
		for(int i = 2; i < tf.length; i++) {
			if(!tf[i].getText().matches(p)) {
				JOptionPane.showMessageDialog(this, "���� ���� ���ڸ� �Է��� �� �ֽ��ϴ�.");
				tf[i].requestFocus();
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		new ScoreForm();
	}
}

// --------------

class TableModel extends DefaultTableModel{
	
}