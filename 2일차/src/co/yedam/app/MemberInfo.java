package co.yedam.app;

import java.util.Scanner;

public class MemberInfo {	
	String name;
	String id;
	String tel;
	//키, 몸무게
	double height; //키
	double weight; //몸무게
	
	Scanner scanner = new Scanner(System.in);
	
	void heightWeightInput() {
		//System.out.println("[필수 정보 입력]");
		//System.out.print("1. 이름:");
		//name = scanner.next();
		System.out.print("1. 키(cm):");
		height = scanner.nextDouble();
		System.out.print("2. 몸무게(kg):");
		weight = scanner.nextDouble();
	
	}
	String bmi() {
		double result=0;
		result= weight/(height/100*height/100);
		String s = " ";
		
		if (result<18.5){
			s ="저체중";
		}else if (result<=23){
			s ="정상";			
		}else if (result<=25){
			s ="과체중";
		}else if (result<=30) {
			s ="비만";
		}else {
			s ="고도비만";
		}
		System.out.println(result);
		return s;
	}
	
	void input() {
		Scanner scanner = new Scanner(System.in);
		//코드작성
		System.out.println("[필수 정보 입력]");
		System.out.print("1. 이름:");
		name = scanner.next();
		System.out.print("2. 주민번호 앞 6자리:");
		id = scanner.next();
		System.out.print("3. 전화번호:");
		tel = scanner.next();
		scanner.close();
	}
	void print() {
		System.out.println();
		System.out.println("[입력한 내용]");
		System.out.println(name);
		System.out.println(id);
		System.out.println(tel);
	}

}
