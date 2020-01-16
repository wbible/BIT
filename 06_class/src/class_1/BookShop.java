package class_1;

public class BookShop {
	private String bookName, author;
	private int price;
	
	public void setData(String bookName, String author, int price) {
		this.bookName = bookName;
		this.author = author;
		this.price = price;
	}
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
