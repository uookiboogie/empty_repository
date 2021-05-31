package co.yedam.exam;

public class ExamScoreExample {

	public static void main(String[] args) {
		ExamScore examScore=new ExamScore("2021.05.31", 50, 100 ,100);
		System.out.println(examScore.isPass()?"합격":"불합격");
		
//		if(examScore.isPass()==true) {
//			System.out.println("합격");
//		}else {
//			System.out.println("불합격");
//		}

	}

}
