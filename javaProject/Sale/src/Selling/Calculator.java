package Selling;

import java.util.Scanner;

public class Calculator {
	
	int americanoPrice = 2500;
	int cafelattePrice = 3500;
	int cafemoccaPrice = 4000;

	static int countAmericano=0;
	static int countCaffelatte=0;
	static int countCaffeMocca=0;
	
	static int price = 0;
	static int totalPrice = 0;
	
	static int point=0; // 포인트적립

	
	Scanner sc = new Scanner(System.in);
	int k ;

	public void Calculate() {
		
		k = sc.nextInt();
		
		if (k == 1) {
			System.out.println("아메리카노 " + americanoPrice + "원");
			totalPrice += americanoPrice;
			countAmericano ++;
			point += 0.01 * americanoPrice;
			
		} else if (k == 2) {
			System.out.println("카페라테 " + cafelattePrice + "원");
			totalPrice += cafelattePrice;
			countCaffelatte ++;
			point += 0.01 * cafelattePrice;
			
		} else if (k == 3) {
			System.out.println("카페모카 " + cafemoccaPrice + "원");
			totalPrice += cafemoccaPrice;
			countCaffeMocca ++;
			point += 0.01 * cafemoccaPrice;
			
		} else if (k == 4) {
			System.out.print("아메리카노 갯수:"+countAmericano);
			System.out.print("    카페라테 갯수:"+ countCaffelatte);
			System.out.print("    카페모카 갯수:"+ countCaffeMocca);
			System.out.println();
			System.out.println("총액: "+totalPrice+"원"+"   적립금: "+ point +"점"); // 포인트 적립
			
		}
		
		
	}

}
