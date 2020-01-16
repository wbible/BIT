package nested;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Card {
	private Frame frame;
	private CardLayout card;
	
	public Card() {
		frame = new Frame();
		frame.setBounds(800,300, 300,300);
		
		card = new CardLayout();
		frame.setLayout(card);
		
		String[] title = {"»¡°­", "ÃÊ·Ï", "ÆÄ¶û", "³ë¶û", "º¸¶ó", "ÇÏ´Ã"};
		Color[] color = {new Color(241,95,95), new Color(71,20,62), new Color(67,116,217), new Color(250,237,125), new Color(209,178,255), new Color(178,235,244)}; 
		Panel[] p = new Panel[6];
		for(int i = 0; i < p.length; i++) {
			p[i] = new Panel();
			p[i].setBackground(color[i]);
			frame.add(p[i], title[i]);
			
			p[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
//					card.next(frame);
					card.show(frame, "ÇÏ´Ã");
				}
			});
			
		}
		
		
		
		
		
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Card();

	}

}
