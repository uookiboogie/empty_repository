package pkg.friend;

import java.util.ArrayList;
import java.util.List;

public class FriendList implements FriendAccess{
	List<Friend> friends;
	
	public FriendList() {
		friends = new ArrayList<Friend>();
	}

	@Override
	public void insert(Friend friend) {
		friends.add(friend);
	}

	@Override
	public void update(Friend name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String friend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectAll() {
		System.out.println("FriendList");

	}

	@Override
	public Friend selectOne(String name) {
		for(Friend f : friends) {
			if(f.getName().equals(name)) {//contains
				return f;
			}
		}
		return null;
	}

}
	
