package co.quiz.access;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.quiz.model.Quiz;

public class QuizDAO extends DAO implements QuizAccess{
	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	
	@Override
	public void insert(Quiz quiz) {
		sql="insert into quiz(no, field, question, answer) values(?,?,?,?)";
		int result =0;
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, quiz.getNo());
			psmt.setString(2, quiz.getField());
			psmt.setString(3, quiz.getQuestion());
			psmt.setString(4, quiz.getAnswer());
			result=psmt.executeUpdate();
			System.out.println(result+"건 문제입력 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Quiz> selectAll() {
		List<Quiz> qlist =new ArrayList<>();
		sql="select *from quiz";
		try {
			psmt=conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Quiz quiz = new Quiz();
				quiz.setNo(rs.getInt("no"));
				quiz.setField(rs.getString("field"));
				quiz.setQuestion(rs.getString("question"));
				quiz.setAnswer(rs.getString("answer"));
				qlist.add(quiz);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qlist;		
	}
	
	//번호로 문제 뽑기
	@Override
	public Quiz selectOne(int no) {
		sql="select * from quiz where no = ?";
		Quiz quiz = null;
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, no);
			rs = psmt.executeQuery();
			while(rs.next()) {
				quiz = new Quiz();
				quiz.setNo(rs.getInt("no"));
				quiz.setField(rs.getString("field"));
				quiz.setQuestion(rs.getString("question"));
				quiz.setAnswer(rs.getString("answer"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return quiz;
	}
	
	
}
	