package co.quiz.model;

public class Quiz {
	private int no;
	private String field;
	private String question;
	private String answer;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "[no=" + no + ", field=" + field + ", question=" + question + ", answer=" + answer + "]";
	}
	
}