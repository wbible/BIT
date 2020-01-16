package winEx;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class AgentManager extends JFrame{
	public static final int FRAME_WIDTH = 1000;
	public static final int FRAME_HEIGHT = 700;
	public static final int TF_WIDTH = 100;
	public static final int TF_HEIGHT = 25;
	public static final int PANEL_LEFT_WIDTH = 160;
	private Toolkit toolkit = Toolkit.getDefaultToolkit();
	private Dimension screen = toolkit.getScreenSize();
	
	public void init() {
		// 프레임 초기화
		setTitle("Agent Manager");
		setBounds((int)((screen.getWidth()-FRAME_WIDTH)/2), (int)((screen.getHeight()-FRAME_HEIGHT)/2), 
				FRAME_WIDTH, FRAME_HEIGHT);
		setMinimumSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		
		// 왼쪽 패널 (회원 검색부)
		Panel panel_left = new Panel();
		panel_left.setPreferredSize(new Dimension(PANEL_LEFT_WIDTH, FRAME_HEIGHT));
		add("West", panel_left);
		
		JLabel lb_left_title = new JLabel("회원 검색");
		lb_left_title.setHorizontalAlignment(JLabel.CENTER);
		lb_left_title.setPreferredSize(new Dimension(PANEL_LEFT_WIDTH, TF_HEIGHT));
		panel_left.add(lb_left_title);
		
		JTextField tf_name = new JTextField(), tf_keywords = new JTextField();
		JTextField[] tf_list = {tf_name, tf_keywords};
		
		JLabel lb_name = new JLabel(), lb_keywords = new JLabel();
		JLabel[] lb_tf_left = {lb_name, lb_keywords};
		String[] str_lb_left = {"회원명", "키워드", ""};
		
		Dimension dimensionTF = new Dimension(TF_WIDTH, TF_HEIGHT); 
		Dimension dimensionLb = new Dimension(PANEL_LEFT_WIDTH-TF_WIDTH - 10, TF_HEIGHT); 
		
		for(int i = 0; i < tf_list.length; i++) {
			tf_list[i].setPreferredSize(dimensionTF);
			tf_list[i].setFont(new Font("맑은 고딕", Font.BOLD, 13));
			lb_tf_left[i].setPreferredSize(dimensionLb);
			lb_tf_left[i].setHorizontalAlignment(JLabel.CENTER);
			lb_tf_left[i].setText(str_lb_left[i]);
			panel_left.add(lb_tf_left[i]);
			panel_left.add(tf_list[i]); 
		}
		
		JComboBox<String> combo_region = new JComboBox<String>();
		combo_region.setPreferredSize(dimensionTF);
		String str_items = "전체,동남아,동북아,서남아,CIS,유럽,아프리카,북미,남미";
		for(String item : str_items.split(",")) combo_region.addItem(item);
		
		JLabel lb_region = new JLabel("사역지");
		lb_region.setPreferredSize(dimensionLb);
		lb_region.setHorizontalAlignment(JLabel.CENTER);
		panel_left.add(lb_region);
		panel_left.add(combo_region);
		
		JLabel lb_blank = new JLabel();
		lb_blank.setPreferredSize(dimensionLb);
		panel_left.add(lb_blank);
		
		Button btn_agent_search = new Button("검색");
		btn_agent_search.setPreferredSize(dimensionTF);
		panel_left.add(btn_agent_search);
		
		JLabel lb_blank2 = new JLabel();
		lb_blank2.setPreferredSize(new Dimension(5, 10));
		panel_left.add(lb_blank2);
		
		DefaultListModel<String> lm = new DefaultListModel<String>();
		for(int i = 1; i < 35; i++) lm.addElement("회원" + i);
		JList<String> list_left = new JList<>(lm);
		list_left.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		// 리스트에 스크롤바를 추가한다.
		JScrollPane scroller = new JScrollPane(list_left);
		list_left.setPreferredSize(new Dimension(PANEL_LEFT_WIDTH-15, 500));
		scroller.setPreferredSize(new Dimension(PANEL_LEFT_WIDTH-15, 500));
		// 리스트의 선택 모드를 단일 선택 모드로 변경
		list_left.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel_left.add(scroller);
		
		
		// 프레임 종료 이벤트
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new AgentManager().init();
	}

}
