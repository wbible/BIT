package array;
//크기가 50개인 문자배열을 잡아서 65~90사이의 난수를 발생하여 저장 후 출력하시오
//A ~ Z까지 몇개인지 출력
//단 1줄에 10개씩 출력
public class Practice1 {
	public static void main(String[] args) {

		int size = 50;
		char[] arr = new char[size]; 
		int[] count = new int[26];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (char)(int)(Math.random() * ('Z' - 'A' + 1) + 'A');
			System.out.print(arr[i] + " ");
			if((i+1) % 10 == 0) System.out.println();
			count[arr[i]-'A']++;
		}
		
		System.out.println();
		for(int i = 0; i < count.length; i++) {
			System.out.printf("%s : %d\n", (char)(i + 'A'), count[i]);
		}
		
	}

}
