package collection;

import java.util.Iterator;
import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		Vector<String> v = new Vector<String>(1, 5);
		System.out.println("º¤ÅÍ Å©±â = " + v.size());
		System.out.println("º¤ÅÍ ¿ë·® = " + v.capacity());
		System.out.println();
		
		System.out.println("Ç×¸ñ Ãß°¡");
		for(int i = 1; i <= 10; i++) {
			v.add(i + "");
			System.out.print(v.get(i-1) + " ");
		}
		System.out.println();
		System.out.println("º¤ÅÍ Å©±â = " + v.size());
		System.out.println("º¤ÅÍ ¿ë·® = " + v.capacity());
		System.out.println();
		
		v.addElement(5 + ""); // Áßº¹Çã¿ë, ¼ø¼­
		System.out.println("º¤ÅÍ Å©±â = " + v.size());
		System.out.println("º¤ÅÍ ¿ë·® = " + v.capacity());
		
		for(int i = 0; i < v.size(); i++) System.out.print(v.get(i) + " ");
		System.out.println();
		
//		v.remove("5");
		v.remove(10);
		Iterator<String> it = v.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();
		
		
		
	}

}
