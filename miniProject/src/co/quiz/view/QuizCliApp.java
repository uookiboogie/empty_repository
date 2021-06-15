package co.quiz.view;

import java.util.HashSet;
import java.util.List;

import co.quiz.access.QuizAccess;
import co.quiz.access.QuizDAO;
import co.quiz.access.UserAccess;
import co.quiz.access.UserDAO;
import co.quiz.model.Quiz;
import co.quiz.model.User;
import co.quiz.util.ScanUtil;

public class QuizCliApp {
	QuizAccess quizdao= new QuizDAO();
	UserAccess userdao= new UserDAO();
	User loginuser = new User();
	
	public void menuTitle() {
		System.out.println();
		System.out.println("========QUIZ game========");
		System.out.println("1.회원가입 2.회원조회 3.로그인");
		System.out.println("0.종료");
	}
	public void menuTitle_2() {
		System.out.println();
		System.out.println(loginuser.getNickname()+"님 환영합니다.");
		System.out.println("==========QUIZ game start==========");
		System.out.println("1.랜덤문제 2.순위조회 3.");
		System.out.println("0.로그아웃");
	}
	
	//처음 실행 메뉴
	public void start() {
		int menunum;
		do {
			menuTitle();
			menunum = ScanUtil.readInt("선택");
			switch (menunum) {
			case 1:    signUp();     break;
			case 2:    userInfo();     break;
			case 3:    logIn();     break;
			}
		   }while(menunum!=0);
		    System.out.println("QUIZ GAME 종료");
	}
	private void signUp() {
		User user = new User();
		user.setNo(userdao.selectAll().size()+1);
		String id =ScanUtil.readStr("id 입력");
		while(userdao.selectOne(id)!=null) {
			id =ScanUtil.readStr("id가 중복 됩니다 다시 입력해주세요");
		}
		user.setId(id);
		user.setPwd(ScanUtil.readStr("password 입력"));
		String nickname= ScanUtil.readStr("nickname 입력");
		while(userdao.selectOne2(nickname)!=null) {
			nickname =ScanUtil.readStr("nickname이 중복 됩니다 다시 입력해주세요");
		}
		user.setNickname(nickname);
		user.setAuthority("회원");
		userdao.signUP(user);
	}
	private void userInfo() {
		List<User> ulist=userdao.selectAll(); //db에서 정보를 받아와서, 리스트에 저장
		ulist.stream()
		.forEach(e-> System.out.println("id:"+e.getId()+"  닉네임:"+e.getNickname()+"  등급:"+e.getAuthority()+"  참여횟수:"+e.getCount()+"  평균점수:"+e.getScore_avg()));
	}
	private void logIn() {
		String id =ScanUtil.readStr("로그인 할 id 입력");
		User user=userdao.selectOne(id);
		if(user!=null) {
			String pwd =ScanUtil.readStr("로그인 할 pwd 입력");
			if(pwd.equals(user.getPwd())) {
				System.out.println(user.getNickname()+"님"+" 로그인 되었습니다.");
				this.loginuser=user;
				start_2(); //start2 화면으로 전환
			}else {
				System.out.println("id 또는 password가 올바르지 않습니다.");
			}
		}
		else {
			System.out.println("가입된 id가 없습니다.");
		}
	}
//==============================================================================================================
	//두번째 실행 화면
	public void start_2() {
			int menunum;
			do {
				menuTitle_2();
				menunum = ScanUtil.readInt("선택");
				switch (menunum) {
				case 1:    randomGame();     break;
				case 2:    rankInfo();     break;
				case 3:    l();     break;
				}
			   }while(menunum!=0);
			    System.out.println(loginuser.getNickname()+"님 잘가세요.");
		}
	
		private void randomGame() {
			HashSet<Integer> randomNumbers=new HashSet<>();
			while(randomNumbers.size() < 5) { // 5개의 중복되지 않는 수 뽑기
				randomNumbers.add((int)(Math.random()*(quizdao.selectAll().size())+1));
			}
			for(int number: randomNumbers) {
				Quiz quiz =quizdao.selectOne(number);
				System.out.println(quiz.getQuestion());
				String answer = ScanUtil.readStr("답을 입력하세요");
				
				//if(quiz.getAnswer().equals(answer)) {}
			}
			
		}
		private void rankInfo() {
			// TODO Auto-generated method stub
		}
		private void l() {
			
		}
}
