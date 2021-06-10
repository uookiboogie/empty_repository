package exam03;

import java.util.List;
import java.util.Scanner;

public class BookServiceFindAll implements BookService {

	public BookServiceFindAll() {}
	@Override
	public void execute(BookList books) {
		//리스트에서 검색
		List<Book> list = books.findAll(); 
			for(Book l : list) {
			System.out.println(l);
		}
	}

}
