package co.quiz.access;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.quiz.model.User;

public class UserDAO extends DAO implements UserAccess{
	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	
	@Override
	public void signUP(User user) {
		sql="select *from quiz_user";
		try {
			psmt=conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
