package abstract_1;

class Test{

	@Override
	public String toString() {
		return getClass().getName() + "��ü t";
	}
	
	
}

//-----------
public class ObjectMain {

	public static void main(String[] args) {
		Test t = new Test();
		System.out.println("��ü t = " + t);
		System.out.println("��ü t = " + t.toString());
		System.out.println("��ü t = " + t.hashCode()); //10����

		String str = "";
		System.out.println("��ü str = " + str);
		System.out.println("��ü str = " + str.toString());
		System.out.println("��ü str = " + str.hashCode());
		System.out.println();
		
		String aa = new String("apple");
		String bb = new String("apple");
		System.out.println(aa==bb);
		System.out.println();
		
		Object cc = new String("apple");
		Object dd = new String("apple");
		System.out.println(cc==dd);
		System.out.println(cc.equals(dd));
		
		
	}

}
