package co.yedam.emp;

public class EmployExample {

	public static void main(String[] args) {
		Employee emp0 = new Employee();
		System.out.println(emp0.toString());
		
		//사번: 100 이름:홍길동 초기화
		Employee emp1 = new Employee(100, "홍길동");
		System.out.println(emp1.toString());
		
		//사번:101 이름:김유신 이메일:a@a.c 초기화
		Employee emp2 = new Employee(101, "김유신", "a@a.c");
		System.out.println(emp2);
		//사번:102 이름 유관순 급여 2500 초기화
		Employee emp3 = new Employee(102, "유관순", 2500);
		System.out.println(emp3);
		//모든 필드를 초기화
		Employee emp4 = new Employee(103, "박준욱", 20, 5000, "uook00@naver.com");
		System.out.println(emp4);
	}

}
