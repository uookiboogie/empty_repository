package 문제4;

import java.util.List;
import java.util.Scanner;

public class MemoFindDate implements MemoService{
	
	public MemoFindDate() {}
	Scanner scanner = new Scanner(System.in);
	@Override
	public void excute(MemoData memodata) {
		//검색할 날짜 입력
		System.out.print("검색할 날짜(yyyymmdd)>");
		String date = scanner.next();
		//리스트에서 검색
		List<Memo> list = memodata.findDate(date);
		//결과출력
		for(Memo m: list) {
			System.out.println(m);
		}
	}

}
