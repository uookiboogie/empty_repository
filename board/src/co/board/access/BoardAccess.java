package co.board.access;

import java.util.List;

import co.board.model.Board;

public interface BoardAccess {
	//전체리스트 조회
	public List<Board> selectAll();
	//글등록
	public void insert(Board board);
	//글수정
	public void update(Board board);
	//글삭제
	public void delete(int id);
	//단건 조회(상세히 조회)
	public Board selectOne(int id);
	
	
	//댓글 작성
	public void commentInsert(Board board);
	//댓글 조회
	public List<Board> commentlookup(int parentid);
	
}
