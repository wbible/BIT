package thread;

public class SingleTon {
	private int num = 3;
	private static SingleTon instance;
	
	public static SingleTon getInstance() {
		if(instance==null) {
			synchronized(SingleTon.class) {
				instance = new SingleTon();
			}
		}
		return instance;
	}
	
	public static void main(String[] args) {
//		SingleTon aa = new SingleTon();
//		aa.num++;
//		System.out.println("aa = " + aa);
//		System.out.println("num = " + aa.num);
//		System.out.println();
//		
//		SingleTon bb = new SingleTon();
//		bb.num++;
//		System.out.println("bb = " + aa);
//		System.out.println("num = " + bb.num);
//		System.out.println();
		
		System.out.println("*** �̱��� ***");
		SingleTon cc = getInstance();
		cc.num++;
		System.out.println("cc = " + cc);
		System.out.println("num = " + cc.num);
		System.out.println();
		
		SingleTon dd = getInstance();
		dd.num++;
		System.out.println("dd = " + dd);
		System.out.println("num = " + dd.num);
		System.out.println();
		
		SingleTon ee = getInstance();
		ee.num++;
		System.out.println("ee = " + ee);
		System.out.println("num = " + ee.num);
		System.out.println();
		
	}
	

}
