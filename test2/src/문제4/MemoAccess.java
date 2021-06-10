package 문제4;

import java.util.List;

public abstract class MemoAccess {
	
	public abstract void insert(Memo memo);
	
	public abstract List<Memo> findDate(String date);
	
	
}
