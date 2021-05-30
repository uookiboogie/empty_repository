package co.yedam.numgame;

import java.util.Scanner;

public class NumberGameApp {
	
	int com;   //컴퓨터가 만든 수 (1~10)
	int user;  //사용자가 입력한 값
	
	void init() {
		 com=(int)(Math.random()*10)+1;
		 System.out.println(com);
	}
	
	//사용자 수를 입력
	void input() {
		Scanner scanner = new Scanner(System.in);
		user =scanner.nextInt();
	}
	
	//높다.낮다 판단 / true false
	boolean confirm() {
		//com과 user를 비교해서 같으면 true 리턴
		//다르면 높다/낮다 출력하고 false 리턴
		if (com==user){
			return true;
		}
		else if (com>user) {
			System.out.println("낮다");
			return false;
		}
		else {
			System.out.println("높다");
			return false;
		}
		
	}
    void start() {
    	init();
    	while(true) {
    		input();
    		if(confirm()) {
    			break;
    		}
    	}
	
    }
}
