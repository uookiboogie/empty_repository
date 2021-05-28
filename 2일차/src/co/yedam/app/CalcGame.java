package co.yedam.app;

import java.util.Scanner;

/*
 * 계산기 게임
 * 사칙연산, 진수변환, 문자값 검사
 */
public class CalcGame {
	//정수값 두 수 의 합을 계산 메서드(함수)
	double a;
	double b;
	
	//1~cnt까지의 합을 계산해서 리턴
	int sum(int cnt) {
		int result =0;
		for(int i=0; i<=cnt; i++) {
			result += i;
		}
		return result;
	}
	
	void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("입력:");
		String s1 = scanner.next();
		//double x = scanner.nextDouble();
		System.out.print("입력:");
		String s2 = scanner.next();
		//double y = scanner.nextDouble();
		}
		
	double add() { 
	    return a+b;}
	
	//두 수의 몫을 계산 5/2 2
	int share() { 
		return (int)(a/b);}
	
	//두 수 의 나눗셈 5/2 2.5
	double div() { 
		return a/b;}
	
	//두 수의 나머지 연산 5%2 1
	int rest() { 
		return (int)(a % b); }
	

}
