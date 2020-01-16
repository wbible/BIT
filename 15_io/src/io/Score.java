package io;

import javax.swing.JTable;
import javax.swing.JTextArea;

public interface Score {
	public void input(ScoreDTO dto);
	public void print(JTable output);
	public void search(JTable output);
	public void tot_desc(); // ¼øÀ§
	public void save();
	public void load();
}
