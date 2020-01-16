package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;


class CollectionTest {
	@SuppressWarnings("all")
	public static void main(String[] args) {
		Collection coll = new ArrayList();
		coll.add("호랑이");
		coll.add("사자");
		coll.add("호랑이");
		coll.add(25);
		coll.add(43.8);
		coll.add("기린");
		coll.add("코끼리");
		
		Iterator it = coll.iterator();
		while(it.hasNext()) { // 항목 T/F			
			System.out.println(it.next()); // 현재 위치의 항목을 꺼내고 다음으로 이동
		}
		
	}

}
