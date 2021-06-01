package 배열;

import java.awt.Point;

/*
 * 객체배열 : 배열의 요소 타입이 객체인 경우
 */
public class 객체배열 {
	public static void main(String[] args) {
		// 변수 선언
		Score[] a;
		a = new Score[10];
		a[0] = new Score("이순신", 100, 90, 70);
		a[1] = new Score("홍길동", 90, 90, 70);
		a[2] = new Score("김철수", 60, 90, 100);

		// 이름만 출력
		for (int i = 0; i < a.length; i++) {
			if (a[i] != null) {
				System.out.println(a[i].name);
			}
		}
		// 선언과 동시에 초기화
		Score[] b = { new Score("이순신", 100, 90, 70), new Score("홍길동", 90, 90, 70), new Score("김철수", 60, 90, 100) };
		// 이름과 총점을 출력
		// in 배열변수 확정for문
		for (Score score : b) {
			System.out.println(score.name + ":" + score.total);}
//		for (int i = 0; i < b.length; i++) {
//		    System.out.println(b[i].name + ":" + b[i].total);}

		// 객체배열
		Point[] c = { new Point(10, 10), new Point(30, 10), new Point(10, 30), new Point(30, 30)};
		//확장 for문을 이용하여 x,y좌표를 출력
		for (Point point : c) {
			System.out.println(point.x+","+point.y);
		}
	}
}
