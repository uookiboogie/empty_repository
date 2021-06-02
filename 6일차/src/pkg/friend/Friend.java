package pkg.friend;

public class Friend {
	protected String gunbun;//protected 패키지 바껴도 상속관계만 ㄱㄱ
	protected String name;
	protected String tel;
	
	public Friend() {}
	public Friend(String gunbun, String name, String tel) {
		super();
		this.gunbun = gunbun;
		this.name = name;
		this.tel = tel;
	}
	public void print() {
		System.out.printf("친구:%20s %20s %20s\n",gunbun,name,tel);
	}
	
	public String getGunbun() {
		return gunbun;
	}
	public void setGunbun(String gunbun) {
		this.gunbun = gunbun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@Override
	public String toString() {
		return "Friend [gunbun=" + gunbun + ", name=" + name + ", tel=" + tel + "]";
	}
	
}
