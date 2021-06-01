package 도형;

public class Tri extends Shape  implements Drawable{
	int h;
	public Tri(int w, int h) {
		super(w); //this.w=w;
		this.h =h;
	}
	public void area() {
		result = w*h/2;
	}
	@Override
	public void draw() {
		System.out.println("Tri draw");
	}

}
