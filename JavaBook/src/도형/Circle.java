package 도형;

public class Circle extends Shape implements Drawable {
	public Circle (int w) {
		super(w);
		//this.w =w;
	}
	public void area() {
		result = w*w*3.14;
	}
	@Override
	public void draw() {
		System.out.println("Circle draw");
	}
}
