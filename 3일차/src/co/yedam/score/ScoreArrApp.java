package co.yedam.score;

public class ScoreArrApp {
	int[] arr = {90, 90, 50};
	
	void print() {
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	void printH() {
		System.out.printf("%s\n국어:%-6d\t영어:%-6d\t수학:%-6d\n","홍길동성적",arr[0],arr[1],arr[2]);
	}
	
	int total() {
		int result = 0;
		for (int i=0; i<arr.length; i++) {
			result += arr[i];
		}
		return result;
	}
	
	double avg() {
		double result =0;
		result = (double)total() / arr.length;
		return result;
	}
	
}
