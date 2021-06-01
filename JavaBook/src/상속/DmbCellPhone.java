package 상속;

public class DmbCellPhone extends CellPhone {
	int channel;
	public DmbCellPhone() {
		super();
		System.out.println("DmbCellPhone 기본생성자");
	}
	public DmbCellPhone(String model, String color, int channel) {
		super(model, color);
		this.channel = channel;
		System.out.println("DmbCellPhone 생성자");
	}
	void turnOndmb() {
		System.out.println("채널"+ channel +"번 DMB 방송수신 시작.");
	}
	void turnOffdmb() {
		System.out.println("DMB 방송수신을 멈춥니다.");
	}
	void changeChannel(int channel) {
		this.channel = channel;
		System.out.println("채널"+channel+"번으로 바꿉니다.");
	}
	@Override //재정의 //상속받은 메서드를 수정
	          //cf)오버로딩(중복정의)
	void powerOn() {
		//super.powerOn();
		System.out.println("Dmb 전원 on");
	}
	
}
