package copy_test;

import java.util.Scanner;

public class AdminPage {

	AdminManager adminManager = new AdminManager(MemberDao.getInstance()); 
	MemberManager memManager = new MemberManager(MemberDao.getInstance());
	SaleManager saleManager = new SaleManager(SaleDao.getInstance());
	MenuManager menuManager = new MenuManager(MenuDao.getInstance());
//	AppMain appMain = new AppMain();
	

	void calling() {
		
		
		Scanner sc = new Scanner(System.in);
		

		while(true) {
			System.out.println("관리자 화면");
			System.out.println("0. 첫 번재 화면으로 돌아가기");
			System.out.println("1. 회원정보보기");
			System.out.println("2. 판매정보보기");
			System.out.println("3. 메뉴정보보기");
			
			int num2 = Integer.parseInt(sc.nextLine().trim());
			
			switch (num2) {
			case 0:
				//appMain.SubMain();
				return;
			case 1:
//				appMain.memManager.memList();
				memManager.memList();
				break;
			case 2:
				saleManager.saleList();
//				adminManager.saleList();
				break;
			case 3:
				menuManager.menuList();
//				adminManager.menuList();
				break;
			}
		}
			
		

	}

}
