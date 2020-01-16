package constructor;
import java.util.stream.IntStream;

public class VarArgs {
	
//	public int sum(int a, int b) {return a + b;}
//	public int sum(int a, int b, int c) {return a + b + c;}
//	public int sum(int a, int b, int c, int d) {return a + b + c + d;}
	
	public int sum(int... ar) {
		return IntStream.of(ar).sum();
	}
	
	public static void main(String[] args) {
		VarArgs va = new VarArgs();
		
		System.out.println("гу = " + va.sum(10, 20));
		System.out.println("гу = " + va.sum(10, 20, 30));
		System.out.println("гу = " + va.sum(10, 20, 30, 40));
	}
}
