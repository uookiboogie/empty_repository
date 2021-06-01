package co.micol.fly;

public abstract class Animal {
	
	//기본 생성자
	public Animal() {}
	
	public void run() {
		System.out.println("달린다");
	}
	public abstract void eat();

	public void sleep() {
		System.out.println("잔다");
	}

}
