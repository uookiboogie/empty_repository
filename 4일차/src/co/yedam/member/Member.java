package co.yedam.member;

public class Member {
	String name;
	String id;
	String password;
	int age;
	//기본생성자
	Member(){}
	//모든 필드를 초기화하는 생성자
	public Member(String name, String id, String password, int age) {
		super();
		this.name = name;
		this.id = id;
		this.password = password;
		this.age = age;
	}
	@Override
	public String toString() {
		return name+"\t"+id+"\t"+password+"\t"+ age ;
	}
	
}
