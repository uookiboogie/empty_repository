package co.friend.common;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import co.friend.access.FriendDAO;

public class CollectionEx4 {

	public static void main(String[] args) {
		//이름,연락처 출력하세요.
		FriendDAO dao = new FriendDAO();
		Map<String, String> info=dao.getNameTel();
		
		Set<Entry<String, String>> ent = info.entrySet();
		Iterator<Entry<String, String>> eiter =ent.iterator();
		while(eiter.hasNext()) {
			Entry<String, String> e = eiter.next();
			System.out.println(e.getKey()+", "+e.getValue());
		}
		
	}

}
