// 판매상품정보

package Selling;

public class Sale {
	private int saleCode;
	private String sname;
	private int price;
	private String saleDate;
	private int memCode;
	
	private double point;
	
	public Sale(int saleCode ,String sname, int price) {
		this.saleCode = saleCode;
		this.sname = sname;
		this.price = price;
	}


	public int getSaleCode() {
		return saleCode;
	}

	public void setSaleCode(int saleCode) {
		this.saleCode = saleCode;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}

	public int getMemCode() {
		return memCode;
	}

	public void setMemCode(int memCode) {
		this.memCode = memCode;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "SaleInfo [saleCode=" + saleCode + ", sname=" + sname + ", price=" + price + ", saleDate=" + saleDate
				+ ", memCode=" + memCode + ", point=" + point + "]";
	}

}
