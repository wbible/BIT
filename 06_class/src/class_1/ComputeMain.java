package class_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ComputeMain {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Compute[] ar = new Compute[3];
		for(int i = 0; i < ar.length; i++) { ar[i] = new Compute();
			System.out.print("x 입력 : ");
			ar[i].setX(Integer.parseInt(br.readLine()));
			System.out.print("y 입력 : ");
			ar[i].setY(Integer.parseInt(br.readLine()));
			ar[i].calc();
			System.out.println();
		}

		System.out.printf("X\tY\tSUM\tSUB\tMUL\tDIV\n");
		for(Compute c : ar) {
			System.out.printf("%d\t%d\t%d\t%d\t%d\t%.2f\n", 
					c.getX(), c.getY(), c.getSum(), c.getSub(), c.getMul(), c.getDiv());
		}
		
		
	}
}
