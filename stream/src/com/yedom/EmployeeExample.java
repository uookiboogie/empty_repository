package com.yedom;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class EmployeeExample {

	public static void main(String[] args) {
		//List<Employee> list = null;
		EmployeeDAO dao = new EmployeeDAO();
		List<Employee> list = dao.getEmployeeList();
		list.stream()
		.filter(t->{return Integer.parseInt(t.getBirthdate().substring(0,4))>1970;})
		.forEach(t-> System.out.println("직무:"+t.getTitle()+" 이름:"+t.getLastname()+" "+t.getFirstname()));
	}

}
