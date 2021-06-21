package Ch15;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveMethod {

	public void Saving() {
		// ①축구선수 정보 인스턴스를 List<E>에 저장하는 프로그램을 만들어 봅시다.
		List<FootballPlayer> list = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);

		System.out.println("값을 입력하려면 true를, 종료하려면 false를 입력하세요");

		String input = scanner.nextLine();

		if (input.equals("true")) {

			for (int i = 0; i < Integer.MAX_VALUE; i++) {

				System.out.println("이름, 등번호, 팀, 나이를 순서대로 입력해주세요.");
				System.out.println("종료하려면 false를 입력하세요 ");

				String name = scanner.nextLine();

				if (name.equals("false")) {
					break;
				}

				int number = scanner.nextInt();// nextInt()는 개행문자(\n, Enter 키)를 처리하지 않음 -> 입력 오류

				scanner.nextLine(); // 엔터키를 처리해주기 위한 스캐너

				String team = scanner.nextLine();

				int age = Integer.parseInt(scanner.nextLine()); // Integer.parseInt() 를 사용해서 처리할 수도 있음

				list.add(new FootballPlayer(name, number, team, age));
				System.out.println("-저장되었습니다.-");
				System.out.println(list.get(i));
				System.out.println();
			}
		} else if (input.equals("false")) {
			System.out.println("프로그램을 종료합니다.");
		}
	}
}
