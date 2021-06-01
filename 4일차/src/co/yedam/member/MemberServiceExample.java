package co.yedam.member;

import java.util.Scanner;

public class MemberServiceExample {
	public static void main(String[] args) {
		MemberService memberservice = new MemberService();
		boolean run = true;
		Scanner scanner = new Scanner(System.in);
		int selectNo =0;
		while(run) {
			System.out.println("1.등록 2.전체조회 3.번호로조회 4.로그인 5.ID로조회 6.종료");
			System.out.print("선택>");
			selectNo = scanner.nextInt();
			if(selectNo==1) {
				memberservice.insert();}
			else if(selectNo==2) {
				memberservice.printList();}
			else if(selectNo==3) {
				System.out.print("번호입력>");
				int i = scanner.nextInt();
				memberservice.printMember(i);}
			else if(selectNo==4) {
				System.out.print("id>");
				String id = scanner.next();
				System.out.print("password>");
				String password =scanner.next();
				memberservice.login(id, password);}
			else if(selectNo==5) {
				System.out.print("id>");
				String id = scanner.next();
				memberservice.login(id);}
			else if(selectNo==6) {
				run= false;}
		}
		System.out.println("끝");
		}

//	public static void main(String[] args) {
//		MemberService memberService= new MemberService();
//		memberService.insert("hong", "12345", "홍길동", 23);
//		memberService.insert("kim", "1111", "김유신", 22);
//		memberService.insert("choi", "2222", "최기자", 21);
//		//
//		memberService.printList();
//		
//		memberService.printMember(1);
//		
//		System.out.println(memberService.login("kim", "1111"));
//		System.out.println(memberService.login("kim", "1234"));
		
//		MemberService memberService = new MemberService();
//		boolean result = memberService.login("hong", "12345");
//				if(result) {
//					System.out.println("로그인 되었습니다.");
//					memberService.logout("hong");
//				}else {
//					System.out.println("id 또는 password가 올바르지 않습니다.");
//				}
	}

