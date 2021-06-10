package 문제4;

import java.util.Scanner;

public class MemoInsert implements MemoService{
	public MemoInsert() {}
	Scanner scanner = new Scanner(System.in);
	@Override
	public void execute(MemoData memodata) {
		System.out.print("DATE(yyyymmdd)>");
		String date = scanner.next();
		System.out.print("TITLE>");
		String title = scanner.next();
		System.out.print("CONTENT>");
		String content = scanner.next();
		Memo m = new Memo();
		m.setNo(memodata.memodata.size()+1);
		m.setDate(date);
		m.setTitle(title);
		m.setContent(content);
		memodata.insert(m);
	}

}
