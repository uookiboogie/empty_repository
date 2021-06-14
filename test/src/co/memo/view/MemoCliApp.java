package co.memo.view;

import java.util.List;
import java.util.Scanner;

import co.memo.access.MemoAccess;
import co.memo.access.MemoDAO;
import co.memo.model.Memo;

public class MemoCliApp {

	MemoAccess access = new MemoDAO(); // 데이터베이스 입출력 처리하세요.
	Scanner scanner = new Scanner(System.in);

	public void start() {
		int menuNum;

		do {
			menuTitle();
			System.out.print("입력 > ");
			menuNum = scanner.nextInt();
			scanner.nextLine();//엔터삭제
			switch (menuNum) {
			case 1:
				insert();
				break;
			case 2:
				update();
				break;
			case 3:
				delete();
				break;
			case 4:
				selectAll();
				break;
			case 5:
				findByDate();
				break;
			case 6:
				findByContent();
				break;
			}
		} while (menuNum != 0);
		System.out.println("프로그램 종료.");
	}

	private void insert() {
	    System.out.print("날짜를 입력하세요(yyyymmdd)>");
		String date =scanner.nextLine();
	    System.out.print("제목을 입력하세요>");
	    String title =scanner.nextLine();
	    System.out.print("내용을 입력하세요>");
	    String content=scanner.nextLine();
		access.write(date, title, content);
	}

	private void update() {
		Memo memo = new Memo();
		System.out.print("수정하실 날짜를 입력하세요(yyyymmdd)>");
		String date =scanner.nextLine();
		System.out.print("수정하실 내용을 입력하세요>");
		String content =scanner.nextLine();
		memo.setDate(date);
		memo.setContent(content);
		access.update(memo);
	}

	private void delete() {
		System.out.print("지우실 날짜를 입력하세요(yyyymmdd)>");
		String date =scanner.nextLine();
		access.delete(date);
	}

	private void selectAll() {
		List<Memo> list=access.FindAll();
		for(Memo memo : list) {
			memo.print();
		}
	}

	private void findByDate() {
		System.out.print("검색하실 날짜를 입력하세요(yyyymmdd)>");
		String date =scanner.nextLine();
		Memo memo = access.FindByDate(date);
		memo.print();
	}

	private void findByContent() {
		System.out.print("검색하실 내용을 입력하세요>");
		String content =scanner.nextLine();
		Memo memo = access.FindByContent(content);
		memo.print();
	}

	private void menuTitle() {
		System.out.println("== 메모 관리 ==");
		System.out.println("=1. 메모 추가");
		System.out.println("=2. 메모 수정");
		System.out.println("=3. 메모 삭제");
		System.out.println("=4. 전체 조회");
		System.out.println("=5. 날짜로 조회");
		System.out.println("=6. 내용으로 조회");
		System.out.println("=0. 종료");
		System.out.println("===============");

	}

}
