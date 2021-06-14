package co.board.Util;

import java.util.Scanner;

import co.board.model.Board;

public class ScannerUtil {
	static Scanner scanner = new Scanner(System.in);
	
	//인덱스 검색
	public static int readInt(String prompt) {
		System.out.print(prompt+">");
		return readInt();
	}
	public static int readInt() {
		int result =0;
		while(true) {
			try {
				String temp = scanner.next();
				result = Integer.parseInt(temp);
				scanner.nextLine();//엔터삭제
				break;
			}catch (Exception e) {
				System.out.println("숫자 형식이 아닙니다.");
			}
		}
		return result;
	}
	//한줄입력
	public static String readStr(String prompt) {
		System.out.print(prompt+">");
		return readStr();
	}
	
	public static String readStr() {
		String result = "";
		try {
			result = scanner.nextLine();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public static Board readBoard() {
		Board board = new Board();
		
		System.out.print("제목>");
		String result1 = scanner.nextLine();
		System.out.print("내용>");
		String result2 = scanner.nextLine();
		System.out.print("작성자>");
		String result3 = scanner.nextLine();
		board.setTitle(result1);
		board.setContent(result2);
		board.setWriter(result3);
		return board;
	}
	
}
