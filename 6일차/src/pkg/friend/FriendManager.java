package pkg.friend;

import java.util.List;

public class FriendManager implements FriendAccess{
	Friend[] friends = new Friend[5];
	
	public FriendManager() {
		friends[0] = new CompanyFriend("현대","순이","010-2222-4444");
		friends[1] = new CompanyFriend("삼성","돌이","010-2222-4444");
		friends[2] = new SchoolFriend("다사초","철수","010-2222-4444");
		friends[3] = new SchoolFriend("죽곡초","영희","010-2222-4444");
		friends[4] = new SchoolFriend("왕선초","순이","010-2222-4444");
	}

	@Override
	public void insert(Friend friend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Friend friend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Friend friend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List selectAll() {
		System.out.println("FriendManager");
		return null;
	}

	@Override
	public Friend selectOne(Object key) {
		// TODO Auto-generated method stub
		return null;
	}
		
	
}
