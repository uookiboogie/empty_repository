package co.quiz.access;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.quiz.model.User;

public class UserDAO extends DAO implements UserAccess{
	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	
	@Override //회원가입
	public void signUP(User user) {
		sql="insert into quiz_user(no, id, password, nickname, authority) values(?,?,?,?,?)";
		int result =0;
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, user.getNo());
			psmt.setString(2, user.getId());
			psmt.setString(3, user.getPwd());
			psmt.setString(4, user.getNickname());
			psmt.setString(5, user.getAuthority());
			result=psmt.executeUpdate();
			System.out.println(result+"건 회원가입 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override //회원전체조회
	public List<User> selectAll() {
		List<User> ulist =new ArrayList<>();
		sql="select *from quiz_user";
		try {
			psmt=conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setNo(rs.getInt("no"));
				user.setId(rs.getString("id"));
				user.setPwd(rs.getString("password"));
				user.setNickname(rs.getString("nickname"));
				user.setAuthority(rs.getString("authority"));
				user.setCount(rs.getInt("count"));
				user.setScore_avg(rs.getInt("score_avg"));
				ulist.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return ulist;
	}
	@Override
	public User selectOne(String id) {
		sql="select * from quiz_user where id = ?";
		User user =null;
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			while(rs.next()) {
				user = new User();
				user.setNo(rs.getInt("no"));
				user.setId(rs.getString("id"));
				user.setPwd(rs.getString("password"));
				user.setNickname(rs.getString("nickname"));
				user.setAuthority(rs.getString("authority"));
				user.setCount(rs.getInt("count"));
				user.setScore_avg(rs.getInt("score_avg"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	@Override
	public User selectOne2(String nickname) {
		sql="select * from quiz_user where nickname = ?";
		User user =null;
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, nickname);
			rs = psmt.executeQuery();
			while(rs.next()) {
				user = new User();
				user.setNo(rs.getInt("no"));
				user.setId(rs.getString("id"));
				user.setPwd(rs.getString("password"));
				user.setNickname(rs.getString("nickname"));
				user.setAuthority(rs.getString("authority"));
				user.setCount(rs.getInt("count"));
				user.setScore_avg(rs.getInt("score_avg"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	@Override //퀴즈 점수 db에 저장
	public void scoreUP(int count, int score_avg) {
		sql= "update quiz_user set count=? and set score_avg where id=?";
	}
}
