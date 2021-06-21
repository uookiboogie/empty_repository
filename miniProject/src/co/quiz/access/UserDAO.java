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
				user.setScores(rs.getDouble("scores"));
				user.setScore_avg(rs.getDouble("score_avg"));
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
				user.setScores(rs.getDouble("scores"));
				user.setScore_avg(rs.getDouble("score_avg"));
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
				user.setScores(rs.getDouble("scores"));
				user.setScore_avg(rs.getDouble("score_avg"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	@Override
	public List<User> selectRankDesc() {
		List<User> ulist =new ArrayList<>();
		sql= "select*from quiz_user where count>=1 and authority='회원' order by score_avg DESC,count DESC";
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
				user.setScores(rs.getDouble("scores"));
				user.setScore_avg(rs.getDouble("score_avg"));
				ulist.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ulist;
	}
	@Override
	public void scoreReset() {
		sql= "update quiz_user set count=null, scores=null, score_avg=null";
		try {
			psmt=conn.prepareStatement(sql);
			int r= psmt.executeUpdate();
			if(r==1) System.out.println("점수가 초기화 되었어요.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	@Override //퀴즈 점수 db에 저장
	public void scoreUP(User user) {
		sql= "update quiz_user set count=?, scores=?, score_avg=? where id =?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, user.getCount());
			psmt.setDouble(2, user.getScores());
			psmt.setDouble(3, user.getScore_avg());
			psmt.setString(4, user.getId());
			int r= psmt.executeUpdate();
			System.out.println("점수 "+r+"건 반영되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void delete(int no) {
		sql="delete from quiz_user where no = ?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, no);
			int r=psmt.executeUpdate();
			System.out.println(r+"건 회원탈퇴 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
