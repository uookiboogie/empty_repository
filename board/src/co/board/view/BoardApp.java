package co.board.view;

import java.util.List;

import co.board.Util.ScannerUtil;
import co.board.access.BoardAccess;
import co.board.access.BoardDAO;
import co.board.model.Board;

public class BoardApp {
	BoardAccess boarddao = new BoardDAO();

	public void start() {
		int menunum;
		do {
			menuTitle();
			menunum = ScannerUtil.readInt("입력");
			switch (menunum) {
			case 1:     selectAll();       break;
			case 2:     insert();          break;
			case 3:     update();          break;
			case 4:     delete();          break;
			case 5:     selectOne();       break;
			case 6:     commentInsert();   break;
			}
			}while (menunum!=0);
		}

	public void menuTitle() {
		System.out.println("===========================게시판관리==========================");
		System.out.println("|1.전체리스트 2.글등록 3.글수정 4.글삭제 5.한건조회 6.댓글작성|");
		System.out.println("============================0.종료=============================");		
	}

    public void selectAll() {
    	List<Board> list=boarddao.selectAll();
    	
    	list.stream()
    	.filter(t-> t.getParentid()==0)
    	.forEach(e-> System.out.println("글번호:"+e.getId()+"  제목:"+e.getTitle()+"  작성자:"+e.getWriter()));

    }
    public void insert() {
    	Board board =ScannerUtil.readBoard();
    	boarddao.insert(board);
    }
	
    public void update() {
    	Board board = new Board();
    	board.setId(ScannerUtil.readInt("수정하실 id(번호) 입력"));
    	board.setContent(ScannerUtil.readStr("수정하실 내용을 입력"));
    	boarddao.update(board);
    	
    }
    public void delete() {
    	int id=ScannerUtil.readInt("지우실 id(번호) 입력");
    	boarddao.delete(id);
	}
    public void selectOne() {
    	int id=ScannerUtil.readInt("검색하실 id(번호) 입력");
    	Board board =boarddao.selectOne(id);
    	System.out.println("글번호: "+board.getId());
    	System.out.println("작성자: "+board.getWriter());
    	System.out.println("제목: "+board.getTitle());
    	System.out.println("내용: "+board.getContent());
    	boarddao.commentlookup(id);
    	
	}	
    private void commentInsert() {
    	Board board = new Board();
    	int id=ScannerUtil.readInt("댓글 다실 글의 id(번호) 입력");
    	board.setWriter(ScannerUtil.readStr("작성자를 입력하세요"));
    	board.setContent(ScannerUtil.readStr("댓글작성하세요"));
    	board.setParentid(id);
    	boarddao.commentInsert(board);
    	
	}    
}