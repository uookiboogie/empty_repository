package 클래스;

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
	
	@Override
	public boolean equals(Object obj) {
		
		Member s = (Member)obj;
		return this.id.equals(s.id) && this.name.equals(s.name);
		
//		Member id =((Member)obj);
//		Member name =((Member)obj);
//		
//		return (((Member)obj).id).equals(this.id) && ((Member)obj).name.equals(this.name);
	}
	
}
