package 문제4;

import java.util.List;
import java.util.Scanner;

public class MemoFindDate implements MemoService{
	
	public MemoFindDate() {}
	Scanner scanner = new Scanner(System.in);
	@Override
	public void execute(MemoData memodata) {
		//검색할 날짜 입력
		System.out.print("날짜(yyyymmdd)>");
		String date = scanner.next();
		//리스트에서 검색
		List<Memo> list = memodata.findDate(date);
		//결과출력
		if(list.size()!=0) {
			for(Memo m: list) {
				System.out.printf("%20s %20s %20s\n",m.getDate(),m.getTitle(),m.getContent());
				//System.out.println(m.toString());
				}    
		}else {
			System.out.println("해당 날짜로 조회된 메모가 없습니다.");
		}
	}

}
