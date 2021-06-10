package 문제3;

public class ex03 {
	public static void main(String[] args) {
		String[] arr = {"bb.jpg","area.txt","moomin.jpeg","work.txt","you.JPG"};
		int count=0;
		System.out.println("<<실행결과>>");
		for(String s: arr) {
			String a = s.substring(s.lastIndexOf(".")+1);
			if (a.equals("jpg")||a.equals("jpeg")||a.equals("JPG")) {
				System.out.println(s);
				count+=1;
			} 
		}
		System.out.println("이미지파일 수 : "+count);
		
	}
}
