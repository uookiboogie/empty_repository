package co.micol.fly;

//다중상속 불가
public class Superman extends Human implements Flyer{
	public Superman() {}
	@Override
	public void takeoff() {
		System.out.println("슈퍼맨 이륙하다");
	}
	@Override
	public void fly() {
		System.out.println("슈퍼맨 날다");
	}
	@Override
	public void land() {
		System.out.println("슈퍼맨 착륙하다");
	}

}
