package co.micol.fly;

public class Human extends Animal{
	public Human() {}
	
	public void think() {
		System.out.println("생각한다");
	}
	
	@Override
	public void eat() {
		System.out.println("고기, 채소 먹는다");
	}
	
}
