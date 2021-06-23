package Selling;

import java.util.Scanner;

public class SaleMain {

	public static void main(String[] args) {
		
		
//		DeptManager manager = new DeptManager(DeptDao.getInstance());
		
		
		Scanner sc = new Scanner(System.in);
				
		try {
			// 1. 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			while(true) {
				System.out.println("부서관리 프로그램");
				System.out.println("-----------------------------------");
				System.out.println("1. 로그인");
				System.out.println("2. 회원가입");
				System.out.println("3. 관리자 로그인");
				System.out.println("-----------------------------------");
				System.out.println("원하시는 기능의 번호를 입력해주세요.");
				int num = Integer.parseInt(sc.nextLine());
				
				switch(num) {
				case 1 :
//					manager.deptList();
					break;
				case 2 :
//					manager.inputData();
					break;
				case 3 :
					System.out.println("프로그램을 종료합니다.");
					return;
					
				}
			}
						
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		

	}

}