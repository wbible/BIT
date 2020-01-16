package class_1;

public class ShapeTest {
	private final double PI = 3.141592;
	
	public double area(int r) {
		return r * r * PI;
	}
	public double area(int x, int y) {
		return x * y / 2.0;
	}
	public double area(int x, int y, int z) {
		return (x + y) * z / 2.0;
	}
}
