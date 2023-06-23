package OOP;

public class OOP_DiemDanhAdmin {
	
	String masv;
	String malichhoc;
	String anh;
	boolean tinhtrang;
	String cahoc;
	String malop;
	
	public OOP_DiemDanhAdmin() {
		// TODO Auto-generated constructor stub
	}
	
	public OOP_DiemDanhAdmin(String masv, String malichhoc, String anh, boolean tinhtrang, String cahoc, String malop) {
		this.masv = masv;
		this.malichhoc = malichhoc;
		this.anh = anh;
		this.tinhtrang = tinhtrang;
		this.cahoc = cahoc;
		this.malop = malop;
	}

	public String getMasv() {
		return masv;
	}

	public void setMasv(String masv) {
		this.masv = masv;
	}

	public String getMalichhoc() {
		return malichhoc;
	}

	public void setMalichhoc(String malichhoc) {
		this.malichhoc = malichhoc;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public boolean isTinhtrang() {
		return tinhtrang;
	}

	public void setTinhtrang(boolean tinhtrang) {
		this.tinhtrang = tinhtrang;
	}

	public String getCahoc() {
		return cahoc;
	}

	public void setCahoc(String cahoc) {
		this.cahoc = cahoc;
	}

	public String getMalop() {
		return malop;
	}

	public void setMalop(String malop) {
		this.malop = malop;
	}
	

}
