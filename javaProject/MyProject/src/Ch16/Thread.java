package Ch16;

import java.util.Scanner;
//1.10초 안에 맞추는 하이로우 게임을 만들어 봅시다.
//
//①1~100 사이의 랜덤 한 숫자를 추출합니다.
//
//②사용자에게 숫자를 입력 받고, 랜덤 숫자와 비교하고, 높은 숫자인지 낮은 숫자인지 출력
//
//③10초 카운팅은 스레드를 이용해서 처리해봅시다.
//
//④10초 이전에 맞추면 미션 성공, 10초가 지나면 프로그램 종료하는 흐름으로 만들어봅시다.

class Random {
	Scanner sc = new Scanner(System.in);

	void random() {

		int A = (int) (Math.random() * 100 + 1);
		int B = sc.nextInt();

		if (A > B) {

		}
	}
}

public class Thread {
	public static void main(String[] args) {
		
	}
}
