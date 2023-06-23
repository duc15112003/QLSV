package OOP;

public class OOP_Sinhvien {
	
	String masv;
	String tensv;
	String malop;
	String gioitinh;
	String ngaysinh;
	String diachi;
	String email;
	String anh;
	
	public OOP_Sinhvien() {
		
	}
	public OOP_Sinhvien(String masv,String tensv,String malop,String gioitinh,String ngaysinh,String diachi,String email,String anh) {
		this.masv = masv;
		this.tensv = tensv;
		this.malop = malop;
		this.gioitinh = gioitinh;
		this.ngaysinh = ngaysinh;
		this.diachi = diachi;
		this.email = email;;
		this.anh = anh;
	}
	
	public String getMasv() {
		return masv;
	}
	public void setMasv(String masv) {
		this.masv = masv;
	}
	public String getTensv() {
		return tensv;
	}
	public void setTensv(String tensv) {
		this.tensv = tensv;
	}
	public String getMalop() {
		return malop;
	}
	public void setMalop(String malop) {
		this.malop = malop;
	}
	public String getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	public String getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	
}