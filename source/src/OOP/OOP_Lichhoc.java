package OOP;

public class OOP_Lichhoc {
	 public String masv;
	 public String ngayhoc;
	 public String cahoc;
	 public String thoigian;
	 public String malichhoc;
	 public String PhongHoc;
	 public String mamonhoc;
	
	public OOP_Lichhoc() {
		// TODO Auto-generated constructor stub
	}
	
	public OOP_Lichhoc(String masv, String ngayhoc, String cahoc, String thoigian, String malichhoc, String phongHoc,String mamonhoc) {
		this.masv = masv;
		this.ngayhoc = ngayhoc;
		this.cahoc = cahoc;
		this.thoigian = thoigian;
		this.malichhoc = malichhoc;
		this.PhongHoc = phongHoc;
		this.mamonhoc = mamonhoc;
	}

	public OOP_Lichhoc(String ngayhoc, String cahoc, String thoigian, String malichhoc, String phongHoc,String mamonhoc) {
		this.ngayhoc = ngayhoc;
		this.cahoc = cahoc;
		this.thoigian = thoigian;
		this.malichhoc = malichhoc;
		this.PhongHoc = phongHoc;
		this.mamonhoc = mamonhoc;
	}
	public String getMasv() {
		return masv;
	}
	public void setMasv(String masv) {
		this.masv = masv;
	}
	public String getNgayhoc() {
		return ngayhoc;
	}

	public void setNgayhoc(String ngayhoc) {
		this.ngayhoc = ngayhoc;
	}

	public String getCahoc() {
		return cahoc;
	}

	public void setCahoc(String cahoc) {
		this.cahoc = cahoc;
	}

	public String getThoigian() {
		return thoigian;
	}

	public void setThoigian(String thoigian) {
		this.thoigian = thoigian;
	}

	public String getMalichhoc() {
		return malichhoc;
	}

	public void setMalichhoc(String malichhoc) {
		this.malichhoc = malichhoc;
	}

	public String getPhongHoc() {
		return PhongHoc;
	}

	public void setPhongHoc(String phongHoc) {
		PhongHoc = phongHoc;
	}

	public String getMamonhoc() {
		return mamonhoc;
	}

	public void setMamonhoc(String mamonhoc) {
		this.mamonhoc = mamonhoc;
	}

}
