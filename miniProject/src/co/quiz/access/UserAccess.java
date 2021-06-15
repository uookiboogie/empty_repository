package co.quiz.access;

import java.util.List;

import co.quiz.model.User;

//유저 개발 표준
public interface UserAccess {
	
	public void signUP(User user); //db에 회원 저장
	
	public List<User> selectAll(); //db에서 회원 전체 리스트 가져오기
	
	public User selectOne(String id); //db에서 아이디 맞는 사람 한 정보 가져오기
	
	public User selectOne2(String nickname); //db에서 아이디 맞는 사람 한 정보 가져오기
	
	//public User update(String id); //db에서 id 맞는 사람 정보 업데이트
	
	//아이디, 닉네임 조회
	
	//퀴즈 점수 입력
	public void scoreUP(int count, int score_avg);
}