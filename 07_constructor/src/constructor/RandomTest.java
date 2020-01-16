package constructor;

import java.util.Random;

public class RandomTest {
	public RandomTest() {
		Random rd = new Random();
		System.out.println("난수 = " + rd.nextInt());
		System.out.println("난수 = " + (rd.nextInt(100) + 1));
	}
	
	public static void main(String[] args) {
		new RandomTest();
		
	}
}
