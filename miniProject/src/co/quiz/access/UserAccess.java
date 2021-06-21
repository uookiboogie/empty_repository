package co.quiz.access;

import java.util.List;

import co.quiz.model.User;

//유저 개발 표준
public interface UserAccess {
	
	public void signUP(User user); //db에 회원 저장
	
	public List<User> selectAll(); //db에서 회원 전체 리스트 가져오기
	
	public User selectOne(String id); //db에서 아이디 맞는 사람 한 정보 가져오기
	
	public User selectOne2(String nickname); //db에서 아이디 맞는 사람 한 정보 가져오기
	
	public List<User> selectRankDesc(); //퀴즈게임 n번이상 참가자 내림차순 정렬 후 가져오기
	
	public void scoreReset(); // 모든 회원 점수 초기화 하기.
	
	//public User update(String id); //db에서 id 맞는 사람 회원 비밀번호 닉네임 수정.
	
	public void scoreUP(User user); //퀴즈 푼 뒤 점수 입력
	
	public void delete(int no); //db에서 no 넣고 user 삭제하기
}