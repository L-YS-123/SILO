package Selling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Order {
	
	
	
	public void Ordering() { // 1.주문하기

		Scanner sc = new Scanner(System.in);
		System.out.println("주문을 하시려면 1을 입력하세요");
		int text1 = sc.nextInt();

		System.out.println("==========메뉴를 선택해 주십시오.===========");
		System.out.println("  1. 아메리카노  2500원");
		System.out.println("  2. 카페라테     3500원");
		System.out.println("  3. 카페모카     4000원");
		System.out.println();
		System.out.println("    선택을 완료하셨다면 4를 입력해주세요");
		System.out.println("======================================");

		Calculator calc = new Calculator();
		
		while (text1 == 1) {
			calc.Calculate();
			
			if (calc.k == 4) {
				break;
			}
		}

				
		
			

		
			
			
		
	}

}
