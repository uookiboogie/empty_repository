package pkg.friend;

public class SchoolFriend extends Friend{
	String birth;
	
	public SchoolFriend() {}
	
	public SchoolFriend(String gunbun, String name, String tel) {
		super(gunbun, name, tel);
	}
	public SchoolFriend(String gunbun, String name, String tel, String birth) {
		super(gunbun, name, tel);
		this.birth = birth;
	}

	@Override
	public void print() {
		//super.print();
		//System.out.println("birth:"+birth);
		System.out.printf("학교친구:%20s %20s %20s %20s\n",gunbun,name,tel,birth);
	}




}
