package 클래스;

public class CalcStatic {
	//fianl: (상수) 변경불가, 상수는 보통 대문자로 한다
	//static: 모든 객체가 공유하는 필드
	final static double PI = 3.14;

	@Override
	public String toString() {
		return "CalcStatic [pi=" + PI + "]";
	}
	
	public static int add(int innum1, int innum2) {
		return innum1+innum2;
	}

}