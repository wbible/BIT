package collection;

import java.util.ArrayList;
import java.util.Iterator;

public class PersonMain {

	public ArrayList<PersonDTO> init() {
		PersonDTO aa = new PersonDTO("ȫ�浿", 25);
		PersonDTO bb = new PersonDTO("��ġ", 40);
		PersonDTO cc = new PersonDTO("�ڳ�", 16);
		
		ArrayList<PersonDTO> list = new ArrayList<PersonDTO>();
		list.add(aa);
		list.add(bb);
		list.add(cc);
		return list;
	}
	
	public static void main(String[] args) {
		PersonMain pm = new PersonMain();
		for(PersonDTO person : pm.init()) {
//			System.out.println("�̸� = " + person.getName() + " \t���� = " + person.getAge());
			System.out.println(person);
		}
		
		System.out.println();
		Iterator<PersonDTO> it = pm.init().iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
