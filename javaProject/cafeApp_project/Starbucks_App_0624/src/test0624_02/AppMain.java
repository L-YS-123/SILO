package test0624_02;

import java.util.Scanner;

public class AppMain {

	static MemberManager memManager = new MemberManager(MemberDao.getInstance());
	static SaleManager saleManager = new SaleManager(SaleDao.getInstance());
	static Login login = new Login(MemberDao.getInstance());
	static Point point = new Point();
	static AdminPage admin = new AdminPage();

	
	void Submain() {

		Scanner sc = new Scanner(System.in);

		try {
			// 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 가장 첫번째 화면
			System.out.println("로그인 화면");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 관리자모드");
			
			int num = Integer.parseInt(sc.nextLine().trim());
			switch (num) {
			case 1:
				System.out.println("회원가입을 진행하시려면 1번을, 다시 돌아가시려면 0번을 눌러주세요");
				int num2 = Integer.parseInt(sc.nextLine().trim());
				
				if (num2 == 0) {
					return;
				} else if (num2 == 1) {
					memManager.memAdd();
					login.chkLogin();
					break;
				}
				
				
			case 2:
				System.out.println("로그인을 진행하시려면 1번을, 다시 돌아가시려면 0번을 눌러주세요");
				int num3 = Integer.parseInt(sc.nextLine().trim());
				
				if(num3 == 0) {
					return;
				} else if(num3 == 1) {
					login.chkLogin();
					break;
				}
			
			case 3:
				System.out.println("관리자모드를 진행하시려면 1번을, 다시 돌아가시려면 0번을 눌러주세요");
				int num4 = Integer.parseInt(sc.nextLine().trim());
				
				if(num4 == 0) {
					return;
				} else if(num4 == 1) {
					admin.calling();
					break;
				}
				
			default:
				System.out.println("잘못 눌렀습니다.");
			}

			// 회원 모드

//			while (true) {
//				System.out.println("1. 주문하기");
//				System.out.println("2. 포인트 확인");
//				System.out.println("3. 내 정보 확인");
//				num = Integer.parseInt(sc.nextLine().trim());
//
//				switch (num) {
//				case 1:
//					// 주문하기
//					saleManager.order(login.currentId);
//					break;
//				case 2:
//					// 포인트 확인하기
//					int havePoint = point.readPoint(login.currentId);
//					System.out.println("현재 사용가능한 포인트 : " + havePoint);
//					break;
//				case 3:
//					// 내 정보 확인하기
//					memManager.myInfo(login.currentId);
//
//					System.out.println("1. 정보수정");
//					System.out.println("2. 회원탈퇴");
//
//					// 사용자 선택
//					num = Integer.parseInt(sc.nextLine().trim());
//
//					switch (num) {
//					case 1:
//						// 1. 정보 수정
//						memManager.memEdit();
//						break;
//					case 2:
//						/// 2. 회원 탈퇴
//						memManager.memDel();
//						return;
//					}
//				}
//			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}
