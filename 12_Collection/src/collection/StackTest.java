package collection;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		String[] groupA = {"���Ű��ź", "�����Ʈ", "����", "���ѹα�"};
		Stack<String> stack = new Stack<String>();
		
		for(int i = 0; i < groupA.length; i++) {
			stack.push(groupA[i]);
		}
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

}
