package co.yedam.app.baseball;

import java.util.Scanner;
/*
 * 임의의 수 3개
 * 사용자 수 입력
 * 스트라이크, 볼 카운터
 */
public class BaseBallApp {
	int s;
	int b;
	int c1, c2, c3;
	int u1, u2, u3;
	
	void makeRnd() {
		while ((c1==c2) ||(c2==c3) || (c3==c1)) {
			c1= (int)(Math.random()*9+1);
			c2= (int)(Math.random()*9+1);
			c3= (int)(Math.random()*9+1);}
	}
	
	void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("세수를 입력:");
		u1 = scanner.nextInt();
		u2 = scanner.nextInt();
		u3 = scanner.nextInt();
	}
	
	void count() {
		 if (c1==u1) {s=s+1;}
		 if (c1==u2) {b=b+1;}
		 if (c1==u3) {b=b+1;}

		 if (c2==u1) {b=b+1;}
		 if (c2==u2) {s=s+1;}
		 if (c2==u3) {b=b+1;}

		 if (c3==u1) {b=b+1;}
		 if (c3==u2) {b=b+1;}
		 if (c3==u3) {s=s+1;}
		 System.out.printf("s= %d : b=%d",s,b);
		 System.out.println();
	}

	void start() {
		makeRnd();
		int count =0;
		int i = 10;
		while(s<3 &count<10){
			s=b=0;
			System.out.printf("기회가 %d번 남았습니다",i);
			System.out.println();
			input();
			count();
			count+=1;
			i-=1;
		}
			
		}
	

}
