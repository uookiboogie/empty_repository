package 문제4;

import java.util.Scanner;

public class MemoInsert implements MemoService{
	Scanner scanner = new Scanner(System.in);
	public MemoInsert() {}
	@Override
	public void excute(MemoData memodata) {
		System.out.print("Date(yyyymmdd)>");
		String date = scanner.next();
		System.out.print("Title>");
		String title = scanner.next();
		System.out.print("Content>");
		String content = scanner.next();
		
	}

}
