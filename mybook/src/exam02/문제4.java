package exam02;

public class 문제4 {

	public static void main(String[] args) {
		String[] arr = {"010102-2", "991012-1", "960304-1", "881012-2", "040403-1"};
		int man=0;
		int woman=0;
		int a=0; //10대
		int b=0; //20대
		int c=0; //30대
		int d=0; //40대
		
		for (String s : arr) {
			if (s.substring(s.length() - 1).equals("1")) {
				man+=1;
			} else if (s.substring(s.length() - 1).equals("2")) {
				woman+=1;
			}
		}
		for (String s : arr) {
			int x = Integer.parseInt(s.substring(0,2));
			int y = 21-x;
			
		}
		
		System.out.println("남 "+man +" 여 "+woman);
	}

}
