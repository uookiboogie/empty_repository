package 문제4;

import java.util.Scanner;

public class MemoApp {

	public static void main(String[] args) {
		MemoData memodata=new MemoData();
		memodata.insert(new Memo(1,"20210102","자바","자바를 배우자"));
		memodata.insert(new Memo(2,"20210102","모임","1시에 모임"));
		MemoService[] service = {null, new MemoInsert(), new MemoFindDate()};
		int menu =0;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("1.등록   2.날짜로조회   0.종료");
			System.out.print("입력>");
			menu = scanner.nextInt();
			if(menu<service.length) {
				if(menu==0) break;
				service[menu].execute(memodata);
			}else {
			 System.out.println("올바른 숫자를 입력해주세요");
			}
		}while(true);
	}

}
