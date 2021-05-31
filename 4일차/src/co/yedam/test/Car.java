package co.yedam.test;
/*
 * 자동차 정보
 * Car[]
 */
// 1단계 - 클래스선언
public class Car {
	//필드 - 상태, 속성 ~
	String company; //= "현대자동차";
	String model; //= "그랜저";
	String color; //= "검정";
	int maxSpeed; //= 350;
	int speed;
	
	//생성자
	/*
	 * 1.객체생성시에 호출도 필드 초기화 하는 특수용도의 메서드
	 * 2.생성자 이름은 클래스명과 동일
	 * 3.리턴타입 없음
	 * 4.생성자 여러개 중복선언(오버로딩)은 가능하지만 매개변수의 타입과 갯수는 달라야함
	 */
	Car(String company, String model, String color){
		this(company, model, color, 0, 0);
//		this.company = company;
//		this.model = model;
//		this.color= color;
	}
	Car(){
		this("현대자동차","그랜저","검정", 350, 0);
	}
	
	public Car(String model, int speed) {
		this("", model, "", 0, speed);
	}
		
	public Car(String company, String model, String color, int maxSpeed, int speed) {
			super();
			this.company = company;
			this.model = model;
			this.color = color;
			if(maxSpeed>100) {
				this.maxSpeed = maxSpeed;}
			else {
				this.maxSpeed =100;}
			if(speed>50) {
				this.speed = speed;}
			else {
				this.speed =50;}
		}
	@Override
	public String toString() {
		return "Car [company=" + company + ", model=" + model + ", color=" + color + ", maxSpeed=" + maxSpeed
				+ ", speed=" + speed + "]";
	}
	
}
