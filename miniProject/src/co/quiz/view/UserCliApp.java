package co.quiz.view;

import java.util.Scanner;

import co.quiz.access.UserDAO;
import co.quiz.util.ScanUtil;

public class UserCliApp {
	
	UserDAO userdao= new UserDAO();
	
	public void menuTitle() {
		System.out.println("===QUIZ game===");
		System.out.println("1.회원가입 2.회원조회 3.로그인");
		System.out.println("0.종료");
	}
	//처음 실행
	public void start() {
		int menunum;
		do {
			menuTitle();
			menunum = ScanUtil.readInt("선택");
			switch (menunum) {
			case 1:    signUp();     break;
			case 2:    logIn();     break;
			case 3:    userEdit();     break;
			}
		   }while(menunum!=0);
		    System.out.println("프로그램 종료");
	}
	private void signUp() {
		// TODO Auto-generated method stub
		
	}
	private void logIn() {
		// TODO Auto-generated method stub
		
	}
	private void userEdit() {
		// TODO Auto-generated method stub
		
	}
	
}
