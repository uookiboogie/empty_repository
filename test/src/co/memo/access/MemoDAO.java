package co.memo.access;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.memo.model.Memo;

// MemoAccess를 구현하는 클래스입니다.
// 기능을 작성하세요.
public class MemoDAO extends DAO implements MemoAccess{
	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	
	@Override
	public void write(String date, String title, String content) {
		sql="insert into memo(date, title, content) values(?,?,?)";
		int result =0;
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, date);
			psmt.setString(2, title);
			psmt.setString(3, content);
			result=psmt.executeUpdate();
			System.out.println(result+"건 입력");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Memo memo) {
		sql="update memo set content=? where date= ?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, memo.getContent());
			psmt.setString(2, memo.getDate());
			int r = psmt.executeUpdate();
			System.out.println(r+"건 변경되었습니다.");		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String date) {
		sql="delete from memo where date = ?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, date);
			int result=psmt.executeUpdate();
			System.out.println(result+"건 삭제");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Memo> FindAll() {
		List<Memo> mlist = new ArrayList<>();
		sql="select * from Memo";
		try {
			psmt=conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
			    Memo memo = new Memo();
			    memo.setDate(rs.getString("date"));
			    memo.setTitle(rs.getString("title"));
			    memo.setContent(rs.getString("content"));
			    mlist.add(memo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mlist;
	}

	@Override
	public Memo FindByDate(String date) {
		sql="select * from memo where date =? ";
		Memo memo= null;
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, date);
			rs=psmt.executeQuery();
			while(rs.next()) {
				memo= new Memo();
				memo.setDate(rs.getString("date"));
			    memo.setTitle(rs.getString("title"));
			    memo.setContent(rs.getString("content"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}return memo;
	}

	@Override
	public Memo FindByContent(String content) {
		sql="select * from memo where content =? ";
		Memo memo= null;
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, content);
			rs=psmt.executeQuery();
			while(rs.next()) {
				memo= new Memo();
				memo.setDate(rs.getString("date"));
			    memo.setTitle(rs.getString("title"));
			    memo.setContent(rs.getString("content"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}return memo;
	}
}
