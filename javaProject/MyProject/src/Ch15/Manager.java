package Ch15;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
2.앞 Chapter에서 만들어본 축구선수 정보 파일로 저장하는 프로그램을 만들어 봅시다.
①축구선수 정보 인스턴스를 List<E>에 저장하는 프로그램을 만들어 봅시다.
②이 인스턴스 들을 파일로 저장하는 기능을 만들어 봅시다.
③저장된 파일을 객체로 만드는 기능을 만들어봅시다.
 */
public class Manager {

	public static void main(String[] args) {

		List<FootballPlayer> list = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);

		System.out.println("값을 입력하려면 true를 입력하세요");

		String input = scanner.nextLine();

		if (input.equals("true")) {

			System.out.println("이름, 등번호, 팀, 나이를 순서대로 입력해주세요.");

			for (int i = 0; i < Integer.MAX_VALUE; i++) {
				
//				scanner.nextInt(); // nextInt()는 개행문자(Enter 키)를 처리하지 않기 때문에 오류가 남
				
				String name = scanner.nextLine();
				int number = scanner.nextInt();
				scanner.nextLine(); // 엔터키를 처리해주기 위한 스캐너
				String team = scanner.nextLine();
				int age = scanner.nextInt();
				scanner.nextLine();// 엔터키를 처리해주기 위한 스캐너

				list.add(new FootballPlayer(name, number, team, age));
				System.out.println(list.get(i));
			}
		}

	}



}
