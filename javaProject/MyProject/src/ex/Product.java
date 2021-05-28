package ex;

public class Product {
	
	final int price; // final 금액은 한 번 초기화 되면 변경되면 안되어서
	int bonusPoint;
	
	Product(int price) {
		this.price = price;
		bonusPoint = (int)(price/10.0);
	}
}
