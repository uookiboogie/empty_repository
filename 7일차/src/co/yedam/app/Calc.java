package co.yedam.app;

public class Calc {
	int a;
	int b;
	
	public static int add(int a, int b) {
		return a+b;
	}
	public static int div(int a, int b) throws Exception {
		int c =0;
		c=a/b;
//		try{
//			c=a/b;
//		}catch(Exception e) {
//			c=a;
//		}
		return c;
	}
}
