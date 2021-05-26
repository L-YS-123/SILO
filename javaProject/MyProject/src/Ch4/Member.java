package Ch4;

import java.util.Scanner;

public class Member {
	
	Scanner scanner = new Scanner(System.in);	// scanner는 main 구동부에서 선언하는게 좋다
	int year = scanner.nextInt();	// 입력이 안 되었을 때 실행이 안된다고(아무 반응이 없다고) 착각할 수도 있기 때문

	public void testMethod() {

		if ((2021 - year) < 15 || (2021 - year) > 64) {
			System.out.println("무료예방접종이 가능합니다.");
		} else {
			System.out.println("무료접종 대상이 아닙니다.");
		}

		if ((2021 - year) > 19) {
			if ((2021 - year) % 2 != 0) {
				System.out.println("검사 대상이 아닙니다.");
			} else {
				System.out.println("검사 대상입니다.");
				if ((2021 - year) > 39) {
					System.out.println("무료 암 검사 대상입니다.");
				}
			}
		}
	}

	public static void main(String[] args) {
		 Member t = new Member(); 
		 t.testMethod();
	}
}

