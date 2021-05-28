package Array;

import java.util.Arrays;

//다음의 형태로 표현된 2차원 배열이 존재한다고 가정해 보자.
//1 2 3
//4 5 6
//7 8 9
//이러한 형태를 갖는 int형 2차원 배열이 인자로 전달되면, 다음의 형태로 배열의 구조를 변경시키는 메서드를 정의해 보자.
//7 8 9
//1 2 3
//4 5 6
//즉 총 N행으로 이뤄진 2차원 배열이 존재한다면, 메서드 호출 시, 1행은 2행으로 이동이 이뤄져야한다. 이번에도 마찬가지로 배열의 가로, 세로길이에 상관 없이 동작을 하도록 메서드가 정의되어야 하며, 정의된 메서드의 확인을 위한 main메서드도 함께 정의하자.
public class ex3 {
	
	public static int[][] movement(int[][] arr) { 
		int[] tmp = {0,0,0};
		int[][] arr3 = arr;
		
		for (int i = 0; i < arr.length; i++) {				// n개 일 때 전개 방식??
			for (int j = 0; j < arr[i].length; j++) {
				tmp[j] = arr[0][j];
				arr[0][j] = arr[2][j];
				arr[2][j] = arr[1][j];
				arr[1][j] = tmp[j];
			} break;
			
		}
		System.out.println(Arrays.deepToString(arr3));
		return arr3;
		
	}
	
	public static void main(String[] args) {
		int[][] test4 = { 	{ 1, 2, 3 },
							{ 4, 5, 6 },
							{ 7, 8, 9 }	 };
		int[][] test5;
		test5 = movement(test4);
		
		
	}

}
// 제가 원하는 결과는 {{7,8,9},{1,2,3},{4,5,6}} 인데 {{1,2,3},{4,5,6},{7,8,9}} 가 나오네요 
//breakpoint 로 단계별로 보세요.
//i 루프 때문에 3번 반복하면 될걸 9번 반복해서 그렇습니다.