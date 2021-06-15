package co.quiz.access;

import java.util.List;

import co.quiz.model.Quiz;
import co.quiz.model.User;

public interface QuizAccess {
	//퀴즈 입력하기
	public void insert(Quiz quiz); //db에 퀴즈 입력하기
	
	public List<Quiz> selectAll(); //db에서 퀴즈 전체 리스트로 불러 오기
	
	public Quiz selectOne(int index); //db에서 랜덤으로 문제 중 뽑아오기
	
}