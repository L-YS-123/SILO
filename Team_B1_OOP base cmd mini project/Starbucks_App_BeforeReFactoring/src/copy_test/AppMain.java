package copy_test;

import java.util.Scanner;

public class AppMain {

	static AdminManager adminManager = new AdminManager(MemberDao.getInstance()); // getInstance가 왜 자동으로 안나오지?
	static MemberManager memManager = new MemberManager(MemberDao.getInstance());
	static SaleManager saleManager = new SaleManager(SaleDao.getInstance());
	static MenuManager menuManager = new MenuManager(MenuDao.getInstance());
	static AdminPage adminPage = new AdminPage();

	static String currentId;

	public static void main(String[] args) {

		
			Scanner sc = new Scanner(System.in);

			try {
				// 드라이버 로드
				Class.forName("oracle.jdbc.driver.OracleDriver");

				System.out.println("로그인 화면");
				System.out.println("1. 회원가입");
				System.out.println("2. 로그인");
				System.out.println("3. 관리자모드");
				int num = Integer.parseInt(sc.nextLine().trim());

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

				default:
					System.out.println("잘못 눌렀습니다.");
				}

			

			while (true) {
				System.out.println("1. 주문하기");
				System.out.println("2. 포인트확인");
				System.out.println("3. 내 정보 확인");
				num = Integer.parseInt(sc.nextLine().trim());

				switch (num) {
				case 1:
					saleManager.order();
					break;
				case 2:
					memManager.memPoint();
					break;
				case 3:
					memManager.myInfo();
					System.out.println("1. 정보수정");
					System.out.println("2. 회원탈퇴");
					num = Integer.parseInt(sc.nextLine().trim());
					switch (num) {
					case 1:
						memManager.memEdit();
						break;
					case 2:
						memManager.memDel();
						return;				
					}
				}
			}
		}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		
	}
}