package base.제어문;

import java.util.Scanner;

public class WhileTest2 {

	public static void main(String[] args) {
		int a = 0;
		Scanner scanner = new Scanner(System.in);

		while (a != 0) {
			a = scanner.nextInt();
			System.out.println(a);
		}
		System.out.println("end");

		do {
			a = scanner.nextInt();
			System.out.println(a);
		} while (a != 0);
		System.out.println("end");
	}

}
