package inheritance;

class Final {
	public final String FRUIT = "사과";
	public final String FRUIT2;
	
	public static final String ANIMAL = "사자";
	public static final String ANIMAL2;
	
	static {
		ANIMAL2 = "기린";
	}
	
	public Final() {
		FRUIT2 = "딸기";
	}
	
}

public class FinalMain {

	public static void main(String[] args) {
		final int AGE = 25;
		final int AGE2;
		AGE2 = 30;
		
		Final f = new Final();
		
		System.out.println("FRUIT = " + f.FRUIT);
		System.out.println("FRUIT = " + f.FRUIT2);
		
		System.out.println("ANIMAL = " + Final.ANIMAL);
		System.out.println("ANIMAL2 = " + Final.ANIMAL2);
		
	}

}
