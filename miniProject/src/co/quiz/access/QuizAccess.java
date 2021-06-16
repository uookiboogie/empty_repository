package co.quiz.access;

import java.util.List;

import co.quiz.model.Quiz;
import co.quiz.model.User;

public interface QuizAccess {
	//퀴즈 입력하기
	public void insert(Quiz quiz); //db에 퀴즈 입력하기
	
	public List<Quiz> selectAll(); //db에서 퀴즈 전체 리스트로 불러 오기
	
	public Quiz selectOne(int no); //db에서 랜덤으로 문제 중 가져 오기
	
	public void delete(int no); //db에서 no 넣고 문제 삭제하기
	
}