package sudoku;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class OptionLabel extends JLabel implements MouseListener {
	
	private Color color_main = new Color(52,72,97);
	private Color color_mouseover = new Color(243,246,250);
	private Color color_clicked = new Color(230,234,240);
	
	private Font font_num = new Font("���� ����", Font.BOLD, 25);
	private Sudoku sudoku;
	
	public OptionLabel(Sudoku sudoku) {
		this.sudoku = sudoku;
		setBorder(BorderFactory.createLineBorder(color_main, 1));
		setOpaque(true);
		setBackground(Color.WHITE);
		setForeground(color_main);
		setFont(font_num);
		addMouseListener(this);
	}
	
	public OptionLabel(Sudoku sudoku, String text, int horizontalAlignment) {
		this(sudoku);
		setText(text);
		setHorizontalAlignment(horizontalAlignment);
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		OptionLabel lb = (OptionLabel) e.getSource();
		if(lb.getText().equals("��Ʈ")) {
			
		}else if(lb.getText().equals("��Ʈ")) {
			
		}else if(lb.getText().equals("�������")) {
			
		}else if(lb.getText().equals("�����")) {
			sudoku.setNumber("");
		}else sudoku.setNumber(getText());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		OptionLabel lb = (OptionLabel) e.getSource();
		lb.setBackground(color_mouseover);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		OptionLabel lb = (OptionLabel) e.getSource();
			lb.setBackground(Color.WHITE);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		OptionLabel lb = (OptionLabel) e.getSource();
		lb.setBackground(color_clicked);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		OptionLabel lb = (OptionLabel) e.getSource();
		lb.setBackground(color_mouseover);
	}
	
}
