package co.yedam.test;

public class CarExample {

	public static void main(String[] args) {
		//2단계 객체생성(인스턴스)
		Car myCar = new Car();
		myCar.company ="삼성자동차";
		myCar.color="블루";
		System.out.println("제작회사:"+myCar.company);
		System.out.println("색깔:"+myCar.color);
		
		//생성자
		Car youCar = new Car("르노","SM6","블루");
		System.out.println(youCar.toString());
		
		Car miniCar = new Car("코나", 40);
		System.out.println(miniCar.toString());
		
		//필드값 읽기
//		Car myCar = new Car();
//		System.out.println("제작회사:"+myCar.company);
//		System.out.println("모델명:"+myCar.model);
//		System.out.println("색깔:"+myCar.color);
//		System.out.println("최고속도:"+myCar.maxSpeed);
//		System.out.println("현재속도:"+myCar.speed);
		
		//필드값 변경
//		myCar.speed =100;
//		System.out.println("수정된 속도:"+myCar.speed);

	}

}
