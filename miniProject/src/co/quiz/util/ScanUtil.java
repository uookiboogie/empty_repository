package co.quiz.util;

import java.util.Scanner;

public class ScanUtil {
	static Scanner scanner = new Scanner(System.in);
	
	   //정수 입력
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
					scanner.nextLine();//엔터 삭제
					break;
				}catch (Exception e) {
					System.out.println("숫자 형식이 아닙니다.");
				}
			}
			return result;
		}
		//한줄 입력
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
		
		//문제 입력 (여러줄 입력) 엔터를 수정 해보자!!
		public static String readQuestion() {
			String result = "";
			System.out.println("문제를 입력하시고 완료후 .esc입력하세요");
			while (true) {
				String line = scanner.nextLine();
				if (line.equals(".esc")) break;
				result+=line+"\n";
			}
			return result;
		}
	
}