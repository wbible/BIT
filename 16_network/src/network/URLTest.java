package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class URLTest {

	public static void main(String[] args) throws IOException {
		URL url = new URL("https://www.naver.com/index.html");
		System.out.println("프로토콜 = " + url.getProtocol());
		System.out.println("호스트 = " + url.getHost());
		System.out.println("포트 = " + url.getPort());
		System.out.println("기본 포트 = " + url.getDefaultPort());
		System.out.println("파일 = " + url.getFile());
		System.out.println();

//		File file = new File("test.txt");
//		JFileChooser chooser = new JFileChooser();
//		
//		JFrame f = new JFrame();
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.setBounds(900, 100, 300, 300);
//		f.setVisible(true);
//		
//		int result = chooser.showSaveDialog(f);
//		if (result == chooser.APPROVE_OPTION) file = chooser.getSelectedFile();

		url = new URL("http://liebli.com/goods/goods_list.php?cateCd=001002");
		BufferedReader br = new BufferedReader((new InputStreamReader(url.openStream())));

		String line;
		StringBuffer txt = new StringBuffer();
		while ((line = br.readLine()) != null)
			txt.append(line + "\n");

		System.out.println("14K 개수: " + (txt.toString().split("14K|14k").length - 1));
		System.out.println("18K 개수: " + (txt.toString().split("18K|18k").length - 1));

//		FileWriter fw  = new FileWriter(file);
//		BufferedWriter bw = new BufferedWriter(fw);
//		bw.write(txt.toString());
//		bw.close();
	}

}
