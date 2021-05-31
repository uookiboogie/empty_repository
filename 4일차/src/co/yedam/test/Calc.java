package co.yedam.test;

//클래스:필드+메서드+생성자
public class Calc {
	
	//on/off 리턴값도 없고 매개변수 없음.
	void turnOn(){
		System.out.println("계산기 on");
	}
	//덧셈 리턴값 없고 매개변수 있음
//	void sum(int a, int b) {
//		System.out.println("int메서드");
//		System.out.println("두수의합=" + (a+b));
//	}	
	void sum(double a, double b) {
		System.out.println("double메서드");
		System.out.println("두수의합=" + (a+b));	
	}
	//덧셈 리턴도 있고 매개변수 있음.
	int sum2(int a, int b) {
		return a+b;
	}
	//덧셈 가변인수
	int sum3(int ... arr) {
		int result =0;
		for(int i=1; i<arr.length;i++) {
			result+=arr[i];}
		return result ;
		
	}
	//뺄셈
	//곱셈
	//나눗셈
	

}
