package co.friend.access;
//FriendAccess.java, FriendList.java

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import co.friend.Util.DAO;
import co.friend.model.Friend;

public class FriendDAO extends DAO implements FriendAccess{
	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	
	public Map<String, String> getNameTel(){ //name, tel 값을 담아주는 컬렉션.
		Map<String, String> info = new HashMap<>();
		try {
			sql="select *from friend";
			psmt=conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				info.put(rs.getString("name"),rs.getString("tel"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return info;
	}
	
	@Override
	public void insert(Friend friend) {//입력쿼리 만들고 executeUpdate()메소드 호출해서 한건 입력완성해보세요.
		sql="insert into friend (gubun, name, tel) values(?,?,?)";
		int result = 0;
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, friend.getGubun());
			psmt.setString(2, friend.getName());
			psmt.setString(3, friend.getTel());
			result=psmt.executeUpdate(); //insert, update, delete 할 때 사용.
			System.out.println(result+"건 입력");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Friend friend) {
		sql = "update friend set tel=? where name=?";
		//구분, 이름, 전화
		//동일한 이름은 없다는 전제
		//where name=?
		try {
			psmt= conn.prepareStatement(sql);
			psmt.setString(1, friend.getTel());
			psmt.setString(2, friend.getName());
			int r = psmt.executeUpdate();
			System.out.println(r+"건 변경되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String name) {
		sql = "delete from friend where name =?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, name);
			if(selectOne(name)!=null ) {
				psmt.executeUpdate();}
			else {
				 System.out.println("조회된 이름이 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Friend> selectAll() {
		ArrayList<Friend> fList = new ArrayList<>();
		try {
			sql="select *from friend";
			psmt=conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Friend friend= new Friend();
				friend.setGubun(rs.getString("gubun"));
				friend.setName(rs.getString("name"));
				friend.setTel(rs.getString("tel"));
				fList.add(friend); //데이터건수만큼 ArrayList담아서 반환
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fList;
	}

	@Override
	public Friend selectOne(String name) {
		sql ="select * from friend where name =?";
		Friend friend=null;
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, name);
			rs=psmt.executeQuery();
			while(rs.next()) {
				friend = new Friend();
				friend.setGubun(rs.getString("gubun"));
				friend.setName(rs.getString("name"));
				friend.setTel(rs.getString("tel"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return friend;
	}

	@Override
	public Friend findTel(String tel) {
		sql ="select * from friend where tel =?";
		Friend friend=null;
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, tel);
			rs=psmt.executeQuery();
			while(rs.next()) {
				friend = new Friend();
				friend.setGubun(rs.getString("gubun"));
				friend.setName(rs.getString("name"));
				friend.setTel(rs.getString("tel"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return friend;
	}

}
