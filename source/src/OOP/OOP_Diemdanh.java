package OOP;

public class OOP_Diemdanh {
	String malichhoc;
	String monhoc;
	String cahoc;
	boolean trangthai; 
	
	public OOP_Diemdanh() {
		// TODO Auto-generated constructor stub
	}
	

	public OOP_Diemdanh(String malichhoc, String monhoc, String cahoc, boolean trangthai) {
		this.malichhoc = malichhoc;
		this.monhoc = monhoc;
		this.cahoc = cahoc;
		this.trangthai = trangthai;
	}


	public String getMalichhoc() {
		return malichhoc;
	}

	public void setMalichhoc(String malichhoc) {
		this.malichhoc = malichhoc;
	}

	public String getMonhoc() {
		return monhoc;
	}

	public void setMonhoc(String monhoc) {
		this.monhoc = monhoc;
	}

	public String getCahoc() {
		return cahoc;
	}

	public void setCahoc(String cahoc) {
		this.cahoc = cahoc;
	}

	public boolean isTrangthai() {
		return trangthai;
	}

	public void setTrangthai(boolean trangthai) {
		this.trangthai = trangthai;
	}
	
}