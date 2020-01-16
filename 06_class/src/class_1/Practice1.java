package class_1;

public class Practice1 {
	public static void main(String[] args) {
		
		BookShop[] bs = new BookShop[2];
		for (int i = 0; i < bs.length; i++) {
			bs[i] = new BookShop();
		}
		bs[0].setBookName("자바완성");
		bs[0].setAuthor("김완성");
		bs[0].setPrice(25000);
		
		bs[1].setBookName("JSP잡기");
		bs[1].setAuthor("송JP");
		bs[1].setPrice(35000);
		
		for (BookShop b : bs) {
			System.out.println("책 이름: " + b.getBookName());
			System.out.println("저   자 : " + b.getAuthor());
			System.out.printf("가   격 : %d원\n", b.getPrice());
			System.out.println();
		}
		
	}
}
