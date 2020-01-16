package inheritance;

enum EnumColor2{
	// enum 괄호 안의 데이터는 생성자로 전달된다.
	RED("빨강"), GREEN("초록"), BLUE("파랑"), MAGENTA("보라");
	
	private String colorName;
	
	EnumColor2(String colorName){
		this.colorName = colorName;
	}
	
	public String getColorName() {
		return colorName;
	}
}


public class EnumMain2 {

	public static void main(String[] args) {
		
		
		for(EnumColor2 data : EnumColor2.values()) {
			System.out.println(data + "\t" + data.ordinal() + "\t" + data.getColorName());
		}

	}

}
