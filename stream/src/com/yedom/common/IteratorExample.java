package com.yedom.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.yedom.Person;
import com.yedom.PersonDAO;

public class IteratorExample {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Hong", "Park" ,"Choi");
		Iterator<String> iter =list.iterator(); //반복된 요소를 지정 사용하기 위해서 반복자 선언
		while(iter.hasNext()) {
			String val= iter.next();
			System.out.println(val.toUpperCase().length());
		}
		//stream 사용
		System.out.println("<stream 실습>");
		Stream<String> stream = list.stream();
		stream.forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}			
		});
		System.out.println("<person list>");
		//sample 요소를 database에서 갖고 오도록 한다.
		PersonDAO dao=new PersonDAO();
		ArrayList<Person> persons = dao.getPersonList();
		Stream<Person> pStream = persons.stream();
		long cnt = pStream
		.filter(new Predicate<Person>() {
			@Override
			public boolean test(Person t) {
			    return t.getAge()>30; //return 값이 true인 요소만 통과
			}})
		.filter((t)-> {return t.getName().startsWith("김");}) //return 값이 true인 요소만 통과		
		//.forEach((t) ->  System.out.println(t.toString()));
		.count();
		System.out.println("최종처리 건수:"+cnt);

//		pStream.forEach((t) ->  System.out.println(t.toString())); //밑에꺼 줄인거
		
//		pStream.forEach(new Consumer<Person>() {
//			@Override
//			public void accept(Person t) {
//				System.out.println(t.toString());
//			}	
//		});
		
		
	}	
}
