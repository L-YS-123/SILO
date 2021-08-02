package member.main;

import java.util.Scanner;

import member.dao.MemberDao;
import member.domain.RegRequest;
import member.service.ChangePasswordService;
import member.service.MemberRegService;

public class MainForMembermanager {
	
	static MemberDao dao = new MemberDao();

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			printMenu();
			
			String command = sc.nextLine();
			// 프로그램의 종료 분기
			if(command.equalsIgnoreCase("exit")) {
				System.out.println("프로그램 종료");
				return;
			}
			
			if(command.startsWith("new" )) {
// 띄어쓰기로 자르기 -> ex)values[0] = new, values[1] = king@gmail.com
				String[] values = command.split(" ");
				processNewMember(values);
				continue;
			}
			
			if(command.startsWith("change")) {
				String[] values = command.split(" ");
				processChangePw(values);
			}
			
		}
	}
	
	private static void processChangePw(String[] values) {
		ChangePasswordService service = new ChangePasswordService(dao);
		
		try {
			service.changePassword(values[1], values[2], values[3]);
			System.out.println("비밀번호를 변경했습니다");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}

	private static void processNewMember(String[] values) {
		// MemberRegService 이용해서 정보 저장
		
		MemberRegService service = new MemberRegService(dao);
		RegRequest request = new RegRequest();
		
		request.setEmail(values[1]);
		request.setName(values[2]);
		request.setPassword(values[3]);
		request.setConfirmPassword(values[4]);
		
		if(!request.isPasswordEqualToConfirmPassword()) {
			System.out.println("비밀번호와 비밀번호 확인이 일치하지 않습니다");
			return;
		}
		
		try {
			service.regMember(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}

	static void printMenu() {
		System.out.println();
		System.out.println("명령어 사용법");
		System.out.println("회원등록---------------------");
		System.out.println("new 이메일 이름 비밀번호 비밀번호확인");
		System.out.println("new king@gmail.com king 123 123");
		System.out.println("회원수정---------------------");
		System.out.println("change 이메일 현재비번 새로운비번");
		System.out.println("change king@gmail.com 123 2222");
		System.out.println("---------------------------");
		
	}
}
