package co.memo.access;

import java.util.List;

import co.memo.model.Memo;

public interface MemoAccess {
	public void write(String date, String title, String content);
	public void update(Memo memo);
	public void delete(String date);
	public List<Memo> FindAll();
	public Memo FindByDate(String date);
	public Memo FindByContent(String content);
}
