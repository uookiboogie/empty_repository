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
	QuizAccess quizdao = new QuizDAO();
	UserAccess userdao = new UserDAO();
	User loginuser = new User();

	public void menuTitle() {
		System.out.println();
		System.out.println("=============QUIZ game=============\n");
		System.out.println("|[1]회원가입 [2]회원조회 [3]로그인|\n");
		System.out.println("|[0]종료===========================");
	}

	public void menuTitle_2() {
		System.out.println();
		System.out.println("------------------------------> " + loginuser.getNickname() + "님 환영합니다.");
		System.out.println("=====================QUIZ game start===================\n");
		System.out.println("|[1]퀴즈시작(랜덤문제) [2]나의정보보기 [3]전체랭킹보기|");
		System.out.println("|[4]회원탈퇴하기                                      |\n");
		System.out.println("|[0]로그아웃===========================================");
	}

	public void menuTitle_3() {
		System.out.println();
		System.out.println("------------------------------> " + loginuser.getNickname() + "님 환영합니다.");
		System.out.println("=====================QUIZ game start===================\n");
		System.out.println("|[1]퀴즈추가 [2]퀴즈전체조회 [3]퀴즈삭제              |");
		System.out.println("|[4]회원점수초기화                                    |\n");
		System.out.println("|[0]로그아웃===========================================");
	}

	// 처음 실행 메뉴
	public void start() {
		int menunum;
		do {
			menuTitle();
			menunum = ScanUtil.readInt("선택");
			switch (menunum) {
			case 1: signUp();      break;
			case 2: userInfo();    break;
			case 3: logIn();       break;
			}
		} while (menunum != 0);
		System.out.println("QUIZ GAME 종료");
	}

	private void signUp() {
		User user = new User();
		user.setNo(userdao.selectAll().size() + 1);
		String id = ScanUtil.readStr("id 입력");
		while (userdao.selectOne(id) != null) {
			id = ScanUtil.readStr("id가 중복 됩니다 다시 입력해주세요");
		}
		user.setId(id);
		user.setPwd(ScanUtil.readStr("password 입력"));
		String nickname = ScanUtil.readStr("nickname 입력");
		while (userdao.selectOne2(nickname) != null) {
			nickname = ScanUtil.readStr("nickname이 중복 됩니다 다시 입력해주세요");
		}
		user.setNickname(nickname);
		user.setAuthority("회원");
		userdao.signUP(user);
	}

	private void userInfo() {
		List<User> ulist = userdao.selectAll(); // db에서 정보를 받아와서, 리스트에 저장
		ulist.stream().filter(t -> t.getAuthority().equals("회원"))
				.forEach(e -> System.out.println("id:" + e.getId() + "  닉네임:" + e.getNickname() + "  등급:"
						+ e.getAuthority() + "  퀴즈참여횟수:" + e.getCount()/* +"  평균점수:"+e.getScore_avg() */));
	}

	private void logIn() {
		String id = ScanUtil.readStr("로그인 할 id 입력");
		User user = userdao.selectOne(id);
		if (user != null) {
			String pwd = ScanUtil.readStr("로그인 할 pwd 입력");
			if (pwd.equals(user.getPwd())) {
				System.out.println("-------------------> " + user.getNickname() + "님" + " 로그인 되었습니다.");
				this.loginuser = user;
				if (!user.getAuthority().equals("운영자")) {
					start_2();
				} else {
					start_3();
				}
			} else {
				System.out.println("password가 올바르지 않습니다.");
			}
		} else {
			System.out.println("미가입된 id가 입니다.");
		}
	}

//==============================================================================================================
	// 두번째 실행 화면
	public void start_2() {
		int menunum;
		do {
			menuTitle_2();
			menunum = ScanUtil.readInt("선택");
			switch (menunum) {
			case 1: randomGame(); break;
			case 2: myInfo(); break;
			case 3: rankInfo(); break;
			}
		} while (menunum != 0);
		System.out.println(loginuser.getNickname() + "님 잘가세요.");
	}

	private void randomGame() {
		double score = 0;

		HashSet<Integer> randomNumbers = new HashSet<>();
		while (randomNumbers.size() < 5) { // 5개의 중복되지 않는 수 뽑기
			randomNumbers.add((int) (Math.random() * (quizdao.selectAll().size()) + 1));
		}
		System.out.println("5문제 나감요~, 맞추면 20점 틀리면 -10점, 문제 스타뜨으~");
		for (int number : randomNumbers) { // 5문제 출제, 정답 오답 처리. 점수 카운트 해
			Quiz quiz = quizdao.selectOne(number);
			System.out.println(quiz.getQuestion());
			String answer = ScanUtil.readStr("답을 입력하세요");
			if (quiz.getAnswer().equals(answer)) {
				score += 20;
				System.out.println("정답입니다 +20점");
			} else {
				score -= 10;
				System.out.println("틀렸지롱 -10점");
				System.out.println("답은 " + quiz.getAnswer() + " 입니다.");
			}
		}
		User user = userdao.selectOne(loginuser.getId()); // 카운트,점수 업데이트
		double avg = (user.getScores() + score) / (user.getCount() + 1);
		user.setCount(user.getCount() + 1);
		user.setScores(user.getScores() + score);
		user.setScore_avg(avg);
		userdao.scoreUP(user);
	}

	private void myInfo() {
		User user = userdao.selectOne(loginuser.getId());
		System.out.println(user);
	}

	private void rankInfo() {
		List<User> ulist = userdao.selectRankDesc();
		int rankNum = 1;
		if (ulist.size() != 0) {
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++\n");
			for (User user : ulist) {
				System.out.println("\t" + rankNum + "등 " + user.getNickname() + "님 " + "평균점수:" + user.getScore_avg()
						+ " 참가횟수:" + user.getCount() + "\n");
				rankNum += 1;
			}
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
		} else {
			System.out.println("아무도 퀴즈를 풀지 않았어요. 순위가 없어요");
		}
	}

//==============================================================================================================
	// 세번째 실행 화면
	public void start_3() {
		int menunum;
		do {
			menuTitle_3();
			menunum = ScanUtil.readInt("선택");
			switch (menunum) {
			case 1:  quizInsert();  break;
			case 2:  quizInfo();  break;
			case 4:  scoreReset();  break;
			}
		} while (menunum != 0);
		System.out.println(loginuser.getNickname() + "님 잘가세요.");
	}

	private void quizInsert() {
		Quiz quiz = new Quiz();
		quiz.setNo(quizdao.selectAll().size() + 1);
		quiz.setField(ScanUtil.readStr("분야입력"));
		quiz.setQuestion(ScanUtil.readQuestion());
		quiz.setAnswer(ScanUtil.readStr("정답입력"));
		quizdao.insert(quiz);

	}
	private void quizInfo() {
		List<Quiz> quizList=quizdao.selectAll();
		for(Quiz quiz : quizList) {
			System.out.println(quiz);
		}
	}

	private void scoreReset() {
		String string = ScanUtil.readStr("정말로 초기화 하시겠습니까? 신중히 생각 해주세요.(y/n)");
		while (true) {
			if(string.equals("y") || string.equals("Y") || string.equals("n") || string.equals("N"))
				break;
			string = ScanUtil.readStr("잘못 입력하셨습니다.다시 입력해주세요.(y/n)");
		}
		if (string.equals("Y") || string.equals("y")) {
		    userdao.scoreReset();
		    System.out.println("초기화 완료 되었습니다.");
		}else {
			System.out.println("초기화 되지 않았습니다.");
		}
	}
}
