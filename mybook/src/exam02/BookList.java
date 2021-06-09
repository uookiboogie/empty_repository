package exam02;

import java.util.ArrayList;
import java.util.List;

public class BookList extends BookAccess{
	
	ArrayList<Book> books=new ArrayList<Book>();
	
	public BookList() {
		books = new ArrayList<Book>();
	}
	
	@Override
	public void insert(Book book) {
		books.add(book);
	}
	@Override
	public List<Book> findName(String name) {
		List<Book> list = new ArrayList<Book>();
		for(Book b : books) {
			if(b.getName().contains(name)) {
				list.add(b);
			}
		}
		return list;
	}
	
	
}
