package co.quiz.model;

public class User {
	private int no;
	private String id;
	private String pwd;
	private String nickname;
	private String authority;
	private int count;
	private double scores;
	private double score_avg;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getScores() {
		return scores;
	}
	public void setScores(double scores) {
		this.scores = scores;
	}
	public double getScore_avg() {
		return score_avg;
	}
	public void setScore_avg(double score_avg) {
		this.score_avg = score_avg;
	}
	@Override
	public String toString() {
		return "[id=" + id + ", pwd=" + pwd + ", nickname=" + nickname + ", authority=" + authority + ", count="
				+ count + ", scores=" + scores + ", score_avg=" + score_avg + "]";
	}
	
}
