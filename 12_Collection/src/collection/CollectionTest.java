package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;


class CollectionTest {
	@SuppressWarnings("all")
	public static void main(String[] args) {
		Collection coll = new ArrayList();
		coll.add("ȣ����");
		coll.add("����");
		coll.add("ȣ����");
		coll.add(25);
		coll.add(43.8);
		coll.add("�⸰");
		coll.add("�ڳ���");
		
		Iterator it = coll.iterator();
		while(it.hasNext()) { // �׸� T/F			
			System.out.println(it.next()); // ���� ��ġ�� �׸��� ������ �������� �̵�
		}
		
	}

}
