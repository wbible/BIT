package inheritance;

enum EnumColor2{
	// enum ��ȣ ���� �����ʹ� �����ڷ� ���޵ȴ�.
	RED("����"), GREEN("�ʷ�"), BLUE("�Ķ�"), MAGENTA("����");
	
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
