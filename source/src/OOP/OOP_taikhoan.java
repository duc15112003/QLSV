package OOP;

public class OOP_taikhoan {
	String masinhvien;
	String tensinhvien;
	String email;
	String password;
	String anh;
	public OOP_taikhoan() {
		// TODO Auto-generated constructor stub
	}
	public OOP_taikhoan(String masinhvien, String tensinhvien, String email, String password,String anh) {
		this.masinhvien = masinhvien;
		this.tensinhvien = tensinhvien;
		this.email = email;
		this.password = password;
		this.anh = anh;
	}
	public String getMasinhvien() {
		return masinhvien;
	}
	public void setMasinhvien(String masinhvien) {
		this.masinhvien = masinhvien;
	}
	public String getTensinhvien() {
		return tensinhvien;
	}
	public void setTensinhvien(String tensinhvien) {
		this.tensinhvien = tensinhvien;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	
	
}