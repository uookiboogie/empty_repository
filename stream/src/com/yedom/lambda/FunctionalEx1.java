package com.yedom.lambda;

interface Run{
	void run();
}
class RunCls implements Run {
	@Override
	public void run() {
		System.out.println("달립니다");	
	}	
}
public class FunctionalEx1 {
	public static void main(String[] args) {
		RunCls cls = new RunCls();
		cls.run();
		
//		Run r = new Run() {
//			@Override
//			public void run() {
//				System.out.println("빨리 달립니다");
//			}
//	    };
		Run r = () -> System.out.println("빨리 달립니다"); // consumer type 함수
		r.run();
	}

}
