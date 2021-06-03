package co.yedam.app;

public class Add {

	public static void main(String[] args) {
		String date1 = null;
		String date2 = null;

		try {
			date1 = args[0];
			date2 = args[1];

			int value1 = Integer.parseInt(date1);
			int value2 = Integer.parseInt(date2);
			
			System.out.println(value1 / value2);

		} catch (NumberFormatException e) {
			System.out.println("숫자를 입력해");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("숫자를 2개 입력해");			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
