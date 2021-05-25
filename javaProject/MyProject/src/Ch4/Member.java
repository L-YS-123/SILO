package Ch4;
import java.util.Scanner;

public class Member {
	static Scanner scanner = new Scanner(System.in);
	static int year = scanner.nextInt();

	public static void testMethod() {

		if ((2021 - year) < 15 || (2021 - year) > 64) {
			System.out.println("무료예방접종이 가능합니다.");
		} else {
			System.out.println("무료접종 대상이 아닙니다.");
		}

		if ((2021 - year) > 19) {
			if ((2021 - year) % 2 == 0) {
				System.out.println("검사 대상입니다.");
			} else {
				System.out.println("검사 대상이 아닙니다.");
				if ((2021 - year) > 39) {
					System.out.println("무료 암 검사 대상입니다.");
				}
			}
		}
	}

	public static void main(String[] args) {
		testMethod();
	}
}
