package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Vector;
import java.util.stream.Stream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ScoreImpl implements Score {
	private ScoreForm sf;
	private Vector<ScoreDTO> v_dto = new Vector<ScoreDTO>();
	private DefaultTableModel model;
	
	public ScoreImpl(ScoreForm sf) {
		this.sf = sf;
		Vector<String> title = new Vector<String>();
		Stream.of(sf.getField()).forEach(s -> title.add(s));
		model = new DefaultTableModel(title, 0);
	}
	
	@Override
	public void input(ScoreDTO dto) {
		dto.calc();
		v_dto.add(dto);
		JOptionPane.showMessageDialog(sf, dto.getName()+"�л��� �����Ͱ� �߰��Ǿ����ϴ�.");
	}

	@Override
	public void print(JTable output) {
		model.setRowCount(0);
		Vector<String> v;
		for(ScoreDTO d : v_dto) {			
			v = new Vector<String>();
			for(int i = 0; i < 7; i++) {
				v.add(d.getDataByIndex(i));
				System.out.println(d.getDataByIndex(i));
			}
			model.addRow(v);
		}
		output.setModel(model);
	}

	@Override
	public void search(JTable output) {
		model.setRowCount(0);
		for(ScoreDTO d : v_dto) {
			if(d.getHak().equals(sf.getSearch_name())) model.addRow(d.getVec());
		}
		print(sf.getTable());
	}

	@Override
	public void tot_desc() { // ����
		Collections.sort(v_dto);
		print(sf.getTable());
	}

	@Override
	public void save() {
		File file = null;
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showSaveDialog(sf);
		if (result == JFileChooser.APPROVE_OPTION) file = chooser.getSelectedFile();
		else return;
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			for(ScoreDTO d : v_dto) {
				oos.writeObject(d);
			}
			oos.writeObject(null);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void load() {
		File file = null;
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showOpenDialog(sf);
		if (result == JFileChooser.APPROVE_OPTION) file = chooser.getSelectedFile();
		else return;
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			ScoreDTO data;
			v_dto.clear();
			while((data = (ScoreDTO) ois.readObject()) != null) {
				v_dto.add(data);
			}
			ois.close();
			print(sf.getTable());
			JOptionPane.showMessageDialog(sf, "������ �о�Խ��ϴ�.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}