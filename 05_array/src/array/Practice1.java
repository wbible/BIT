package array;
//ũ�Ⱑ 50���� ���ڹ迭�� ��Ƽ� 65~90������ ������ �߻��Ͽ� ���� �� ����Ͻÿ�
//A ~ Z���� ����� ���
//�� 1�ٿ� 10���� ���
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
