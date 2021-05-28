package co.yedam.star;
/*
 *  별찍기
 */
public class StarApp {
	
	//직각삼각형 출력
	void draw(int cnt){
		for(int i=1; i<=cnt ;i++) {
			System.out.println(pad('#',i));
		 }
     }
	//역삼각형
	void drawInvert(int cnt) {
		for(int i=1; i<=cnt ;i++) {
			System.out.println(pad('#',cnt+1-i));
      	}
	}
	//이등변삼각형
	void drawEq(int cnt) {
		for(int i=1; i<=cnt ;i++) {
			System.out.print(pad(' ',cnt+1-i));//공백
			System.out.println(pad('#',i*2-1));
      	}

	}
	//이등변역삼각형
	void drawEqq(int cnt) {
		for(int i=1; i<=cnt ;i++) {
			System.out.print(pad('#',cnt+1-i));
			System.out.println(pad(' ',i*2-1));
		}
	}
	//나무그리기
	
	
	//"*"*3
	//(*,10) ---> "**********"
	String pad(char s, int cnt) {
		String result = "";
		for(int i=0; i<cnt ;i++) {
			result+=s;
      	}
		return result;
    }
}