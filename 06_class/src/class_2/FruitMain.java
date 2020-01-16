package class_2;

public class FruitMain {
	public static void main(String[] args) {
		Fruit[] ar = new Fruit[3];
		
		ar[0] = new Fruit("사과", 100, 80, 75);
		ar[1] = new Fruit("포도", 30, 25, 10);
		ar[2] = new Fruit("딸기", 25, 30, 90);
		
		String dash = "-----------------------------------";
		System.out.println(dash);
		System.out.printf("PUM\tJAN\tFEB\tMAR\tTOT\n");
		System.out.println(dash);
		for(int i = 0; i < ar.length; i++) {
			ar[i].display();
		}
		System.out.println(dash);
		Fruit.output();
	}
}
