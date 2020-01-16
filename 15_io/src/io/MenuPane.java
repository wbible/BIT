package io;

import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuPane extends JMenuBar {
	private JMenu[] menu;
	private ArrayList<JMenuItem> items = new ArrayList<JMenuItem>();
	
	public JMenu[] getMenu() {
		return menu;
	}
	public ArrayList<JMenuItem> getItems() {
		return items;
	}

	public MenuPane() {
		String[] str_menu = {"파일", "편집", "보기"};
		menu = new JMenu[str_menu.length];

		String[][] str_item = {{"새로만들기", "열기", "저장", "끝내기"},
								{"복사", "잘라내기", "붙여넣기"},
								{"1", "2", "3", "4"}};
		JMenuItem it;
		for(int i = 0; i < menu.length; i++) {
			menu[i] = new JMenu(str_menu[i]);
			add(menu[i]);
			for(int j = 0; j < str_item[i].length; j++) {
				it = new JMenuItem(str_item[i][j]);
				menu[i].add(it);
				items.add(it);
			}
		}
		
	}
}
