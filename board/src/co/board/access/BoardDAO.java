package co.board.access;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.board.model.Board;

public class BoardDAO extends DAO implements BoardAccess {
	PreparedStatement psmt;
	ResultSet rs;
	String sql;

	@Override
	public List<Board> selectAll() {
		List<Board> blist = new ArrayList<>();
		try {
			sql="select *from board";
			psmt=conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Board board= new Board();
				board.setId(rs.getInt("b_id"));
				board.setTitle(rs.getString("b_title"));
				board.setWriter(rs.getString("b_writer"));
				board.setParentid(rs.getInt("b_parent_id"));
				blist.add(board); //데이터건수만큼 ArrayList담아서 반환
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return blist;
	}
	@Override
	public void insert(Board board) {
		sql="insert into board(b_title, b_content, b_writer) values(?,?,?)";
		int result =0;
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, board.getTitle());
			psmt.setString(2, board.getContent());
			psmt.setString(3, board.getWriter());
			result=psmt.executeUpdate();
			System.out.println(result+"건 입력");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

	@Override
	public void update(Board board) {
		sql="update board set b_content=? where b_id= ?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, board.getContent());
			psmt.setInt(2, board.getId());
			int r = psmt.executeUpdate();
			System.out.println(r+"건 변경되었습니다.");			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		sql="delete from board where b_id = ?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, id);
			psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Board selectOne(int id) {
		sql="select * from Board where b_id =? ";
		Board board=null;
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, id);
			rs=psmt.executeQuery();
			while(rs.next()) {
				board= new Board();
				board.setId(rs.getInt("b_id"));
				board.setTitle(rs.getString("b_title"));
				board.setContent(rs.getString("b_content"));
				board.setWriter(rs.getString("b_writer"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return board;
	}
	@Override
	public void commentInsert(Board board) {
		sql="insert into board(b_title, b_content, b_writer, b_parent_id) values('댓글임',?,?,?)";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, board.getContent());
			psmt.setString(2, board.getWriter());
			psmt.setInt(3, board.getParentid());
			int result=psmt.executeUpdate();
			System.out.println(result+"건 입력");
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<Board> commentlookup(int parentid) {
		sql="select *from board where b_parent_id =?";
		List<Board> blist = new ArrayList<>();
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, parentid);
			rs=psmt.executeQuery();
			while(rs.next()) {
				Board board= new Board();
				board.setId(rs.getInt("b_id"));
				board.setTitle(rs.getString("b_title"));
				board.setWriter(rs.getString("b_writer"));
				board.setParentid(rs.getInt("b_parent_id"));
				blist.add(board);}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return blist;
	}
		
}
