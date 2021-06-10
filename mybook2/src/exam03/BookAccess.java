package exam03;

import java.util.List;

// 도서관리 개발 표준
public  abstract class BookAccess {
	//등록
	public abstract void insert(Book book);	
	//이름으로조회
	public abstract List<Book> findName(String name);
	//isbn 조회
	public abstract Book findIsbn(String isbn);
	//전체 조회
	public abstract List<Book> findAll();
		
}
