package co.micol.fly;

public class Bird extends Animal implements Flyer{
	@Override
	public void run() {
		//super.run();
		System.out.println("새가 달린다");
	}
	@Override
	public void eat() {
		//super.eat();
		System.out.println("새가 먹는다");
	}

	public void takeoff() {
		
	}
	public void fly() {
		
	}
	public void land() {
		
	}
	public void layEggs() {
		
	}
}
