package co.memo.acess;

import java.util.ArrayList;

import co.memo.model.Memo;

public interface MemoAccess {
	//메모등록
	public void insert(Memo memo);
	//메모수정
	public void update(Memo memo);
	//메모삭제
	public void delete(String date);
	//메모전체조회
	public ArrayList<Memo> selectAll();
	//날짜검색
	public Memo findDate(String Date);
	//내용검색
	public Memo findContent(String content);
	
}
