package 상속;

public class DmbCellPhoneTest {

	public static void main(String[] args) {
		
		DmbCellPhone Phone = new DmbCellPhone();
		
		DmbCellPhone dmbCellPhone = new DmbCellPhone("삼성","검정", 10);
		
		System.out.println(dmbCellPhone.model+":"+dmbCellPhone.color);
		dmbCellPhone.powerOn();
		dmbCellPhone.bell();
		dmbCellPhone.turnOndmb();
		dmbCellPhone.changeChannel(20);
		dmbCellPhone.turnOffdmb();
		dmbCellPhone.powerOff();
	}

}
