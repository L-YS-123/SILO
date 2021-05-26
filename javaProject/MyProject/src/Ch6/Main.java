package Ch6;

public class Main {
	
	public static void main(String[] args) {
//		1.국어, 영어, 수학 점수 10개씩을 저장하는 배열을 정의하고 점수를 모두 출력하고, 
//		평균 점수를 출력하는 프로그램을 작성해봅시다.
		int[] korScore = new int[10];
		int[] engScore = new int[10];
		int[] mathScore = new int[10];
		
		korScore[0] = 100;
		korScore[1] = 60;
		korScore[2] = 72;
		korScore[3] = 86;
		korScore[4] = 48;
		korScore[5] = 39;
		korScore[6] = 97;
		korScore[7] = 52;
		korScore[8] = 23;
		korScore[9] = 66;
		
		for(int i=0; i<korScore.length; i++) {
			System.out.print(korScore[i] + " ");		
		}
		System.out.println();
		int sum = 0;
		for(int i=0; i<korScore.length; i++) {
			sum = sum + korScore[i];
		}
		System.out.print("국어 점수의 평균합: "+ (float)sum/korScore.length);
		
		

	}

}
