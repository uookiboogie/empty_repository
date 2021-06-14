package co.quiz.model;
/*
 * 회원가입
 * 로그인
 * 로그아웃
 */
public class User {
	private String id;
	private String pwd;
	private String nickname;
	private String authority;
	private int count;
	private int score_avg;
	
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
	public int getScore_avg() {
		return score_avg;
	}
	public void setScore_avg(int score_avg) {
		this.score_avg = score_avg;
	}
	
}
