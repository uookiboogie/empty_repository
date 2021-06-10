package 문제4;

import java.util.ArrayList;
import java.util.List;

public class MemoData extends MemoAccess{
	List<Memo> memodata = new ArrayList<Memo>();
	
	@Override
	public void insert(Memo memo) {
		memodata.add(memo);
	}
	@Override
	public List<Memo> findDate(String date) {
		List<Memo> list = new ArrayList<Memo>();
		for (Memo m: memodata)
			if(m.getDate().equals(date)) {
				list.add(m);
			}	
		return list;
	}

}
