package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class SqliteConnect {
	//필드로 선언.
	static PreparedStatement psmt;
	static ResultSet rs;
	static Connection conn;
	//1.조회, 2.입력, 3.수정, 4.삭제, 5.전체리스트(각각 기능을 분리)=>메소드로 기능분리.
	
	//전체리스트
	public static ArrayList<Person> getPersonList() {
		ArrayList<Person> personList= new ArrayList<>();
		connect(); //Connection객체 연결
		String sql = "select * from person";
		try {
			psmt = conn.prepareStatement(sql); //PrepareStatment 쿼리를 실행,결과받아.중요해
			rs= psmt.executeQuery();//쿼리실행결과를 가져오는 부분.
			while(rs.next()) {
				//System.out.println(rs.getInt("id")+","+rs.getString(("name")));
				Person person = new Person();
				person.setId(rs.getInt("id"));
				person.setName(rs.getString("name"));
				person.setAge(rs.getInt("age"));
				person.setPhone(rs.getString("phone"));
				personList.add(person);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return personList;
	}
	//한건조회
	public static Person getPerson(int id) {
		connect();
		String sql = "select * from person where id =?";
		Person p = null;
		try {
			psmt=conn.prepareStatement(sql); //PrepareStatment 객체 생성.
			psmt.setInt(1, id);
			rs=psmt.executeQuery();
			if(rs.next()) {
				p= new Person();   //instance를 생성하고 변수 p에 대입.
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setAge(rs.getInt("age"));
				p.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return p;
	}
	//입력기능
	public static void insertPerson(int id, String name, int age, String phone) {
		connect();
		String sql = "insert into Person (id, name, age, phone) values(?,?,?,?)";
		int result = 0;
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, id);
			psmt.setString(2, name);
			psmt.setInt(3, age);
			psmt.setString(4, phone);
			result=psmt.executeUpdate(); //insert, update, delete 할 때 사용.
			System.out.println(result+"건 입력");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	//수정기능
	public static void updatePerson(Person p) {
		connect();
		String sql = "update person set name=?,age=?,phone=? where id=?";
		try {
			psmt= conn.prepareStatement(sql);
			psmt.setString(1, p.getName());
			psmt.setInt(2, p.getAge());
			psmt.setString(3, p.getPhone());
			psmt.setInt(4, p.getId());
			int r = psmt.executeUpdate();
			System.out.println(r+"건 변경되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	//삭제기능
	public static void deletePerson(int id) {
		connect();
		String sql = "delete from Person where id =?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, id);
			if(getPerson(id)!=null) {
			psmt.executeUpdate();}
			else {
				System.out.println("조회된id값이 없습니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
	}
	//이름으로조회
	public static ArrayList<Person> getPersonList(String name) {
		ArrayList<Person> personList= new ArrayList<>();
		connect();
		String sql ="select * from person where name =?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, name);
			rs=psmt.executeQuery();
			
			while(rs.next()) {
				Person person = new Person();
				person.setId(rs.getInt("id"));
				person.setName(rs.getString("name"));
				person.setAge(rs.getInt("age"));
				person.setPhone(rs.getString("phone"));
				personList.add(person);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personList;
	}

	public static void connect() {
//		Connection conn = null;
		String url = "jdbc:sqlite:C:/sqlite/db/sample.db";
		try {
			conn= DriverManager.getConnection(url);
			System.out.println("연결성공!!!");
			
//			PreparedStatement psmt = conn.prepareStatement("select * from person");
//			ResultSet rs =psmt.executeQuery();
//			
//			while(rs.next()) {
//				System.out.printf("id: %3d, name: %4s, age: %2d, phone: %10s",rs.getInt("id"),rs.getString("name"),rs.getInt("age"),rs.getString("phone"));
//				System.out.println();//줄바꿈
//			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
//			finally {
//			if(conn!=null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
	}
	public static void close() {
		if(psmt!=null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		while(true) {
			System.out.println("1:전체리스트 2:입력 3:수정 4:삭제 5:한건조회 6:이름으로조회 0:종료");
			int menu = scn.nextInt();
			
			if      (menu ==1) { 
				//전체리스트 기능.
				System.out.println("<조회 결과>");
				ArrayList<Person> list =getPersonList();
				for(Person person:list) {
					System.out.println(person);}

			}else if(menu ==2) {
				System.out.println("아이디를 입력하세요");
				int searchid = scn.nextInt();
				scn.nextLine();
				System.out.println("이름을 입력하세요");
				String name = scn.nextLine();
				System.out.println("나이를 입력하세요");
				int age = scn.nextInt();
				scn.nextLine();
				System.out.println("전화번호를 입력하세요");
				String phone = scn.nextLine();
				insertPerson(searchid, name, age, phone);
				
			}else if(menu ==3) {//수정
				System.out.println("조회할 아이디를 입력하세요.");
				int searchid = scn.nextInt(); 
				scn.nextLine();//엔터삭제
				Person p = getPerson(searchid); // p -> id, name, age, phone
				if(p==null) {
					System.out.println("존재하지 않는 아이디 입니다.");
					continue;
				}
				System.out.println("변경할 이름:");
				String changeName=scn.nextLine();
				System.out.println("변경할 나이:");
				String changeAge=scn.nextLine();
				System.out.println("변경할 연락처:");
				String changePhone=scn.nextLine();
				if(!changeName.equals("")) {
					p.setName(changeName);
				}
				if(!changeAge.equals("")) {
					p.setAge(Integer.parseInt(changeAge));
				}
				if(!changePhone.equals("")) {
					p.setPhone(changePhone);
				}
				updatePerson(p);
				
			}else if(menu ==4) {
				System.out.println("삭제할 아이디를 입력하세요");
				int searchid = scn.nextInt();
				deletePerson(searchid);

			}else if(menu ==5) {
				//1건조회
				System.out.println("조회할 아이디를 입력하세요");
				int searchid = scn.nextInt();
				Person p = getPerson(searchid);
				if(p== null) {
					System.out.println("조회된 값이 없습니다.");
				}else {
					System.out.println(p);}
			}else if(menu ==6) {
				//이름으로 조회
				scn.nextLine(); //엔터삭제
				System.out.println("조회할 이름을 입력하세요");
				String searchName = scn.nextLine();
				
				//getPersonList(searchName);
				
				ArrayList<Person> list =getPersonList(searchName);
				if (list.size()!=0) {
					for(Person person:list) {
						System.out.println(person);}
				}
				else {
					System.out.println("조회된 이름이 없습니다.");
				}
				
			}
			else if(menu ==0) {
				break;
			}
		} //end of while

		scn.close();
		System.out.println("정상적인 종료");
		
		} //end of main
	} //end of class


