package co.yedam.member;

import java.util.Scanner;

public class MemberService {
	Member[] members = new Member[10];
	int cnt = 0;
	Scanner scanner = new Scanner(System.in);

	// 회원가입
//	void insert(String id, String password, String name, int age) {
//		members[cnt]= new Member(id, password, name, age);
//		cnt++;
//	}
	void insert() {
		System.out.print("id>");
		String id = scanner.next();
		System.out.print("password>");
		String password = scanner.next();
		System.out.print("name>");
		String name = scanner.next();
		System.out.print("age>");
		int age = scanner.nextInt();
		members[cnt] = new Member(name, id, password, age);
		cnt++;
	}

	// 회원리스트
	void printList() {
		for (int i = 0; i < cnt; i++) {
			System.out.println(members[i]);
		}
	}

	void printMember(int i) {
		System.out.println(members[i].id);
		System.out.println(members[i].name);
		System.out.println(members[i].age);
	}

	boolean login(String id, String password) {
		boolean result = false;
		for (int i = 0; i < cnt; i++) {
			if (id.equals(members[i].id) && password.equals(members[i].password)) {
				result = true;
				System.out.println("로그인되었습니다.");
				break;
			}
		}
		if (result==false) {
			System.out.println("id 또는 패스워드 틀림");
		}
		return result;
//		if (id.equals("hong") & password.equals("12345")){
//			return true;}
//		else {
//		return false;}
	}

	void logout(String id) {
		System.out.println("로그아웃 되었습니다.");
	}
//if(id.equals("hong"))
}
