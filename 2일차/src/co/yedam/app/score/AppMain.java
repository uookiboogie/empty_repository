package co.yedam.app.score;

public class AppMain {

	public static void main(String[] args) {
		ScoreApp score = new ScoreApp();
		
		score.input();
		
		System.out.println(
			//	"합계 " + score.getSum()+ " : " +
			//	"평균 " + score.getAvg()+ " : " +
				"등급 " + score.getGrade()+ " : "
				);
		
		System.out.println("합격여부 : "
				+ (score.isPass()? "합격":"불합격"));

	}

}
