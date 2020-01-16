package abstract_1;

class Test{

	@Override
	public String toString() {
		return getClass().getName() + "按眉 t";
	}
	
	
}

//-----------
public class ObjectMain {

	public static void main(String[] args) {
		Test t = new Test();
		System.out.println("按眉 t = " + t);
		System.out.println("按眉 t = " + t.toString());
		System.out.println("按眉 t = " + t.hashCode()); //10柳荐

		String str = "";
		System.out.println("按眉 str = " + str);
		System.out.println("按眉 str = " + str.toString());
		System.out.println("按眉 str = " + str.hashCode());
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
