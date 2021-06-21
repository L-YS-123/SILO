public class SaleInfo {
	private int memcode;
	private String name;
	private String ID;
	private String pw;
	private String address;
	private String phone;
	private double point;
	
	public int getMemcode() {
		return memcode;
	}
	public void setMemcode(int memcode) {
		this.memcode = memcode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public double getPoint() {
		return point;
	}
	public void setPoint(double point) {
		this.point = point;
	}
	@Override
	public String toString() {
		return "SaleClass [memcode=" + memcode + ", name=" + name + ", ID=" + ID + ", pw=" + pw + ", address=" + address
				+ ", phone=" + phone + ", point=" + point + "]";
	}
	
	
}