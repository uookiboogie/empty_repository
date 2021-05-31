package co.yedam.score;

import java.util.Scanner;

public class ArrayApp2 {
	int[] arr;                              //성적
	int studentNum;                         //학생수
	
	Scanner scanner= new Scanner(System.in);
	
	void init() {
		System.out.print("인원수>");
		studentNum = scanner.nextInt();
		arr = new int[studentNum];
	}
	void input() {
		//배열에 초기값 지정
		for(int i=0; i<arr.length; i++) {
			System.out.printf("scores[%d]> ", i);
			int score = scanner.nextInt();
			arr[i]=score;
		}
	}
	void avg() {
		int result =0;
		for(int i=0; i<arr.length;i++) {
			result+=arr[i];}
		System.out.println("평균 점수=" + (result/arr.length));}

	void max() {
		int max = arr[0];
		for (int i=0 ; i<arr.length; i++) {
			if (max<arr[i]) {
				max = arr[i];}
		}
		System.out.println("최고 점수=" + max);
		}
	
	void print() {
		for(int i=0; i<arr.length; i++) {
			System.out.printf("scores[%d]> %d\n", i, arr[i]);
		}
	}

	public static void main(String[] args) {
		ArrayApp2 app = new ArrayApp2();
		
		boolean run = true;
		Scanner scanner = new Scanner(System.in);
		int selectNo =0;
		while(run) {
			System.out.println("1.학생수 2.점수입력 3.점수리스트 4.분석 5종료");
			System.out.print("선택>");
			selectNo = scanner.nextInt();
			if(selectNo==1) {
				app.init();}
			else if(selectNo==2) {
			    app.input();}
			else if(selectNo==3) {
				app.print();}
			else if(selectNo==4) {
			    app.max();
			    app.avg();}
			else if(selectNo==5) {
			    run= false;}
		}
		System.out.println("프로그램 종료");
		}
}