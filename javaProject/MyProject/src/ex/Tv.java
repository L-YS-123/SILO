package ex;

public class Tv extends Product {
	
	Tv(int price) {
		super(price);
	}

	@Override
	public String toString() {
		return "Tv [price=" + price + ", bonusPoint=" + bonusPoint + "]";
	}
	
	
}
