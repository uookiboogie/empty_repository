package exam03;

import java.util.ArrayList;
import java.util.List;
/*
 * 여러건의 도서정보를 저장 -> DAO(데이터베이스)
 */
public class BookList extends BookAccess  {
	
	ArrayList<Book> books = new ArrayList<Book>();

	@Override
	public void insert(Book book) {
		books.add(book);
	}

	@Override
	public List<Book> findName(String name) {
		List<Book> list = new ArrayList<Book>(); 
		for (Book b : books) { //모든 도서 비교
			if(b.getName().contains(name)) { //도서명이 포함된 도서만..
				list.add(b); 
			}
		}
		return list; 
	}
	@Override
	public Book findIsbn(String isbn) {
		Book book =null;
		for(Book b: books) {
			if(b.getIsbn().equals(isbn)) {
				book=b;
				break;
			}
		}
		return book;
	}

	@Override
	public List<Book> findAll() {
		List<Book> list= new ArrayList<Book>();
		for(Book b: books) {
			list.add(b);
		}
		return list;
	}
	

}
