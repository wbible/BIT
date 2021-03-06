package swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.util.stream.Stream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableEx2 extends JFrame implements ActionListener{
	private ArrayList<PersonDTO> list;
	private Vector<String> vector;
	private DefaultTableModel model;
	private JTable table;
	private JButton btn_add, btn_del;
	
	public JTableEx2() {
		list = new ArrayList<PersonDTO>();
		list.add(new PersonDTO("hong", "홍길동", "111", "010-123-1234"));
		list.add(new PersonDTO("conan", "코난", "333", "010-777-7777"));
		
		//제목
		vector = new Vector<String>();
		String[] title = {"아이디", "이름", "비밀번호", "연락처"};
		Stream.of(title).forEach(s -> vector.add(s));
		
		model = new DefaultTableModel(vector, 0) {// (컬럼 이름, 행의 개수)
			@Override
			public boolean isCellEditable(int row, int column) {
				return column!=0 ? true : false;
			}
		}; 
		
		//데이터
		for (PersonDTO dto : list) {
			Vector<String> v = new Vector<String>();
			v.add(dto.getId());
			v.add(dto.getName());
			v.add(dto.getPwd());
			v.add(dto.getTel());
			model.addRow(v);
		}
		
		// 테이블 삽입
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add("Center", scroll);
		
		// 하단 패널과 버튼 삽입
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.RIGHT));
		btn_add = new JButton("추가"); btn_del = new JButton("삭제");
		btn_add.addActionListener(this); btn_del.addActionListener(this);
		p.add(btn_add); p.add(btn_del);
		c.add("South", p);
		
		setBounds(700, 100, 500, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void insert() {
		String id; PersonDTO dto;
		GET_ID: while (true) {
			id = JOptionPane.showInputDialog(this, "ID를 입력하시오");
			if (id == null)
				return;
			Iterator<PersonDTO> it = list.iterator();
			while (it.hasNext()) {
				if (it.next().getId().equals(id)) {
					JOptionPane.showMessageDialog(this, "이미 사용중인 ID입니다.");
					continue GET_ID;
				}
			} 
			dto = new PersonDTO();
			dto.setId(id);
			break;
		}
		
		String name = JOptionPane.showInputDialog(this, "이름을 입력하시오");
		if(name == null) return;
		String pwd = JOptionPane.showInputDialog(this, "비밀번호를 입력하시오");
		if(pwd == null) return;
		String tel = JOptionPane.showInputDialog(this, "연락처를 입력하시오");
		if(tel == null) return;
		dto.setData(name, pwd, tel);
		list.add(dto);
		
		Vector<String> v = new Vector<String>();
		v.add(dto.getId());
		v.add(dto.getName());
		v.add(dto.getPwd());
		v.add(dto.getTel());
		model.addRow(v);
		
		JOptionPane.showMessageDialog(this, "등록이 완료되었습니다.");
	}
	
	public void delete() {
		String name = JOptionPane.showInputDialog(this, "삭제할 이름을 입력하시오");
		if (name ==  null) return;
		PersonDTO dto = new PersonDTO(name);
		if(list.contains(dto)) {
			while (list.contains(dto)) {
				model.removeRow(list.indexOf(dto));
				list.remove(dto);
			}
			JOptionPane.showMessageDialog(this, "삭제가 완료되었습니다.");
		}else {
			JOptionPane.showMessageDialog(this, "찾는 이름이 없습니다.");
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn_add) insert();
		else delete();
	}

	public static void main(String[] args) {
		new JTableEx2();
	}
}
