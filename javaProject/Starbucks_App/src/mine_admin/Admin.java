package mine_admin;

public class Admin {
	private int adminCode;
	private String name;
	private String id;
	private String pw;
	private String address;
	private String phone;
	

	public Admin(int memcode, String name, String id, String pw, String address, String phone) {
		super();
		this.adminCode = memcode;
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.address = address;
		this.phone = phone;
		
	}
	
	public Admin(String name, String id, String pw, String address, String phone) {
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.address = address;
		this.phone = phone;
	}
	
	public Admin(String name, String pw, String address, String phone) {
		this.name = name;
		this.pw = pw;
		this.address = address;
		this.phone = phone;
	}
	
	public Admin(String id) {
		this.id = id;
	}
	

	public int getMemcode() {
		return adminCode;
	}

	public void setMemcode(int memcode) {
		this.adminCode = memcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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





	@Override
	public String toString() {
		return "Member [memcode=" + adminCode + ", name=" + name + ", id=" + id + ", pw=" + pw + ", address=" + address
				+ ", phone=" + phone + ", point=" + "]";
	}
}
