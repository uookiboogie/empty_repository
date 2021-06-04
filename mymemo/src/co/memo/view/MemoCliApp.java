package co.memo.view;

import co.memo.Util.ScannerUtil;
import co.memo.acess.MemoList;

public class MemoCliApp {
	MemoList memolist = new MemoList();
	
	public void start() {
		int menunum;
		do {
			menuTitle();
			menunum = ScannerUtil.readInt("입력");
			switch (menunum) {
			case 1:       insert();    break;
			case 2:       update();    break;
			case 3:       delete();    break;
			case 4:       selectAll();    break;
			case 5:       findDate();    break;
			case 6:       findContent();    break;
			}
			}while (menunum!=0);
		}

	public void menuTitle() {
		System.out.println("======메모관리======");
		System.out.println("====================");
		System.out.println("|    1.메모등록    |");
		System.out.println("|    2.메모수정    |");
		System.out.println("|    3.메모삭제    |");
		System.out.println("|  4.메모전체조회  |");
		System.out.println("|    5.날짜검색    |");
		System.out.println("|    6.내용검색    |");
		System.out.println("====================");
		System.out.println("|      0.종료      |");		
	}

	
	private void insert() {
		// TODO Auto-generated method stub
		
	}



	private void update() {
		// TODO Auto-generated method stub
		
	}



	private void delete() {
		// TODO Auto-generated method stub
		
	}



	private void selectAll() {
		// TODO Auto-generated method stub
		
	}



	private void findDate() {
		// TODO Auto-generated method stub
		
	}



	private void findContent() {
		// TODO Auto-generated method stub
		
	}
	
}
