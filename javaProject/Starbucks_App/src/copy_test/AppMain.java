package copy_test;

import java.util.Scanner;

public class AppMain {

	MemberManager memManager = new MemberManager(MemberDao.getInstance());
	SaleManager saleManager = new SaleManager(SaleDao.getInstance());
//	MenuManager menuManager = new MenuManager(MenuDao.getInstance());
	AdminPage adminPage = new AdminPage();

	static String currentId;

	
	// AdminFirstPage에서 호출하는 SubMain() 메소드 입니다 
	// 첫 번째 화면을 불러오는 역할을 합니다.
	void SubMain() {

		Scanner sc = new Scanner(System.in);
		int num=0;
		
		try {
			// 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			while(true) {
				//첫 번째 화면
				System.out.println("로그인 화면");
				System.out.println("1. 회원가입");
				System.out.println("2. 로그인");
				System.out.println("3. 관리자모드");
				num = Integer.parseInt(sc.nextLine().trim()); // Scanner에서 입력받은 값을 switch-case에 전달합니다

				switch (num) {
				case 1:
					memManager.memAdd();
					currentId = memManager.chkLogin(); // 로그인한후 id를 static 변수로 저장

					break;
				case 2:
					memManager.chkLogin();
					break;

				case 3:
					adminPage.calling();
					break;
				default:
					System.out.println("잘못 눌렀습니다.");
				}
			}
			
//				System.out.println("1. 주문하기");
//				System.out.println("2. 포인트확인");
//				System.out.println("3. 내 정보 확인");
//				num = Integer.parseInt(sc.nextLine().trim());
//
//				switch (num) {
//				case 1:
//					saleManager.order();
//					break;
//				case 2:
//					memManager.memPoint();
//					break;
//				case 3:
//					memManager.myInfo();
//					System.out.println("1. 정보수정");
//					System.out.println("2. 회원탈퇴");
//					num = Integer.parseInt(sc.nextLine().trim());
//					switch (num) {
//					case 1:
//						memManager.memEdit();
//						break;
//					case 2:
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