package pkg.friend;

public class CompanyFriend extends Friend{
	String duty;
	
	public CompanyFriend() {}
	
	public CompanyFriend(String gunbun, String name, String tel) {
		super(gunbun, name, tel);
	}
	public CompanyFriend(String gunbun, String name, String tel, String duty) {
		super(gunbun, name, tel);
		this.duty = duty;
	}

	@Override
	public void print() {
		//super.print();
		//System.out.println("duty:"+duty);
		System.out.printf("회사친구:%20s %20s %20s %20s\n",gunbun,name,tel,duty);
	}

	@Override
	public String toString() {
		return "CompanyFriend [duty=" + duty + ", gunbun=" + gunbun + ", name=" + name + ", tel=" + tel + "]";
	}


}
