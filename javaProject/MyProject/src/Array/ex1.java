package Array;
import java.util.Scanner;
//문제 1.
//int형 1차원 배열을 매개변수로 전달 받아서 배열에 저장된 최대값,그리고 최소값을 구해서 반환하는 메소드를 다음의 형태로 각각 정의.
//int형 배열에 채워질 정수는 프로그램 사용자로부터 입력 받고,배열의 길이는임의로 결정
//위의 두 매소드는 인자로 전달되는 배열의 길이에 상관없이 동작하도록 정의.
//두 매소드 실행을 확인인하기 위한 main 메소드 정의.
public class ex1 {

	public static int miniValue(int[] arr) { // public static int miniValue(int[] arr) { . . . . } // 최소값 반환
		Scanner scanner = new Scanner(System.in);
		
		int min = Integer.MAX_VALUE; //  항상 0이 나오는데 여기가 문제??
		for (int i = 0; i<arr.length; i++) {
			arr[i] = scanner.nextInt();
			if (min > arr[i]) {
				min = arr[i];
			}
		}
		System.out.println(min);
		return min;
	}

	public static int maxValue(int[] arr) { // public static int maxValue(int[] arr) { . . . . } // 최대값 반환
		int max = Integer.MIN_VALUE;
		for (int i = 0; i<arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		System.out.println(max);
		return max;
	}

	public static void main(String[] args) {
		int[] test = new int[5];
		int ref;
		ref = miniValue(test);
		ref = maxValue(test);
	}

}
// 강사님 배열을 매개변수로 갖는 메소드를 호출하려면 어떻게 해야하나요?
// 영진유 님으로부터(비공개): 오후 6:00
// 매개변수 타입에 맞는 배열을 생성하고 그 배열의 주소값을 매소드 호출시에 전달하면 됩니다.