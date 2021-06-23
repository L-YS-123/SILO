package copy_test;

import java.util.Scanner;

public class AdminPage {

	static AdminManager adminManager = new AdminManager(MemberDao.getInstance()); // getInstance가 왜 자동으로 안나오지?
	static MemberManager memManager = new MemberManager(MemberDao.getInstance());
	static SaleManager saleManager = new SaleManager(SaleDao.getInstance());
	static MenuManager menuManager = new MenuManager(MenuDao.getInstance());

	void calling() {
		System.out.println("관리자 화면");
		System.out.println("1. 회원정보보기");
		System.out.println("2. 판매정보보기");
		System.out.println("3. 메뉴정보보기");
		Scanner sc = new Scanner(System.in);

		int num2 = Integer.parseInt(sc.nextLine().trim());

		switch (num2) {
		case 1:
			adminManager.memList();
		case 2:
//			saleManager.saleList();
			adminManager.saleList();
		case 3:
//			menuManager.menuList();
			adminManager.menuList();
			break;
		}
	}

}
