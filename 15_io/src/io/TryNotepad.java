package io;

import java.awt.Container;
import java.awt.Event;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class TryNotepad extends JFrame implements ActionListener{
	private JTextArea ta;
	private MenuPane menu;
	private JMenu[] jMenu;
	private File file;
	
	public TryNotepad() {
		setBounds(600, 200, 700, 500);
		setTitle("메모장");
		
		Container c = getContentPane();
		ta = new JTextArea();
		JScrollPane scroll = new JScrollPane(ta);
		c.add("Center", scroll);
		
		menu = new MenuPane();
		jMenu = menu.getMenu();
		setJMenuBar(menu);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setVisible(true);
		event();
	}
	
	public void event() {
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				if(ta.getText().length()!=0) {
					int result = JOptionPane.showConfirmDialog(TryNotepad.this, "저장하시겠습니까?", "저장 확인", JOptionPane.YES_NO_CANCEL_OPTION);
					if (result == JOptionPane.CANCEL_OPTION) return;
					if (result == JOptionPane.YES_OPTION) {
						saveDialog();
						if (file==null) return; 
						fileWrite();
					}
				}
				System.exit(0);				
			}
			
		});
		
		JMenuItem item;
		for(int i = 0; i < menu.getItems().size(); i++) {
			item = menu.getItems().get(i);
			item.addActionListener(this);
			if(item.getText().equals("복사")) item.setAccelerator(KeyStroke.getKeyStroke('C', Event.ALT_MASK));
			if(item.getText().equals("붙여넣기")) item.setAccelerator(KeyStroke.getKeyStroke('V', Event.ALT_MASK));
			if(item.getText().equals("잘라내기")) item.setAccelerator(KeyStroke.getKeyStroke('X', Event.ALT_MASK));
		}
//		for(JMenu each : jMenu) {
//			for(JMenuItem i : each.get) {
//			}
//		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem menu = (JMenuItem) e.getSource();
		
		if (menu.getText().equals("끝내기")) {
			int result = JOptionPane.showConfirmDialog(this, "저장하시겠습니까?", "메모장", JOptionPane.YES_NO_CANCEL_OPTION);
			if(result == JOptionPane.YES_OPTION) {
				System.out.println("파일 저장");
			}else if(result == JOptionPane.CANCEL_OPTION) return;
			System.exit(0);
			
		}else if(menu.getText().equals("새로만들기")) {
			ta.setText("");
			
		}else if(menu.getText().equals("저장")) {
			if(ta.getText().length()==0) return;
			saveDialog();
			if (file!=null) fileWrite();
			
		}else if(menu.getText().equals("열기")) {
			openDialog();
			if (file!=null) fileRead(file);
			
		}else if(menu.getText().equals("복사")) {
//			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//			String copyString = ta.getSelectedText();
//			if(copyString != null) {
//				StringSelection contents = new StringSelection(copyString);
//			    clipboard.setContents(contents, null);
//			};
			ta.copy();
			
		}else if(menu.getText().equals("붙여넣기")) {
//			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//			Transferable contents = clipboard.getContents(clipboard);
//			if(contents != null){
//			     try {
//			          String pasteString = (String)(contents.getTransferData(DataFlavor.stringFlavor));
//			          ta.insert(pasteString, ta.getCaretPosition());
//			     } catch (Exception ex) {ex.printStackTrace();}
//			}
			ta.paste();
			
		}else if(menu.getText().equals("잘라내기")) {
			ta.cut();			
		}
		
		
	}

	private void fileWrite() {
		try {
			FileWriter fw = new FileWriter(file);
			BufferedWriter br = new BufferedWriter(fw);
			br.write(ta.getText());
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void saveDialog() {
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showSaveDialog(this);
		if(result == JFileChooser.APPROVE_OPTION) file = chooser.getSelectedFile();
	}

	private void fileRead(File file)  {
		ta.setText("");
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String s;
			while((s = br.readLine())!=null) {
				ta.append(s+"\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void openDialog() {
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showOpenDialog(this);
		if(result == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
		}
	}

	public static void main(String[] args) {
		new TryNotepad();
	}
}
