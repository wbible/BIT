package inheritance;

class AAA{}
class BBB extends AAA{}

public class InstanceOf {
	public static void main(String[] args) {
		AAA aa = new AAA();
		BBB bb = new BBB();
		AAA aa2 = new BBB();
		
		AAA aa3 = aa;
		
		System.out.println(("1. " + (aa instanceof AAA)).toUpperCase());
		
		AAA aa4 = bb;
		System.out.println(("2. " + (bb instanceof AAA)).toUpperCase());
		
//		BBB bb2 = (BBB) aa; // error
		System.out.println(("3. " + (aa instanceof BBB)).toUpperCase());
		
		BBB bb3 = (BBB) aa2;
		System.out.println(("4. " + (aa2 instanceof BBB)).toUpperCase());
	}
}
