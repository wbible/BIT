package swing;

import java.awt.Color;

import swing.MsPaint.E_shape;

public class ShapeDTO {
	private int x1, y1, x2, y2;
	private long pen_group;
	private E_shape shape;
	private Color color;
	
	public ShapeDTO(E_shape E_shape, Color color, int x1, int y1, int x2, int y2, long pen_group) {
		this.shape = E_shape;
		this.color = color;
		this.x1 = x1; this.y1 = y1;
		this.x2 = x2; this.y2 = y2;
		this.pen_group = pen_group;
	}
	public E_shape getShape() {
		return shape;
	}
	public Color getColor() {
		return color;
	}
	public int getX1() {
		return x1;
	}
	public int getY1() {
		return y1;
	}
	public int getX2() {
		return x2;
	}
	public int getY2() {
		return y2;
	}
	public long getPen_group() {
		return pen_group;
	}
}
